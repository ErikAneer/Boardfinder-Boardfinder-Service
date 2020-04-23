package boardFinder.demo.service;

import boardFinder.demo.domain.BoardSearch;
import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.SnowboardSizeSpecs;
import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.event.BoardDisplayedEvent;
import boardFinder.demo.event.BoardDisplayedEventDispatcher;
import boardFinder.demo.event.BoardSearchedEvent;
import boardFinder.demo.event.BoardSearchedEventDispatcher;
import boardFinder.demo.repository.CustomSnowboardRepository;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.SnowboardRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for the Snowboard Entity class.
 * @author Erik
 */
@Service
public class SnowboardService {

    private SnowboardRepository snowboardRepo;
    private List<Snowboard> currentList;
    private List<Snowboard> filteredList;
    private List<Snowboard> alternativeFilteredList;

    private ShoeSizeRepository shoeSizeRepository;
    private ShoeSize riderShoeSize;
    private int riderWeight;
    private Snowboard selectedSnowboard;
    List<String> recommendedLengths = new ArrayList();
    
    private BoardSearchedEventDispatcher eventDispatcher;
    private BoardDisplayedEventDispatcher displayedBoardEventDispatcher;
    
    
   //Testing SQL query
    private CustomSnowboardRepository customSnowboardRepository;

    @Autowired
    public SnowboardService(SnowboardRepository snowboardRepo, ShoeSizeRepository shoeSizeRepository, 
                final BoardSearchedEventDispatcher eventDispatcher, final BoardDisplayedEventDispatcher displayedBoardEventDispatcher,
                CustomSnowboardRepository customSnowboardRepository) {
        this.snowboardRepo = snowboardRepo;
        this.shoeSizeRepository = shoeSizeRepository;
        this.eventDispatcher = eventDispatcher;
        this.displayedBoardEventDispatcher = displayedBoardEventDispatcher;
        this.customSnowboardRepository =  customSnowboardRepository;
    }

    @PostConstruct
    public List<Snowboard> getAllSnowboards() {
        currentList = snowboardRepo.getAllSnowboards();
        filteredList = new ArrayList<>(currentList);
        return currentList;
    }

    /** 
     * Gets the RiderShoesize by the EU shoesize as double
     * @param shoeSize as double (EU size)
     * @return ShoeSize
     */
    public ShoeSize findRiderShoeSize(double shoeSize) {
        riderShoeSize = null;
        return shoeSizeRepository.findByEuSize(shoeSize);

    }

    /** 
     * Resets the list of Snowboards to filter.
     * @return list of all Snowboards
     */
    public List<Snowboard> resetFilteredList() {
        filteredList = new ArrayList<>(currentList);
        return filteredList;
    }

    /** 
     * Resets the list of Snowboards to filter for alternative filter.
     * @return list of all Snowboards
     */
    public List<Snowboard> resetAlternativeFilteredList() {
        alternativeFilteredList = new ArrayList<>(currentList);
        return alternativeFilteredList;
    }

    /** 
     * Gets a snowboard by it's id. 
     * @param id as Long
     * @return Snowboard.
     */
    public Snowboard filterById(long id) {
        return snowboardRepo.findById(id);
    }
    
    /** 
     * Gets a snowboard to display in the client by it's id 
     * and sends stats about the displayed snowboard to the RabbitMQ Message Broker. 
     * @param id
     * @return 
     */
    @Transactional
    public Snowboard findBoardById(long id) {
        Snowboard board = snowboardRepo.findById(id);
        String bend = board.getTechDetails().stream().filter(td -> "bend".equalsIgnoreCase(td.getTechDetailType())).collect(Collectors.toList()).get(0).getName();
        displayedBoardEventDispatcher.sendBoardDisplayedEvent(
                new BoardDisplayedEvent(id, board.getName(), board.getBoardBrand().getBrandName(), board.getBoardGender().getSex(), bend));  
        return board;
    }
    
    /** 
     * Gets a list of Snowboards by a String array of ids.
     * @param ids as a String array
     * @return list of matching Snowboards.
     */
     public List<Snowboard> filterByIds(String[] ids) {
            List<Snowboard> snowboards = new ArrayList();
            List<String> idList = Arrays.asList(ids);
            idList.forEach(i -> {
                snowboards.add(snowboardRepo.findById(Long.parseLong(i)));   
            });
            return snowboards;
    }
    
    /** 
     * Filters a list of Snowboards by rider gender as String. 
     * @param snowboardList to filter 
     * @param riderGender to filter by
     * @return the filtered list of Snowboards. 
     */
    List<Snowboard> filterByGender(List<Snowboard> snowboardList, String riderGender) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardGender().getSex().equalsIgnoreCase(riderGender)).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     *  Filters a list of Snowboards by rider weight as int. 
     * @param snowboardList to filter
     * @param riderWeight as int
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByRiderWeight(List<Snowboard> snowboardList, int riderWeight) {
        snowboardList = snowboardList.stream()
                .filter((s) -> s.getBoardSizeSpecs().stream().anyMatch(b -> b.getRiderWeightMin() <= riderWeight && b.getRiderWeightMax() >= riderWeight)).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of Snowboards by shoesize as double.
     * @param snowboardList to filter.
     * @param shoeSize as double.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByShoeSize(List<Snowboard> snowboardList, double shoeSize) {
        riderShoeSize = findRiderShoeSize(shoeSize);
        snowboardList = snowboardList.stream()
                .filter((s) -> s.getBoardSizeSpecs().stream().anyMatch(b -> b.getWaistWidth() <= riderShoeSize.getWaistWidthMax() && b.getWaistWidth() >= riderShoeSize.getWaistWidthMin())).collect(Collectors.toList());

        return snowboardList;
    }

    /** 
     * Filters a list of Snowboards by rider level as String.
     * @param snowboardList to filter. 
     * @param riderLevel as String.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByRiderLevel(List<Snowboard> snowboardList, String riderLevel) {
        snowboardList = snowboardList.stream()
                .filter((b) -> b.getRiderLevels().stream().anyMatch(rl -> rl.getRiderLevel().equalsIgnoreCase(riderLevel))).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of snowboards by riding terrain as String and rider gender as String.
     * @param snowboardList to filter.
     * @param ridingType as String.
     * @param gender as String.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByRidingTerrain(List<Snowboard> snowboardList, String ridingType, String gender) {
        
        if (gender.equalsIgnoreCase("kids")) {
             snowboardList = snowboardList.stream()
                .filter((b) -> b.getRidingterrains().stream().anyMatch(rt -> rt.getRidingType().getRidingTypeName().equalsIgnoreCase(ridingType) && rt.getValue() > 3)).collect(Collectors.toList());
        return snowboardList;
        }
        
        snowboardList = snowboardList.stream()
                .filter((b) -> b.getRidingterrains().stream().anyMatch(rt -> rt.getRidingType().getRidingTypeName().equalsIgnoreCase(ridingType) && rt.getValue() > 5)).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of snowboards by shape name as String.
     * @param snowboardList to filter.
     * @param shape name as String.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByShape(List<Snowboard> snowboardList, String shape) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getTechDetails().stream().anyMatch(td -> td.getName() .equalsIgnoreCase(shape))).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of snowboards by brand name as String.
     * @param snowboardList to filter.
     * @param brand name as String.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByBrand(List<Snowboard> snowboardList, String brand) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardBrand().getBrandName().equalsIgnoreCase(brand)).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of snowboards by flex as String.
     * @param snowboardList to filter
     * @param flex name as String 
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByFlex(List<Snowboard> snowboardList, String flex) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getTechDetails().stream().anyMatch(td ->  td.getName() .equalsIgnoreCase(flex))).collect(Collectors.toList());
        return snowboardList;
    }

    /** 
     * Filters a list of snowboards by bend as String and rider gender as String.
     * @param snowboardList to filter 
     * @param bend name as String
     * @param gender as String.
     * @return the filtered list of Snowboards.
     */
    List<Snowboard> filterByBend(List<Snowboard> snowboardList, String bend, String gender) {
       
        if(gender.equalsIgnoreCase("kids") && bend.equalsIgnoreCase("Flat Top™")) {
            snowboardList = snowboardList.stream()
                .filter(s -> s.getTechDetails().stream().anyMatch(td -> td.getName() .equalsIgnoreCase("Flat Top™ with Easy Bevel") || td.getName() .equalsIgnoreCase("Flat Top™"))).collect(Collectors.toList());
            return snowboardList;
        }
        
        snowboardList = snowboardList.stream()
                .filter(s -> s.getTechDetails().stream().anyMatch(td -> td.getName() .equalsIgnoreCase(bend))).collect(Collectors.toList());
        return snowboardList;
    }

    //Alternative filter methods
    List<Snowboard> filterByAlternativeBend(List<Snowboard> snowboardList, String bend) {
        //Regular Camber, "Pure-Pop Camber, Directional Camber Bend.id 1, 3, 5
        if (bend.equalsIgnoreCase("Regular Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td -> 
                           td.getName().equalsIgnoreCase("Pure-Pop Camber")
                    || td.getName() .equalsIgnoreCase("Directional Camber"))).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Pure-Pop Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td ->
                              td.getName().equalsIgnoreCase("Regular Camber")
                    ||   td.getName().equalsIgnoreCase("Directional Camber"))).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Directional Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("Regular Camber")
                    || td.getName().equalsIgnoreCase("Pure-Pop Camber"))).collect(Collectors.toList());
        }
        //"Flat Top, Flying V / Camber/Rocker, Directional Flat Top 2, 4, 6
        if (bend.equalsIgnoreCase("Flat Top")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("Flying V / Camber/Rocker")
                    || td.getName().equalsIgnoreCase("Directional Flat Top"))).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Flying V / Camber/Rocker")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("Flat Top")
                    || td.getName().equalsIgnoreCase("Directional Flat Top"))).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Directional Flat Top")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getTechDetails().stream().anyMatch(td -> 
                            td.getName().equalsIgnoreCase("Flat Top")
                    || td.getName().equalsIgnoreCase("Flying V / Camber/Rocker"))).collect(Collectors.toList());
        }

        return snowboardList;
    }

    List<Snowboard> filterByAlternativeShape(List<Snowboard> snowboardList, String shape) {
        if (shape.equalsIgnoreCase("All Mountain Directional Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s ->  s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("Twin Shape")
                    || td.getName().equalsIgnoreCase("Freeride Directional Shape"))).collect(Collectors.toList());
        }
        if (shape.equalsIgnoreCase("Twin Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s ->  s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("All Mountain Directional Shape")
                    || td.getName().equalsIgnoreCase("Freeride Directional Shape"))).collect(Collectors.toList());
        }
        if (shape.equalsIgnoreCase("Freeride Directional Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s ->  s.getTechDetails().stream().anyMatch(td ->
                            td.getName().equalsIgnoreCase("Twin Shape")
                    || td.getName().equalsIgnoreCase("All Mountain Directional Shape"))).collect(Collectors.toList());
        }
        return snowboardList;

    }

    
    @Transactional
    public List<Snowboard> filter(Map<String, Object> map) {
        currentList = snowboardRepo.getAllSnowboards();
        filteredList = new ArrayList<>(currentList);
        resetFilteredList();
        System.out.println("Map: " + map);
        if (map.get("gender") != null) {
            filteredList = filterByGender(filteredList, map.get("gender").toString());
        }
        if (map.get("riderWeight") != null) {
            filteredList = filterByRiderWeight(filteredList, Integer.parseInt(map.get("riderWeight").toString()));
        }
        if (map.get("shoeSize") != null) {
            filteredList = filterByShoeSize(filteredList, Double.parseDouble(map.get("shoeSize").toString()));
        }
        if (map.get("riderLevel") != null) {
            filteredList = filterByRiderLevel(filteredList, map.get("riderLevel").toString());
        }
        if (map.get("preferredTerrain") != null) {
            filteredList = filterByRidingTerrain(filteredList, map.get("preferredTerrain").toString(), map.get("gender").toString());
        }
        if (map.get("shape") != null && !map.get("shape").toString().equalsIgnoreCase("Undecided")) {
            filteredList = filterByShape(filteredList, map.get("shape").toString());
        }
        if (map.get("flex") != null && !map.get("flex").toString().equalsIgnoreCase("Undecided")) {
            filteredList = filterByFlex(filteredList, map.get("flex").toString());
        }
        if (map.get("bend") != null && !map.get("bend").toString().equalsIgnoreCase("Undecided")) {
            filteredList = filterByBend(filteredList, map.get("bend").toString(), map.get("gender").toString());
        }
        filteredList = sortFilteredBoardsafterTerrainValue(filteredList, map);
        //Cummunicates the searchedEvent via RabbitMQ to the Stats Microservice
        eventDispatcher.sendBoardSearchedEvent(
                new BoardSearchedEvent(map.get("gender").toString(),  Integer.parseInt(map.get("riderWeight").toString()),Double.parseDouble(map.get("shoeSize").toString()), 
        map.get("riderLevel").toString(), map.get("preferredTerrain").toString(), map.get("shape").toString(),  map.get("flex").toString(), map.get("bend").toString())
        
        );
        

        return filteredList;
    }

    
    /*
    @Transactional
    public List<Snowboard> filter(Map<String, Object> map) {
        
        currentList = snowboardRepo.getAllSnowboards();
        filteredList = new ArrayList<>(currentList);
        resetFilteredList();
        
        if (map.get("gender") != null) {
            filteredList = filterByGender(filteredList, map.get("gender").toString());
        }
        if (map.get("riderWeight") != null) {
            filteredList = filterByRiderWeight(filteredList, Integer.parseInt(map.get("riderWeight").toString()));
        }
        if (map.get("shoeSize") != null) {
            filteredList = filterByShoeSize(filteredList, Double.parseDouble(map.get("shoeSize").toString()));
        }
        if (map.get("riderLevel") != null) {
            filteredList = filterByRiderLevel(filteredList, map.get("riderLevel").toString());
        }
        if (map.get("preferredTerrain") != null) {
            filteredList = filterByRidingTerrain(filteredList, map.get("preferredTerrain").toString());
        }
        if (map.get("shape") != null && !map.get("shape").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByShape(filteredList, map.get("shape").toString());
        }
        if (map.get("flex") != null && !map.get("flex").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByFlex(filteredList, map.get("flex").toString());
        }
        if (map.get("bend") != null && !map.get("bend").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByBend(filteredList, map.get("bend").toString());
        }
        
        
        List<Snowboard> result = customSnowboardRepository.getAllSnowboardsByQueryParamsMap(map);
        result = sortFilteredBoardsafterTerrainValue(result, map);
        
        //Cummunicates the searchedEvent via RabbitMQ to the Stats Microservice
        eventDispatcher.sendBoardSearchedEvent(
                new BoardSearchedEvent(map.get("gender").toString(),  Integer.parseInt(map.get("riderWeight").toString()),Double.parseDouble(map.get("shoeSize").toString()), 
        map.get("riderLevel").toString(), map.get("preferredTerrain").toString(), map.get("shape").toString(),  map.get("flex").toString(), map.get("bend").toString())
        
        );
        

        return result;
    } */

    public List<Snowboard> filterWithAlternativeBendAndShape(Map<String, Object> map) {
        currentList = snowboardRepo.getAllSnowboards();
        alternativeFilteredList = new ArrayList<>(currentList);

        resetAlternativeFilteredList();

        Set<Long> boardIds = filteredList.stream()
                .map(Snowboard::getId)
                .collect(Collectors.toSet());

        alternativeFilteredList = alternativeFilteredList.stream().filter(snowboard
                -> !boardIds.contains(snowboard.getId())
        ).collect(Collectors.toList());

        alternativeFilteredList = sortFilteredBoardsafterTerrainValue(alternativeFilteredList, map);

        if (map.get("gender") != null) {
            alternativeFilteredList = filterByGender(alternativeFilteredList, map.get("gender").toString());
        }
        if (map.get("riderWeight") != null) {
            alternativeFilteredList = filterByRiderWeight(alternativeFilteredList, Integer.parseInt(map.get("riderWeight").toString()));
        }

        if (map.get("shoeSize") != null) {
            alternativeFilteredList = filterByShoeSize(alternativeFilteredList, Double.parseDouble(map.get("shoeSize").toString()));
        }
        if (map.get("riderLevel") != null) {
            alternativeFilteredList = filterByRiderLevel(alternativeFilteredList, map.get("riderLevel").toString());
        }
        if (map.get("preferredTerrain") != null) {
            alternativeFilteredList = filterByRidingTerrain(alternativeFilteredList, map.get("preferredTerrain").toString(), map.get("gender").toString());
        }
        alternativeFilteredList = sortFilteredBoardsafterTerrainValue(alternativeFilteredList, map);

        return alternativeFilteredList;
    }

    /** 
     * Gets the recommended snowboards lengths for a rider (user) based on the parameters in the in parameter map. 
     * @param map
     * @return list of recommended snowboard lengths as Strings for a rider 
     */
    public List<String> getRecommendedBoardLengths(Map<String, Object> map) {
        recommendedLengths.clear();
        riderWeight = 0;
        riderShoeSize = findRiderShoeSize(Double.parseDouble(map.get("shoeSize").toString()));
        riderWeight = Integer.parseInt(map.get("riderWeight").toString());

        selectedSnowboard = filterById(Long.parseLong(map.get("boardId").toString()));

        for (SnowboardSizeSpecs s : selectedSnowboard.getBoardSizeSpecs()) {
            for (int i = riderShoeSize.getWaistWidthIdeal(); i <= riderShoeSize.getWaistWidthMax(); i++) {
                if (s.getWaistWidth() == i && s.getRiderWeightMin() <= riderWeight && s.getRiderWeightMax() >= riderWeight) {
                    recommendedLengths.add(s.getBoardLength());
                    if (recommendedLengths.size() == 2) {
                        break;
                    }
                }
            }
        }
        if (selectedSnowboard.getBoardSizeSpecs().size() >= 2 && recommendedLengths.size() < 2) {
            for (SnowboardSizeSpecs s : selectedSnowboard.getBoardSizeSpecs()) {
                for (int i = riderShoeSize.getWaistWidthIdeal(); i >= riderShoeSize.getWaistWidthMin(); i--) {
                    if (s.getWaistWidth() == i && s.getRiderWeightMin() <= riderWeight && s.getRiderWeightMax() >= riderWeight) {
                        recommendedLengths.add(s.getBoardLength());
                        if (recommendedLengths.size() == 2) {
                            break;
                        }
                    }
                }
            }
            Collections.sort(recommendedLengths);
        }
        return recommendedLengths.stream().distinct().collect(Collectors.toList());
    }

    /** 
     * Sorts the snowboard after how well they match the preferred riding terrain. 
     * @param snowboardList
     * @param map of the board search
     * @return sorted list of Snowboards
     */
    public List<Snowboard> sortFilteredBoardsafterTerrainValue(List<Snowboard> snowboardList, Map<String, Object> map) {
        Comparator<Snowboard> compareRiderTerrainValue = (Snowboard s1, Snowboard s2) -> s1.getRiderTerrainValueByName(map.get("preferredTerrain").toString()).compareTo(s2.getRiderTerrainValueByName(map.get("preferredTerrain").toString()));
        Collections.sort(snowboardList, compareRiderTerrainValue.reversed());

        return snowboardList;
    }
}
