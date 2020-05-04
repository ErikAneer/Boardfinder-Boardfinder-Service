package boardFinder.demo.service;

import boardFinder.demo.domain.Brand;
import boardFinder.demo.domain.Gender;
import boardFinder.demo.domain.RiderLevel;
import boardFinder.demo.domain.RidingTerrain;
import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.domain.SnowboardSizeSpecs;
import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.domain.Terrain;
import boardFinder.demo.domain.Warranty;
import boardFinder.demo.repository.BrandRepository;
import boardFinder.demo.repository.GenderRepository;
import boardFinder.demo.repository.RiderLevelRepository;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.SnowboardRepository;
import boardFinder.demo.repository.SnowboardSizeSpecsRepository;
import boardFinder.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boardFinder.demo.repository.RidingTerrainRepository;
import boardFinder.demo.repository.TechDetailRepository;
import boardFinder.demo.repository.WarrantyRepository;

/**
 * Class to fill the database with all available Snowboard objects instead of using a SQL file if the database is empty. 
 * This class is not to be used in a production environment, only here in a school / self learning task. 
 * @author Erik
 */
@Service
public class DBDataService {

    private BrandRepository brandRepository;
    private GenderRepository genderRepository;
    private RiderLevelRepository riderLevelRepository;
    private RidingTerrainRepository ridingTypeRepository;
    private ShoeSizeRepository shoeSizeRepository;
    private SnowboardRepository snowboardRepository;
    private SnowboardSizeSpecsRepository snowboardSizeSpecsRepository;
    private TerrainRepository terrainRepository;
    private TechDetailRepository techDetailRepository;
    private WarrantyRepository warrantyRepository;

    @Autowired
    public DBDataService(BrandRepository brandRepository, GenderRepository genderRepository, RiderLevelRepository riderLevelRepository,
            RidingTerrainRepository ridingTypeRepository, ShoeSizeRepository shoeSizeRepository, SnowboardRepository snowboardRepository,
            SnowboardSizeSpecsRepository snowboardSizeSpecsRepository, TerrainRepository terrainRepository, TechDetailRepository techDetailRepository,
            WarrantyRepository warrantyRepository) {
        this.brandRepository = brandRepository;
        this.genderRepository = genderRepository;
        this.riderLevelRepository = riderLevelRepository;
        this.ridingTypeRepository = ridingTypeRepository;
        this.shoeSizeRepository = shoeSizeRepository;
        this.snowboardRepository = snowboardRepository;
        this.snowboardSizeSpecsRepository = snowboardSizeSpecsRepository;
        this.terrainRepository = terrainRepository;
        this.techDetailRepository = techDetailRepository;
        this.warrantyRepository = warrantyRepository;
    }

        /** 
     * Fills the database with all the snowboards if database is empty.
     * Not to be used in a real production environment.
     */
    public void fillDatabaseWithSnowboards() {
        if (snowboardRepository.findAll().isEmpty()) {

            //Brands
            Brand brand1 = new Brand("Burton");
            brandRepository.save(brand1);

            //TechDetails
            //Bends
            TechDetail camberBend = new TechDetail("bend", "Camber", "An advocate of powerful turns and poppy precision, camber speaks to the core values of board design. Offering a snappy suspension, camber distributes weight evenly over the entire length of the board for smooth, continuous edge control from tip to tail. .", "benddetail-camber.svg");
            TechDetail flatTopBend = new TechDetail("bend", "Flat Top™", "These boards run perfectly flat for the running length of the board, with a few millimeters of early rise rocker in the tip and tail. This shape is the perfect blend of the stability and precision camber offers, as well as the catch-free and playful personality of rocker. With no camber to press out of the board, turning takes very little energy to initiate. Flat boards perform well in all conditions, from powder conditions to hard-packed and groomers. It is great board shape for any rider.", "benddetail-flat-top.svg");
            TechDetail purePopCamberBend = new TechDetail("bend", "Pure-Pop Camber", "We call this “Diet Camber” featuring about 70% of the camber profile length that a typical camber board has. The camber zone ends just outside each channel, and a flat zone continues for a few centimeters of length until the board transitions into a small amount of early rise near the nose and tail.  This board bend lies somewhere between the playful flat bend and the precise camber bend. It also offers increased pop as the flat zones before the nose and tail kicks provide additional load and rebound.", "benddetail-purepop.svg");
            TechDetail flyingVBend = new TechDetail("bend", "Flying V / Camber/Rocker", "This bend is a hybrid of both camber and rocker, where rocker is the opposite curvature of camber. It has camber underneath both feet and rocker in between the feet, as well as outside the feet. The nose and the tail are lifted off of the snow which makes for a super-playful, floaty ride by reducing the ability to catch your edge and allowing the board to plane better in deep snow. The camber underfoot gives you edge control and pop where you want it, without sacrificing that playfulness where you need it. Flying V can make a board feel softer than its Camber counterpart. For example the Process Flying V vs. Process Camber; Flying V will feel softer even though they have the same materials. Geared towards beginner to intermediate and freestyle riders but provides a versatile platform for progression and exploration.", "benddetail-flying-v.svg");
            TechDetail directionalCamberBend = new TechDetail("bend", "Directional Camber", "This board bend has entry rocker that adds lift to the nose while a camber section under both feet maintains momentum and stability through deep-driving turns and variable conditions. This bend caters to those who like the attributes of traditional camber but want something that will get up to speed and float easier in powder.", "benddetail-directional-camber.svg");
            TechDetail directionalFlatTopBend = new TechDetail("bend", "Directional Flat Top", "This features a longer entry rocker in the nose that transitions into a flat section just before your front foot for the remainder of the board. This will be the most powder specific board bend as it promotes lift and float for deeper days while not lacking stability and control.", "benddetail-directional-flat-top.svg");
            TechDetail flatTopEasyBevelBend = new TechDetail("bend", "Flat Top™ with Easy Bevel", "Rising rider or seasoned pro, keep your game high and tight with Flat Top. A flat profile between the feet means stability, better balance, and continuous edge control. The tip and tail kick up with an early rise outside the feet for the catch-free, loose feeling you’d expect from rocker.", "benddetail-flat-top.svg");
            
            TechDetail allMountainDirectionalShape = new TechDetail("shape", "All Mountain Directional Shape", "The classic snowboard shape, designed to be ridden with a slightly longer nose than tail to concentrate pop in the tail while still giving you plenty of float, flow, and control to rip any terrain or condition.", "shape-directional.svg");
            TechDetail twinShape = new TechDetail("shape", "Twin Shape", "Perfectly symmetrical for a balanced ride that’s equally versatile when ridden regular or switch. Jib, spin, stomp, and butter with a greater balance of freestyle mobility and cat-like stability no matter which way you point it.", "shape-twin.svg");
            //TechDetail shape3 = new TechDetail("Directional Twin", "", ""); //Not in use
            TechDetail freerideDirectionalShape = new TechDetail("shape", "Freeride Directional Shape", "Twin or directional is the age-old question for creative rippers like Terje. Balanced Freeride Geometry ends the debate with setback camber and a sidecut that is centered on your stance to create a twin freestyle feel when riding flat base. On edge it turns tight and quick with the float and prowess expected from a directional deck.", "shape-bfg.svg");

            TechDetail directionalFlex = new TechDetail("flex", "Directional Flex", "This flex features increased pop in the tail and a more resilient nose that allows riders to easily maintain control through all terrain and conditions.", "flex-directional.svg");
            TechDetail twinFlex = new TechDetail("flex", "Twin Flex", "The flex is perfectly symmetrical from tip to tail for a balanced ride that’s equally versatile regular or switch.", "flex-twin.svg");

            TechDetail fly900G = new TechDetail("core", "FSC™ Certified Fly® 900G Core", "Our classic tip-to-tail wood core, the 900G model utilizes the best of two wood species to lighten the load by 10% without sacrificing flex, pop, or strength.", "core-fsc-certified-fly-900g-core.svg");
            TechDetail superFly800G = new TechDetail("core", "FSC™ Certified Super Fly® 800G Core", "Lightened up and loaded with pop, our dual-species wood core utilizes dual-density vertical laminations of alternating softwood/hardwood to reduce overall weight with no sacrifice in strength or performance.", "core-fsc-certified-super-fly-800g-core-with-dualzone-egd.svg");
            TechDetail superFly2700G = new TechDetail("core", "FSC™ Certified Super Fly II™ 700G Core", "Stronger and lighter woods target specific areas of the core to provide pop, strength, and reduced weight.", "core-fsc-certified-super-fly-ii-700g-core-with-dualzone-egd.svg");
            TechDetail dragonfly600G = new TechDetail("core", "FSC™ Certified Dragonfly™ 600G Core", "Use of end-grain woods in impact zones allows us to swap heavier woods for lighter weight species without sacrificing strength.", "core-fsc-certified-dragonfly-600g-core-with-multizone-egd.svg");
            TechDetail dragonfly2500G = new TechDetail("core", "FSC™ Certified Dragonfly II™ 500G Core", "Our lightest core ever, the DragonFly II™ integrates carbon laminations inside the core to provide absolute pop and performance with far less material.", "core-fsc-certified-dragonfly-ii-500g-core.svg");
           
            techDetailRepository.save(camberBend);
            techDetailRepository.save(flatTopBend);
            techDetailRepository.save(purePopCamberBend);
            techDetailRepository.save(flyingVBend);
            techDetailRepository.save(directionalCamberBend);
            techDetailRepository.save(directionalFlatTopBend);
            techDetailRepository.save(flatTopEasyBevelBend);
            techDetailRepository.save(allMountainDirectionalShape);
            techDetailRepository.save(twinShape);
            techDetailRepository.save(freerideDirectionalShape);
            techDetailRepository.save(directionalFlex);
            techDetailRepository.save(twinFlex);
            techDetailRepository.save(fly900G);
            techDetailRepository.save(superFly800G);
            techDetailRepository.save(superFly2700G);
            techDetailRepository.save(dragonfly600G);
            techDetailRepository.save(dragonfly2500G);

            //Gender
            Gender female = new Gender("Women");
            Gender male = new Gender("Men");
            Gender kids = new Gender("Kids");

            genderRepository.save(female);
            genderRepository.save(male);
            genderRepository.save(kids);

            //RiderLevel
            RiderLevel beginner = new RiderLevel("Beginner", "I'm doing my best in the kids area. (Beginner level)");
            RiderLevel intermediate = new RiderLevel("Intermediate", "I ride well in slopes and the park, doing jumps and so. (Intermediate level)");
            RiderLevel pro = new RiderLevel("Expert", "I can beat Shaun White! (Expert level)");

            riderLevelRepository.save(beginner);
            riderLevelRepository.save(intermediate);
            riderLevelRepository.save(pro);

            //RidingTypes
            RidingTerrain allMountain = new RidingTerrain("All Mountain");
            RidingTerrain park = new RidingTerrain("Park");
            RidingTerrain powder = new RidingTerrain("Powder");

            ridingTypeRepository.save(allMountain);
            ridingTypeRepository.save(park);
            ridingTypeRepository.save(powder);

            //ShoeSize - not needed for boards but for filtering
            // euSize, jpSize, ukSize, usMensSize, usWomensSize;
          
              //Kids sizes
              // from EU18-31
             ShoeSize kids24 = new ShoeSize(24, 13.5, 0, 0.5, 2, 173, 179, 175);
              ShoeSize kids25 = new ShoeSize(25, 14.5, 0, 0.5, 2, 173, 179, 175);
              ShoeSize kids26 = new ShoeSize(26, 15.5, 0, 0.5, 2, 173, 179, 175);
              ShoeSize kids27 = new ShoeSize(27, 16.5, 0, 0.5, 2, 173, 179, 175);
              ShoeSize kids28 = new ShoeSize(28, 17.5, 0, 0.5, 2, 175, 181, 177);
              ShoeSize kids29 = new ShoeSize(29, 18.5, 0, 0.5, 2, 175, 181, 177);
              ShoeSize kids305 = new ShoeSize(30.5, 19.5, 0, 0.5, 2, 185, 195, 190);
              ShoeSize kids31 = new ShoeSize(31.5, 20, 0, 0.5, 2, 195, 205, 200);
            ShoeSize kids33 = new ShoeSize(33, 20.5, 1, 1.5, 3, 195, 215, 205);
             //Womens sizes
            ShoeSize ss5 = new ShoeSize(34, 21, 2, 2.5, 4, 227, 233, 230);
            ShoeSize ss6 = new ShoeSize(34.5, 21.5, 2.5, 3, 4.5, 228, 234, 231);
            ShoeSize ss7 = new ShoeSize(35, 22, 3, 3.5, 5, 229, 235, 232);
            ShoeSize ss8 = new ShoeSize(35.5, 22.5, 3.5, 4, 5.5, 230, 236, 233);
            //ShoeSize ss9 = new ShoeSize(36, 23, 4, 4.5, 6);
            ShoeSize ss10 = new ShoeSize(36.5, 23, 4, 4.5, 6, 232, 238, 235);
            ShoeSize ss11 = new ShoeSize(37, 23.5, 4.5, 5, 6.5, 233, 239, 236);
            ShoeSize ss12 = new ShoeSize(37.5, 24, 5, 5.5, 7, 235, 241, 238);
            ShoeSize ss13 = new ShoeSize(38, 24.5, 5.5, 6, 7.5, 237, 243, 240);
            ShoeSize ss14 = new ShoeSize(39, 25, 6, 6.5, 8, 239, 245, 242);
           
            // euSize, jpSize, ukSize, usMensSize, usWomensSize
            ShoeSize ss15 = new ShoeSize(39.5, 25.5, 6.5, 7, 8.5, 238, 244, 242);
            ShoeSize ss16 = new ShoeSize(40, 26, 7, 7.5, 9, 240, 246, 243);
            ShoeSize ss17 = new ShoeSize(40.5, 26.5, 7.5, 8, 9.5, 242, 248, 245);
            ShoeSize ss18 = new ShoeSize(41, 27, 8, 8.5, 10, 244, 250, 247);
            ShoeSize ss19 = new ShoeSize(42, 27.5, 8.5, 9, 10.5, 246, 252, 249);
            ShoeSize ss20 = new ShoeSize(42.5, 28, 9, 9.5, 11, 247, 253, 250);
            ShoeSize ss21 = new ShoeSize(43, 28.5, 9.5, 10, 11.5, 249, 255, 252);
            ShoeSize ss22 = new ShoeSize(44, 29, 10, 10.5, 12, 252, 258, 255);
            ShoeSize ss23 = new ShoeSize(44.5, 29.5, 10.5, 11, 12.5, 254, 260, 257);
            ShoeSize ss24 = new ShoeSize(45.5, 30, 11, 11.5, 13, 257, 263, 260);
            ShoeSize ss25 = new ShoeSize(46, 30.5, 11.5, 12, 13.5, 260, 266, 263);
            ShoeSize ss26 = new ShoeSize(46.5, 31, 12, 12.5, 14, 262, 268, 265);
            ShoeSize ss27 = new ShoeSize(47, 31.5, 12.5, 13, 14.5, 265, 271, 268);
            ShoeSize ss28 = new ShoeSize(47.5, 32, 13, 13.5, 15, 268, 274, 271);
            ShoeSize ss29 = new ShoeSize(48.5, 32.5, 13.5, 14, 15.5, 270, 276, 273);
            ShoeSize ss30 = new ShoeSize(49, 33, 14, 14.5, 16, 272, 278, 275);
            ShoeSize ss31 = new ShoeSize(49.5, 33.5, 14.5, 15, 16.5, 275, 280, 277);
            ShoeSize ss32 = new ShoeSize(50, 34, 15, 15.5, 17, 277, 283, 279);


            shoeSizeRepository.save(kids24);
            shoeSizeRepository.save(kids25);
            shoeSizeRepository.save(kids26);
            shoeSizeRepository.save(kids27);
            shoeSizeRepository.save(kids28);
            shoeSizeRepository.save(kids29);
            shoeSizeRepository.save(kids305);
            shoeSizeRepository.save(kids31);
            shoeSizeRepository.save(kids33);

            shoeSizeRepository.save(ss5);
            shoeSizeRepository.save(ss6);
            shoeSizeRepository.save(ss7);
            shoeSizeRepository.save(ss8);
            shoeSizeRepository.save(ss10);
            shoeSizeRepository.save(ss11);
            shoeSizeRepository.save(ss12);
            shoeSizeRepository.save(ss13);
            shoeSizeRepository.save(ss14);
        
            shoeSizeRepository.save(ss15);
            shoeSizeRepository.save(ss16);
            shoeSizeRepository.save(ss17);
            shoeSizeRepository.save(ss18);
            shoeSizeRepository.save(ss19);
            shoeSizeRepository.save(ss20);
            shoeSizeRepository.save(ss21);
            shoeSizeRepository.save(ss22);
            shoeSizeRepository.save(ss23);
            shoeSizeRepository.save(ss24);
            shoeSizeRepository.save(ss25);
            shoeSizeRepository.save(ss26);
            shoeSizeRepository.save(ss27);
            shoeSizeRepository.save(ss28);
            shoeSizeRepository.save(ss29);
            shoeSizeRepository.save(ss30);
            shoeSizeRepository.save(ss31);
            shoeSizeRepository.save(ss32);
            
            // Warranty - header, description, years
            Warranty twoYears = new Warranty("2-YEAR WARRANTY - BOARDS", "All Burton snowboards with traditional mounting inserts (such as the one you are looking at here) are backed by a two-year warranty from date of purchase. Our W48 Warranty Program ensures that should you have a problem, we'll have your claim repaired or replaced and on its way back to you within two business days of receiving it.", 2);
            Warranty threeYears = new Warranty("3-YEAR WARRANTY - SNOWBOARDS", "All 2014 and newer Burton snowboards with The Channel mounting system (such as the one you are looking at here) are backed by a three-year warranty from date of purchase.", 3);
            
            warrantyRepository.save(twoYears);
            warrantyRepository.save(threeYears);
             
            //Snowboards
            // TWC Pro
            Snowboard sb1 = new Snowboard(brand1, "TWC Pro", male, -1.25, 6, "TWCPro.webp", threeYears, "Backed by gold, and designed by Shaun White - get the snap, control, and response to propel your skills to the highest level.", "One look under the hood tells you Shaun White's TWC Pro is revved up and ready to perform alchemy on all-terrain. In superpipes and slopestyle courses around the world, and every condition in between, camber delivers the snappy and stable suspension that White's riding demands. Frostbite Edges eat up bulletproof ice, while the WFO base accelerates past the competition. Similar to the Custom but with a more responsive shape, the TWC Pro is the logical next step for riders ready to upgrade their game.");
            sb1.getTechDetails().add(camberBend);
            sb1.getTechDetails().add(allMountainDirectionalShape);
            sb1.getTechDetails().add(directionalFlex);
            sb1.getTechDetails().add(superFly2700G);

            SnowboardSizeSpecs twc156 = new SnowboardSizeSpecs("156", 62, 79, "M", 120.2, 120.2, 7.9, 246, 52);
            snowboardSizeSpecsRepository.save(twc156);
            Terrain twc156t1 = new Terrain(park, 10);
            Terrain twc156t2 = new Terrain(allMountain, 8);
            Terrain twc156t3 = new Terrain(powder, 4);

            terrainRepository.save(twc156t1);
            terrainRepository.save(twc156t2);
            terrainRepository.save(twc156t3);

            sb1.getBoardSizeSpecs().add(twc156);

            sb1.getRidingterrains().add(twc156t1);
            sb1.getRidingterrains().add(twc156t2);
            sb1.getRidingterrains().add(twc156t3);

            sb1.getRiderLevels().add(pro);
            sb1.getRiderLevels().add(intermediate);

            // Kilroy Custom
            Snowboard sb2 = new Snowboard(brand1, "Kilroy Custom", male, 0, 5, "Kilroy_Custom.webp", threeYears, "A twisted evolution of the most trusted board in the game.", "Built for riding any and all terrain, the Burton Kilroy Custom takes the attitude and approach of the most trusted board ever and gives it a new unique shape and construction. Better yet, it’s a board that can be thrashed without worries thanks to a recipe that’s high-performance without the price.");
            sb2.getTechDetails().add(camberBend);
            sb2.getTechDetails().add(allMountainDirectionalShape);
            sb2.getTechDetails().add(twinFlex);
            sb2.getTechDetails().add(superFly800G);

            SnowboardSizeSpecs kilroyCustom154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs kilroyCustom158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            snowboardSizeSpecsRepository.save(kilroyCustom154);
            snowboardSizeSpecsRepository.save(kilroyCustom158);

            sb2.getBoardSizeSpecs().add(kilroyCustom154);
            sb2.getBoardSizeSpecs().add(kilroyCustom158);

            Terrain kilroyCustomt1 = new Terrain(park, 10);
            Terrain kilroyCustomt2 = new Terrain(allMountain, 7);
            Terrain kilroyCustomt3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyCustomt1);
            terrainRepository.save(kilroyCustomt2);
            terrainRepository.save(kilroyCustomt3);

            sb2.getRidingterrains().add(kilroyCustomt1);
            sb2.getRidingterrains().add(kilroyCustomt2);
            sb2.getRidingterrains().add(kilroyCustomt3);

            sb2.getRiderLevels().add(pro);
            sb2.getRiderLevels().add(intermediate);

            // Instigator
            Snowboard sb3 = new Snowboard(brand1, "Instigator", male, -2.5, 2, "Instigator.webp", threeYears, "Shortcut the learning curve with an all-around board that’s catch-free and easy for boosting confidence anywhere you take it.", "Some riders just want to get straight to the fun part. Enjoy a no-fuss feel with the Burton Instigator, a board designed to help accelerate the learning curve and instigate a good time from your first moment on the mountain. The combination of a Flat Top™ bend and convex base keeps things friendly underfoot, creating a catch-free feel that maintains stability and control. The Channel® mounting system gives you the easiest, most adjustable setup with bindings from all major brands (not just Burton’s).");
            sb3.getTechDetails().add(flatTopBend);
            sb3.getTechDetails().add(allMountainDirectionalShape);
            sb3.getTechDetails().add(twinFlex);
            sb3.getTechDetails().add(superFly800G);

            SnowboardSizeSpecs instigator140 = new SnowboardSizeSpecs("140", 36, 51, "S", 103.0, 95.0, 6.2, 242, 48);
            SnowboardSizeSpecs instigator145 = new SnowboardSizeSpecs("145", 45, 68, "S/M", 107.5, 99.5, 6.5, 245, 50.5);
            SnowboardSizeSpecs instigator150 = new SnowboardSizeSpecs("150", 54, 82, "M", 112.0, 104.0, 6.8, 248, 53);
            SnowboardSizeSpecs instigator155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 117, 109, 7.1, 252, 56);
            SnowboardSizeSpecs instigator160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 114, 7.4, 256, 56);
            SnowboardSizeSpecs instigator150W = new SnowboardSizeSpecs("150W", 54, 82, "L", 112.0, 104.0, 6.8, 256, 56);
            SnowboardSizeSpecs instigator155W = new SnowboardSizeSpecs("155W", 54, 82, "L", 117, 109, 7.1, 260, 56);
            SnowboardSizeSpecs instigator160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 122, 114, 7.4, 265, 56);
            SnowboardSizeSpecs instigator165W = new SnowboardSizeSpecs("165W", 82, 120, "L", 127, 119, 7.8, 270, 56);
            snowboardSizeSpecsRepository.save(instigator140);
            snowboardSizeSpecsRepository.save(instigator145);
            snowboardSizeSpecsRepository.save(instigator150);
            snowboardSizeSpecsRepository.save(instigator155);
            snowboardSizeSpecsRepository.save(instigator160);
            snowboardSizeSpecsRepository.save(instigator150W);
            snowboardSizeSpecsRepository.save(instigator155W);
            snowboardSizeSpecsRepository.save(instigator160W);
            snowboardSizeSpecsRepository.save(instigator165W);

            sb3.getBoardSizeSpecs().add(instigator140);
            sb3.getBoardSizeSpecs().add(instigator145);
            sb3.getBoardSizeSpecs().add(instigator150);
            sb3.getBoardSizeSpecs().add(instigator155);
            sb3.getBoardSizeSpecs().add(instigator160);
            sb3.getBoardSizeSpecs().add(instigator150W);
            sb3.getBoardSizeSpecs().add(instigator155W);
            sb3.getBoardSizeSpecs().add(instigator160W);
            sb3.getBoardSizeSpecs().add(instigator165W);

            Terrain instigatort1 = new Terrain(allMountain, 9);
            Terrain instigatort2 = new Terrain(powder, 4);
            Terrain instigatort3 = new Terrain(park, 4);

            terrainRepository.save(instigatort1);
            terrainRepository.save(instigatort2);
            terrainRepository.save(instigatort3);

            sb3.getRidingterrains().add(instigatort1);
            sb3.getRidingterrains().add(instigatort2);
            sb3.getRidingterrains().add(instigatort3);

            sb3.getRiderLevels().add(beginner);

            // Process
            Snowboard sb4 = new Snowboard(brand1, "Process", male, -1.25, 3, "Process.webp", threeYears, "Lightweight true twin performance tuned to the ride-everything style of top pros like Mark McMorris.", "Constantly evolved to drop ounces and amplify pop, the Burton Process is Mark McMorris’ pick for its twin freestyle playfulness and all-terrain prowess. Now featuring PurePop camber for a forgiving yet snappy feel, the Process is suited to the freestyle rider, but still capable of ripping the entire mountain as proven by the pros who push it. The FSC™ Certified Super Fly II core creates a lighter, lift-off-ready deck, while Squeezebox core profiling transfers energy towards the tip and tail for snappier ollies and effortless stability. Available in two versions, choose the relaxed and floaty Flying V™ or precise control of PurePop camber.");
            sb4.getTechDetails().add(camberBend);
            sb4.getTechDetails().add(twinShape);
            sb4.getTechDetails().add(twinFlex);
            sb4.getTechDetails().add(superFly2700G);

            SnowboardSizeSpecs process152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 116.5, 112.5, 7.7, 249, 48);
            SnowboardSizeSpecs process155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 119.5, 115.5, 7.9, 251, 53);
            SnowboardSizeSpecs process157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 121.5, 117.5, 8.1, 252, 56);
            SnowboardSizeSpecs process159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 119.5, 8.2, 255, 56);
            SnowboardSizeSpecs process162 = new SnowboardSizeSpecs("162", 82, 120, "L", 126.5, 122.5, 8.4, 257, 56);
            snowboardSizeSpecsRepository.save(process152);
            snowboardSizeSpecsRepository.save(process155);
            snowboardSizeSpecsRepository.save(process157);
            snowboardSizeSpecsRepository.save(process159);
            snowboardSizeSpecsRepository.save(process162);

            sb4.getBoardSizeSpecs().add(process152);
            sb4.getBoardSizeSpecs().add(process155);
            sb4.getBoardSizeSpecs().add(process157);
            sb4.getBoardSizeSpecs().add(process159);
            sb4.getBoardSizeSpecs().add(process162);

            Terrain processt1 = new Terrain(allMountain, 10);
            Terrain processt2 = new Terrain(powder, 6);
            Terrain processt3 = new Terrain(park, 5);

            terrainRepository.save(processt1);
            terrainRepository.save(processt2);
            terrainRepository.save(processt3);

            sb4.getRidingterrains().add(processt1);
            sb4.getRidingterrains().add(processt2);
            sb4.getRidingterrains().add(processt3);

            sb4.getRiderLevels().add(intermediate);

            // Process Flying V
            Snowboard sb5 = new Snowboard(brand1, "Process Flying V", male, -1.25, 2, "Process_Flying_V.webp", threeYears, "Lightweight true twin performance tuned to the ride-everything style of top pros like Mark McMorris.", "Constantly evolved to drop ounces and amplify pop, the Burton Process is Mark McMorris’ pick for its twin freestyle playfulness and all-terrain prowess. The FSC™ Certified Super Fly II core creates a lighter, lift-off-ready deck, while Squeezebox core profiling transfers energy towards the tip and tail for snappier ollies and effortless stability. Available in two versions, choose the relaxed and floaty Flying V or precise control of PurePop camber. Process is suited to the freestyle rider, but still capable of ripping the entire mountain as proven by the pros who push it.");
            sb5.getTechDetails().add(flyingVBend);
            sb5.getTechDetails().add(twinShape);
            sb5.getTechDetails().add(twinFlex);
            sb5.getTechDetails().add(superFly2700G);

            SnowboardSizeSpecs processFV152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 116.5, 112.5, 7.7, 249, 48);
            SnowboardSizeSpecs processFV155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 119.5, 115.5, 7.9, 251, 53);
            SnowboardSizeSpecs processFV157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 121.5, 117.5, 8.1, 252, 56);
            SnowboardSizeSpecs processFV159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 119.5, 8.3, 255, 56);
            SnowboardSizeSpecs processFV162 = new SnowboardSizeSpecs("162", 82, 120, "L", 126.5, 122.5, 8.4, 257, 56);
            SnowboardSizeSpecs processFV157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 121.5, 117.5, 8.1, 257, 56);
            SnowboardSizeSpecs processFV159W = new SnowboardSizeSpecs("159W", 68, 91, "L", 123.5, 119.5, 8.3, 260, 56);
            SnowboardSizeSpecs processFV162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 126.5, 122.5, 8.4, 262, 56);

            snowboardSizeSpecsRepository.save(processFV152);
            snowboardSizeSpecsRepository.save(processFV155);
            snowboardSizeSpecsRepository.save(processFV157);
            snowboardSizeSpecsRepository.save(processFV159);
            snowboardSizeSpecsRepository.save(processFV162);
            snowboardSizeSpecsRepository.save(processFV157W);
            snowboardSizeSpecsRepository.save(processFV159W);
            snowboardSizeSpecsRepository.save(processFV162W);

            sb5.getBoardSizeSpecs().add(processFV152);
            sb5.getBoardSizeSpecs().add(processFV155);
            sb5.getBoardSizeSpecs().add(processFV157);
            sb5.getBoardSizeSpecs().add(processFV159);
            sb5.getBoardSizeSpecs().add(processFV162);
            sb5.getBoardSizeSpecs().add(processFV157W);
            sb5.getBoardSizeSpecs().add(processFV159W);
            sb5.getBoardSizeSpecs().add(processFV162W);

            Terrain processFVt1 = new Terrain(allMountain, 10);
            Terrain processFVt2 = new Terrain(powder, 6);
            Terrain processFVt3 = new Terrain(park, 4);

            terrainRepository.save(processFVt1);
            terrainRepository.save(processFVt2);
            terrainRepository.save(processFVt3);

            sb5.getRidingterrains().add(processFVt1);
            sb5.getRidingterrains().add(processFVt2);
            sb5.getRidingterrains().add(processFVt3);

            sb5.getRiderLevels().add(intermediate);

            // Family Tree Speed Date
            Snowboard sb6 = new Snowboard(brand1, "Family Tree Speed Date", male, -2.5, 8, "Family_Tree_Speed_Date .webp", threeYears, "Go hard in the trench on the Family Tree’s fastest new addition, inspired by snowboarding’s signature event: the banked slalom.", "Our designers called it “the banked slalom board” from day one, so you know it’s built to turn. The Speed Date features a special blend of Balanced Freeride Geometry that thrives on all terrain. Directional Camber combines with a unique shape, aggressive sidecut and just the right amount of taper to burn turns and eat berms for breakfast.");
            sb6.getTechDetails().add(camberBend);
            sb6.getTechDetails().add(freerideDirectionalShape);
            sb6.getTechDetails().add(directionalFlex);
            sb6.getTechDetails().add(dragonfly600G);

            SnowboardSizeSpecs familyTreeSpeedDate151 = new SnowboardSizeSpecs("151", 54, 82, "S/M", 114.5, 110.0, 7.2, 246, 53);
            SnowboardSizeSpecs familyTreeSpeedDate156 = new SnowboardSizeSpecs("156", 68, 91, "M", 119.5, 115, 8.1, 248, 56);
            SnowboardSizeSpecs familyTreeSpeedDate161 = new SnowboardSizeSpecs("161", 82, 120, "M/L", 124.5, 120.0, 8.1, 252, 56);

            snowboardSizeSpecsRepository.save(familyTreeSpeedDate151);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate156);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate161);

            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate151);
            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate156);
            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate161);

            Terrain familyTreeSpeedDatet1 = new Terrain(powder, 8);
            Terrain familyTreeSpeedDatet2 = new Terrain(allMountain, 9);
            Terrain familyTreeSpeedDatet3 = new Terrain(park, 4);

            terrainRepository.save(familyTreeSpeedDatet1);
            terrainRepository.save(familyTreeSpeedDatet2);
            terrainRepository.save(familyTreeSpeedDatet3);

            sb6.getRidingterrains().add(familyTreeSpeedDatet1);
            sb6.getRidingterrains().add(familyTreeSpeedDatet2);
            sb6.getRidingterrains().add(familyTreeSpeedDatet3);

            sb6.getRiderLevels().add(intermediate);
            sb6.getRiderLevels().add(pro);

            // Family Tree Speed Date Wide
            Snowboard sb7 = new Snowboard(brand1, "Family Tree Speed Date Wide", male, -2.5, 8, "Family_Tree_Speed_Date .webp", threeYears, "Go hard in the trench on the Family Tree’s fastest new addition, inspired by snowboarding’s signature event: the banked slalom.", "Our designers called it “the banked slalom board” from day one, so you know it’s built to turn. The Speed Date features a special blend of Balanced Freeride Geometry that thrives on all terrain. Directional Camber combines with a unique shape, aggressive sidecut and just the right amount of taper to burn turns and eat berms for breakfast.");
            sb7.getTechDetails().add(camberBend);
            sb7.getTechDetails().add(freerideDirectionalShape);
            sb7.getTechDetails().add(directionalFlex);
            sb7.getTechDetails().add(dragonfly600G);

            SnowboardSizeSpecs familyTreeSpeedDate156Wide = new SnowboardSizeSpecs("156W", 68, 91, "L", 119.5, 115, 7.5, 256, 56);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate156Wide);

            sb7.getBoardSizeSpecs().add(familyTreeSpeedDate156Wide);

            Terrain familyTreeSpeedDate156Widet1 = new Terrain(powder, 8);
            Terrain familyTreeSpeedDate156Widet2 = new Terrain(allMountain, 9);
            Terrain familyTreeSpeedDate156Widet3 = new Terrain(park, 4);

            terrainRepository.save(familyTreeSpeedDate156Widet1);
            terrainRepository.save(familyTreeSpeedDate156Widet2);
            terrainRepository.save(familyTreeSpeedDate156Widet3);

            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet1);
            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet2);
            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet3);

            sb7.getRiderLevels().add(intermediate);
            sb7.getRiderLevels().add(pro);

            // Free Thinker
            Snowboard sb8 = new Snowboard(brand1, "Free Thinker", male, 0, 7, "Free_Thinker.webp", threeYears, "Expand your perspective with Danny Davis’ new take on poppy and pow-friendly ride-anything performance.", "The Burton Free Thinker is a true twin spin on Danny Davis’ go-to, built for hot laps in the park, pipe, or mobbing side hits across the mountain. The unique true twin shape opens up the possibilities for creative expression in any direction, while the control of camber keeps it quick and poppy. 45° Carbon Highlights deliver snap without the stiff side effects. Throwback graphics top it off, adding a touch of Burton’s early 90’s roots to an already iconic model.");
            sb8.getTechDetails().add(camberBend);
            sb8.getTechDetails().add(twinShape);
            sb8.getTechDetails().add(twinFlex);
            sb8.getTechDetails().add(superFly2700G);

            SnowboardSizeSpecs freeThinker150 = new SnowboardSizeSpecs("150", 54, 82, "S/M", 112.5, 108, 7.0, 246, 53);
            SnowboardSizeSpecs freeThinker154 = new SnowboardSizeSpecs("154", 54, 82, "M", 116.5, 112, 7.3, 248, 53);
            SnowboardSizeSpecs freeThinker157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 119.5, 115, 7.5, 252, 56);
            SnowboardSizeSpecs freeThinker160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122.5, 118, 7.7, 255, 56);
            SnowboardSizeSpecs freeThinker157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 119.5, 115, 7.5, 260, 56);
            SnowboardSizeSpecs freeThinker160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 122.5, 118, 7.7, 263, 56);

            snowboardSizeSpecsRepository.save(freeThinker150);
            snowboardSizeSpecsRepository.save(freeThinker154);
            snowboardSizeSpecsRepository.save(freeThinker157);
            snowboardSizeSpecsRepository.save(freeThinker160);
            snowboardSizeSpecsRepository.save(freeThinker157W);
            snowboardSizeSpecsRepository.save(freeThinker160W);

            sb8.getBoardSizeSpecs().add(freeThinker150);
            sb8.getBoardSizeSpecs().add(freeThinker154);
            sb8.getBoardSizeSpecs().add(freeThinker157);
            sb8.getBoardSizeSpecs().add(freeThinker160);
            sb8.getBoardSizeSpecs().add(freeThinker157W);
            sb8.getBoardSizeSpecs().add(freeThinker160W);

            Terrain freeThinkert1 = new Terrain(park, 7);
            Terrain freeThinkert2 = new Terrain(allMountain, 8);
            Terrain freeThinkert3 = new Terrain(powder, 6);

            terrainRepository.save(freeThinkert1);
            terrainRepository.save(freeThinkert2);
            terrainRepository.save(freeThinkert3);

            sb8.getRidingterrains().add(freeThinkert1);
            sb8.getRidingterrains().add(freeThinkert2);
            sb8.getRidingterrains().add(freeThinkert3);

            sb8.getRiderLevels().add(intermediate);
            sb8.getRiderLevels().add(pro);

            // Paramount
            Snowboard sb9 = new Snowboard(brand1, "Paramount", male, 0, 4, "Paramount.webp", threeYears, "The pinnacle formula for high-caliber park performance: twin tip shape with the pop and raw power of camber.", "Launching to the moon or sliding down a rail, the NEW Burton Paramount is the vehicle that will get you there and back again. The precision and response of Camber combines with a classic twin tip shape for a freestyle formula that’s served riders since the birth of the terrain park. A medium flex provides stability and support for stomped landings, while still ensuring enough wiggle room to crank out a press on boxes, rails, and anything else in your path.");
            sb9.getTechDetails().add(camberBend);
            sb9.getTechDetails().add(twinShape);
            sb9.getTechDetails().add(twinFlex);
            sb9.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs paramount152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 115.5, 111, 7.6, 250, 53);
            SnowboardSizeSpecs paramount155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.8, 252, 53);
            SnowboardSizeSpecs paramount158 = new SnowboardSizeSpecs("158", 68, 91, "L", 121.5, 117, 7.5, 255, 56);
            SnowboardSizeSpecs paramount162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 121, 7.5, 258, 56);
            snowboardSizeSpecsRepository.save(paramount152);
            snowboardSizeSpecsRepository.save(paramount155);
            snowboardSizeSpecsRepository.save(paramount158);
            snowboardSizeSpecsRepository.save(paramount162);

            sb9.getBoardSizeSpecs().add(paramount152);
            sb9.getBoardSizeSpecs().add(paramount155);
            sb9.getBoardSizeSpecs().add(paramount158);
            sb9.getBoardSizeSpecs().add(paramount162);

            Terrain paramountt1 = new Terrain(park, 8);
            Terrain paramountt2 = new Terrain(allMountain, 8);
            Terrain paramountt3 = new Terrain(powder, 6);

            terrainRepository.save(paramountt1);
            terrainRepository.save(paramountt2);
            terrainRepository.save(paramountt3);

            sb9.getRidingterrains().add(paramountt1);
            sb9.getRidingterrains().add(paramountt2);
            sb9.getRidingterrains().add(paramountt3);

            sb9.getRiderLevels().add(intermediate);
            sb9.getRiderLevels().add(pro);

            // Custom X
            Snowboard sb10 = new Snowboard(brand1, "Custom X", male, -1.25, 9, "Custom_X.webp", threeYears, "Get pro-caliber speed and precision with the most aggressive board in Burton’s lineup.", "Pro-caliber is a strong statement for any board, but the Burton Custom X has repeatedly delivered for snowboarding’s most demanding riders due to precise design and powerful drive. The confidence is in the tech, which includes the carbon-fueled snap of Squeezebox High core profiling, a competition-grade base, and 45° Carbon Highlights High-Voltage for the ultimate in lightweight responsiveness. The hardest charging board we make, the Custom X is available in two versions: choose the power of camber or the float and catch-free feel of Flying V™.");
            sb10.getTechDetails().add(camberBend);
            sb10.getTechDetails().add(allMountainDirectionalShape);
            sb10.getTechDetails().add(twinFlex);
            sb10.getTechDetails().add(dragonfly600G);
            SnowboardSizeSpecs customX150 = new SnowboardSizeSpecs("150", 54, 82, "M", 113.5, 108, 7.4, 248, 50.5);
            SnowboardSizeSpecs customX154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs customX156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs customX158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs customX162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            SnowboardSizeSpecs customX158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121.5, 116.5, 7.9, 262, 56);
            SnowboardSizeSpecs customX162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 125.5, 120.5, 8.2, 264, 56);
            SnowboardSizeSpecs customX166W = new SnowboardSizeSpecs("166W", 82, 120, "L", 129.5, 124.5, 8.4, 266, 56);
            snowboardSizeSpecsRepository.save(customX150);
            snowboardSizeSpecsRepository.save(customX154);
            snowboardSizeSpecsRepository.save(customX156);
            snowboardSizeSpecsRepository.save(customX158);
            snowboardSizeSpecsRepository.save(customX162);
            snowboardSizeSpecsRepository.save(customX158W);
            snowboardSizeSpecsRepository.save(customX162W);
            snowboardSizeSpecsRepository.save(customX166W);

            sb10.getBoardSizeSpecs().add(customX150);
            sb10.getBoardSizeSpecs().add(customX154);
            sb10.getBoardSizeSpecs().add(customX156);
            sb10.getBoardSizeSpecs().add(customX158);
            sb10.getBoardSizeSpecs().add(customX162);
            sb10.getBoardSizeSpecs().add(customX158W);
            sb10.getBoardSizeSpecs().add(customX162W);
            sb10.getBoardSizeSpecs().add(customX166W);

            Terrain customXt1 = new Terrain(allMountain, 9);
            Terrain customXt2 = new Terrain(park, 6);
            Terrain customXt3 = new Terrain(powder, 7);

            terrainRepository.save(customXt1);
            terrainRepository.save(customXt2);
            terrainRepository.save(customXt3);

            sb10.getRidingterrains().add(customXt1);
            sb10.getRidingterrains().add(customXt2);
            sb10.getRidingterrains().add(customXt3);

            sb10.getRiderLevels().add(pro);

            // Custom
            Snowboard sb11 = new Snowboard(brand1, "Custom", male, -1.25, 6, "Custom.webp", threeYears, "The most trusted board ever, backed by a cult following as snowboarding’s one-answer to all terrain.", "Since its humble beginnings, innovation has defined the Burton Custom series and set it apart as the most popular, versatile, and mimicked board in snowboarding. Since 1996, this icon has reigned supreme and constantly evolved with a proven formula that combines time-honored design with envelope-pushing ingredients to create a lightweight, poppy, and highly versatile board. Offered in two versions, the precision and stability of the Custom camber is the top choice for many pro riders, while the Custom Flying V™ combines camber’s power with the relaxed float of rocker for the best of both worlds.");
            sb11.getTechDetails().add(camberBend);
            sb11.getTechDetails().add(allMountainDirectionalShape);
            sb11.getTechDetails().add(twinFlex);
            sb11.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs custom150 = new SnowboardSizeSpecs("150", 54, 82, "M", 113.5, 108.5, 7.4, 248, 50.5);
            SnowboardSizeSpecs custom154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs custom156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs custom158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs custom162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            SnowboardSizeSpecs custom154W = new SnowboardSizeSpecs("154W", 54, 82, "L", 117.5, 112, 7.6, 258, 50.5);
            SnowboardSizeSpecs custom158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121.5, 116.5, 7.9, 262, 56);
            SnowboardSizeSpecs custom162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 125.5, 120.5, 8.2, 264, 56);
            SnowboardSizeSpecs custom166W = new SnowboardSizeSpecs("166W", 82, 120, "L", 129.5, 124.5, 8.4, 266, 56);
            SnowboardSizeSpecs custom170W = new SnowboardSizeSpecs("170W", 82, 120, "L", 133.5, 128.5, 8.7, 270, 56);
            snowboardSizeSpecsRepository.save(custom150);
            snowboardSizeSpecsRepository.save(custom154);
            snowboardSizeSpecsRepository.save(custom156);
            snowboardSizeSpecsRepository.save(custom158);
            snowboardSizeSpecsRepository.save(custom162);
            snowboardSizeSpecsRepository.save(custom154W);
            snowboardSizeSpecsRepository.save(custom158W);
            snowboardSizeSpecsRepository.save(custom162W);
            snowboardSizeSpecsRepository.save(custom166W);
            snowboardSizeSpecsRepository.save(custom170W);

            sb11.getBoardSizeSpecs().add(custom150);
            sb11.getBoardSizeSpecs().add(custom154);
            sb11.getBoardSizeSpecs().add(custom156);
            sb11.getBoardSizeSpecs().add(custom158);
            sb11.getBoardSizeSpecs().add(custom162);
            sb11.getBoardSizeSpecs().add(custom154W);
            sb11.getBoardSizeSpecs().add(custom158W);
            sb11.getBoardSizeSpecs().add(custom162W);
            sb11.getBoardSizeSpecs().add(custom166W);
            sb11.getBoardSizeSpecs().add(custom170W);

            Terrain customt1 = new Terrain(allMountain, 10);
            Terrain customt2 = new Terrain(park, 6);
            Terrain customt3 = new Terrain(powder, 6);

            terrainRepository.save(customt1);
            terrainRepository.save(customt2);
            terrainRepository.save(customt3);

            sb11.getRidingterrains().add(customt1);
            sb11.getRidingterrains().add(customt2);
            sb11.getRidingterrains().add(customt3);

            sb11.getRiderLevels().add(intermediate);
            sb11.getRiderLevels().add(pro);

            //Kilroy
            Snowboard sb12 = new Snowboard(brand1, "Kilroy", male, -1.25, 5, "Kilroy.webp", threeYears, "A twisted evolution of the most trusted board in the game.", "Built for riding any and all terrain, the Men's Burton Kilroy Directional Camber Snowboard takes the attitude and approach of the most trusted board ever and gives it a new unique shape and construction. Better yet, it's a board that can be thrashed without worries thanks to a recipe that's high-performance without the price.");
            sb12.getTechDetails().add(directionalCamberBend);
            sb12.getTechDetails().add(allMountainDirectionalShape);
            sb12.getTechDetails().add(twinFlex);
            sb12.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs kilroy154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs kilroy158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.2, 116.5, 7.9, 254, 56);
            snowboardSizeSpecsRepository.save(kilroy154);
            snowboardSizeSpecsRepository.save(kilroy158);
            sb12.getBoardSizeSpecs().add(kilroy154);
            sb12.getBoardSizeSpecs().add(kilroy158);

            Terrain kilroyt1 = new Terrain(park, 10);
            Terrain kilroyt2 = new Terrain(allMountain, 7);
            Terrain kilroyt3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyt1);
            terrainRepository.save(kilroyt2);
            terrainRepository.save(kilroyt3);

            sb12.getRidingterrains().add(kilroyt1);
            sb12.getRidingterrains().add(kilroyt2);
            sb12.getRidingterrains().add(kilroyt3);

            sb12.getRiderLevels().add(intermediate);
            sb12.getRiderLevels().add(pro);

            // Family Tree Hometown Hero
            Snowboard sb13 = new Snowboard(brand1, "Family Tree Hometown Hero", male, -4, 6, "Family_Tree_Hometown.webp", threeYears, "Designed to thrive in Burton's back yard, this chunder buster loves to go fast, blast, and dodge through the tightest trees.", "Our board designers spend a lot of time poking around in the woods of Vermont, our home state. Tight trees, steep lines, and sudden drops are to be expected, and the Burton Hometown Hero is custom tailored to power through it all. Blast past the tourists and cut straight to the goods. Strategically placed glass stiffens up the nose and tail, allowing the center to flex while retaining snap and response where you need it most. Directional Camber blends with Balanced Freeride Geometry to maintain stability, while an FSC™ Certified Super Fly II™ core pairs with bio-based Super Sap® Epoxy for a low carbon footprint.");
            sb13.getTechDetails().add(flyingVBend);
            sb13.getTechDetails().add(freerideDirectionalShape);
            sb13.getTechDetails().add(twinFlex);
            sb13.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs familyTreeHomeTownHero152 = new SnowboardSizeSpecs("152", 54, 82, "M", 113.7, 108, 7.2, 248, 53);
            SnowboardSizeSpecs familyTreeHomeTownHero156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 117.7, 112, 7.4, 252, 56);
            SnowboardSizeSpecs familyTreeHomeTownHero160 = new SnowboardSizeSpecs("160", 82, 120, "L", 121.7, 116, 7.7, 258, 56);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero152);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero156);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero160);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero152);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero156);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero160);

            Terrain familyTreeHomeTownHerot1 = new Terrain(powder, 8);
            Terrain familyTreeHomeTownHerot2 = new Terrain(allMountain, 7);
            Terrain familyTreeHomeTownHerot3 = new Terrain(park, 3);

            terrainRepository.save(familyTreeHomeTownHerot1);
            terrainRepository.save(familyTreeHomeTownHerot2);
            terrainRepository.save(familyTreeHomeTownHerot3);

            sb13.getRidingterrains().add(familyTreeHomeTownHerot1);
            sb13.getRidingterrains().add(familyTreeHomeTownHerot2);
            sb13.getRidingterrains().add(familyTreeHomeTownHerot3);

            sb13.getRiderLevels().add(intermediate);
            sb13.getRiderLevels().add(pro);

            //Kiroy Twin
            Snowboard sb14 = new Snowboard(brand1, "Kilroy Twin", male, 0, 3, "Kilroy_Twin.jfif", threeYears, "The workingman's classic: a traditional camber twin, designed to thrive on all terrain.", "The rippers on ground level are looking for a board that can hang without worrying about the cost. The Men's Burton Kilroy Twin Camber Snowboard is here to give the people what they want with a classic twin shape inspired by the Process, but with a refined construction that focuses on strength, speed, and pop.");
            sb14.getTechDetails().add(camberBend);
            sb14.getTechDetails().add(twinShape);
            sb14.getTechDetails().add(twinFlex);
            sb14.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs kilroyTwin148 = new SnowboardSizeSpecs("148", 45, 68, "M", 111.5, 107, 7.3, 248, 53);
            SnowboardSizeSpecs kilroyTwin152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 115.5, 111, 7.6, 250, 53);
            SnowboardSizeSpecs kilroyTwin155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.8, 252, 56);
            SnowboardSizeSpecs kilroyTwin159 = new SnowboardSizeSpecs("159", 68, 91, "L", 122.5, 118, 8.1, 255, 56);
            snowboardSizeSpecsRepository.save(kilroyTwin148);
            snowboardSizeSpecsRepository.save(kilroyTwin152);
            snowboardSizeSpecsRepository.save(kilroyTwin155);
            snowboardSizeSpecsRepository.save(kilroyTwin159);

            sb14.getBoardSizeSpecs().add(kilroyTwin148);
            sb14.getBoardSizeSpecs().add(kilroyTwin152);
            sb14.getBoardSizeSpecs().add(kilroyTwin155);
            sb14.getBoardSizeSpecs().add(kilroyTwin159);

            Terrain kilroyTwint1 = new Terrain(park, 10);
            Terrain kilroyTwint2 = new Terrain(allMountain, 7);
            Terrain kilroyTwint3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyTwint1);
            terrainRepository.save(kilroyTwint2);
            terrainRepository.save(kilroyTwint3);

            sb14.getRidingterrains().add(kilroyTwint1);
            sb14.getRidingterrains().add(kilroyTwint2);
            sb14.getRidingterrains().add(kilroyTwint3);

            sb14.getRiderLevels().add(intermediate);

            // Family Tree Moon Buggy
            Snowboard sb15 = new Snowboard(brand1, "Family Tree Moon Buggy", male, -1.7, 5, "Family_Tree_Moon_Buggy.webp", threeYears, "Wider, shorter, surfier, heck, we might as well just say funner in all conditions", "Float in a surf-like state over interstellar landscapes on this playfully plus-sized rig. The Moon Buggy takes a big-kahuna approach to playful pow riding. The spaceship vibes stem from swallow-inspired 3-D construction in the tail, which complements the big nose for effortless float no matter how deep the swell gets.");
            sb15.getTechDetails().add(directionalCamberBend);
            sb15.getTechDetails().add(allMountainDirectionalShape);
            sb15.getTechDetails().add(directionalFlex);
            sb15.getTechDetails().add(dragonfly600G);
            SnowboardSizeSpecs familyTreeMoonBuggy158 = new SnowboardSizeSpecs("158", 68, 91, "L", 113.5, 107, 8.0, 262, 56);
            SnowboardSizeSpecs familyTreeMoonBuggy168 = new SnowboardSizeSpecs("168", 82, 120, "L", 123.5, 117, 8.8, 272, 56);
            snowboardSizeSpecsRepository.save(familyTreeMoonBuggy158);
            snowboardSizeSpecsRepository.save(familyTreeMoonBuggy168);
            sb15.getBoardSizeSpecs().add(familyTreeMoonBuggy158);
            sb15.getBoardSizeSpecs().add(familyTreeMoonBuggy168);

            Terrain familyTreeMoonBuggyt1 = new Terrain(powder, 10);
            Terrain familyTreeMoonBuggyt2 = new Terrain(allMountain, 3);
            Terrain familyTreeMoonBuggyt3 = new Terrain(park, 2);

            terrainRepository.save(familyTreeMoonBuggyt1);
            terrainRepository.save(familyTreeMoonBuggyt2);
            terrainRepository.save(familyTreeMoonBuggyt3);

            sb15.getRidingterrains().add(familyTreeMoonBuggyt1);
            sb15.getRidingterrains().add(familyTreeMoonBuggyt2);
            sb15.getRidingterrains().add(familyTreeMoonBuggyt3);

            sb15.getRiderLevels().add(pro);

            //Deep Thinker
            Snowboard sb16 = new Snowboard(brand1, "Deep Thinker", male, -2.5, 6, "Deep_Thinker.jfif", threeYears, "Open your mind with Danny Davis' new take on extra-poppy, pow-friendly performance.", "The Burton Deep Thinker is a directional spin on Danny Davis' go-to for hot laps in the park, pipe, or mobbing side hits across the mountain. Adding the float and responsiveness of Directional Camber to a unique shape designed with Balanced Freeride Geometry and just a touch of taper ups the all-mountain abilities while keeping the freestyle performance on full blast. 45° Carbon Highlights deliver snappy pop without the stiff side effects. Throwback graphics top it off, adding a touch of Burton's early 90's roots to an already iconic model.");
            sb16.getTechDetails().add(directionalCamberBend);
            sb16.getTechDetails().add(allMountainDirectionalShape);
            sb16.getTechDetails().add(directionalFlex);
            sb16.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs deepThinker154 = new SnowboardSizeSpecs("154", 54, 82, "M", 116, 111.5, 7.2, 248, 53);
            SnowboardSizeSpecs deepThinker157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 119, 114.5, 7.4, 252, 56);
            SnowboardSizeSpecs deepThinker160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 117.5, 7.6, 255, 56);
            SnowboardSizeSpecs deepThinker157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 118.5, 114, 7.4, 260, 56);
            SnowboardSizeSpecs deepThinker160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 121.5, 117, 7.6, 263, 56);
            SnowboardSizeSpecs deepThinker163W = new SnowboardSizeSpecs("163W", 82, 120, "L", 124.5, 120, 7.8, 265, 56);
            snowboardSizeSpecsRepository.save(deepThinker154);
            snowboardSizeSpecsRepository.save(deepThinker157);
            snowboardSizeSpecsRepository.save(deepThinker160);
            snowboardSizeSpecsRepository.save(deepThinker157W);
            snowboardSizeSpecsRepository.save(deepThinker160W);
            snowboardSizeSpecsRepository.save(deepThinker163W);
            sb16.getBoardSizeSpecs().add(deepThinker154);
            sb16.getBoardSizeSpecs().add(deepThinker157);
            sb16.getBoardSizeSpecs().add(deepThinker160);
            sb16.getBoardSizeSpecs().add(deepThinker157W);
            sb16.getBoardSizeSpecs().add(deepThinker160W);
            sb16.getBoardSizeSpecs().add(deepThinker163W);

            Terrain deepTinkert1 = new Terrain(allMountain, 7);
            Terrain deepTinkert2 = new Terrain(powder, 7);
            Terrain deepTinkert3 = new Terrain(park, 5);

            terrainRepository.save(deepTinkert1);
            terrainRepository.save(deepTinkert2);
            terrainRepository.save(deepTinkert3);

            sb16.getRidingterrains().add(deepTinkert1);
            sb16.getRidingterrains().add(deepTinkert2);
            sb16.getRidingterrains().add(deepTinkert3);

            sb16.getRiderLevels().add(intermediate);
            sb16.getRiderLevels().add(pro);

            // Flight Attendant
            Snowboard sb17 = new Snowboard(brand1, "Flight Attendant", male, -3.5, 6, "Flight_Attendant.webp", threeYears, "Prepare for take-off with a board that makes waves for its abilities to carve and catch air.", "Designed to be a terrain-slaying alternative to more traditional twin shapes, the Burton Flight Attendant is a free spirit that dissects both pow and hard-pack with equal precision. Balanced Freeride Geometry is the secret with setback camber and sidecut that are centered on your stance to create a twin freestyle feel when riding flat base. On edge the board turns tight and quick, with Directional Camber and taper for added float and flow. A blend of big mountain attributes and all-terrain aggression, the Flight Attendant finds the sweet spot for everything from steep lines and spontaneous slashes to wind-lips, pillows, and side hits.");
            sb17.getTechDetails().add(directionalCamberBend);
            sb17.getTechDetails().add(freerideDirectionalShape);
            sb17.getTechDetails().add(directionalFlex);
            sb17.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs flightAttendant152 = new SnowboardSizeSpecs("152", 54, 82, "S/M", 114, 108, 7.2, 244, 53);
            SnowboardSizeSpecs flightAttendant156 = new SnowboardSizeSpecs("156", 68, 91, "M", 118, 112, 7.4, 248, 56);
            SnowboardSizeSpecs flightAttendant159 = new SnowboardSizeSpecs("159", 82, 120, "M/L", 121, 115, 7.6, 250, 56);
            SnowboardSizeSpecs flightAttendant162 = new SnowboardSizeSpecs("162", 82, 120, "M/L", 124, 118, 7.8, 254, 56);
            SnowboardSizeSpecs flightAttendant168 = new SnowboardSizeSpecs("168", 82, 120, "L", 129.5, 123.5, 8.2, 260, 56);
            SnowboardSizeSpecs flightAttendant159W = new SnowboardSizeSpecs("159W", 68, 91, "L", 121, 115, 7.6, 260, 56);
            SnowboardSizeSpecs flightAttendant162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 124, 118, 7.8, 264, 56);
            snowboardSizeSpecsRepository.save(flightAttendant152);
            snowboardSizeSpecsRepository.save(flightAttendant156);
            snowboardSizeSpecsRepository.save(flightAttendant159);
            snowboardSizeSpecsRepository.save(flightAttendant162);
            snowboardSizeSpecsRepository.save(flightAttendant168);
            snowboardSizeSpecsRepository.save(flightAttendant159W);
            snowboardSizeSpecsRepository.save(flightAttendant162W);
            sb17.getBoardSizeSpecs().add(flightAttendant152);
            sb17.getBoardSizeSpecs().add(flightAttendant156);
            sb17.getBoardSizeSpecs().add(flightAttendant159);
            sb17.getBoardSizeSpecs().add(flightAttendant162);
            sb17.getBoardSizeSpecs().add(flightAttendant168);
            sb17.getBoardSizeSpecs().add(flightAttendant159W);
            sb17.getBoardSizeSpecs().add(flightAttendant162W);

            Terrain flightAttendantt1 = new Terrain(allMountain, 8);
            Terrain flightAttendantt2 = new Terrain(powder, 8);
            Terrain flightAttendantt3 = new Terrain(park, 4);

            terrainRepository.save(flightAttendantt1);
            terrainRepository.save(flightAttendantt2);
            terrainRepository.save(flightAttendantt3);

            sb17.getRidingterrains().add(flightAttendantt1);
            sb17.getRidingterrains().add(flightAttendantt2);
            sb17.getRidingterrains().add(flightAttendantt3);

            sb17.getRiderLevels().add(intermediate);
            sb17.getRiderLevels().add(pro);

            // Family Tree One Hitter 
            Snowboard sb18 = new Snowboard(brand1, "Family Tree One Hitter", male, -2.5, 4, "Family_Tree_One_Hitter.webp", threeYears, "Spark up the groomers, slash the stashes, and put your signature on every side hit along the way.", "Neck deep pow is always a treat, but nothing beats a day spent hot lapping your favorite runs, smashing side hits, and treating the whole mountain like a terrain park. We baked this mentality into the Burton One Hitter to make it the one board that's hungrier for deep carves and natty airs than you are. With the snappy combo of a rad new shape and Directional Camber, it's built like a missile, but still soft enough to keep things buttery and playful. For good measure, an FSC™ Certified Super Fly II™ core pairs with bio-based Super Sap® Epoxy to cut the carbon footprint.");
            sb18.getTechDetails().add(directionalCamberBend);
            sb18.getTechDetails().add(freerideDirectionalShape);
            sb18.getTechDetails().add(directionalFlex);
            sb18.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs familyTreeOneHitter152 = new SnowboardSizeSpecs("152", 54, 82, "L", 114, 109, 7.2, 255, 53);
            SnowboardSizeSpecs familyTreeOneHitter156 = new SnowboardSizeSpecs("156", 68, 91, "L", 118, 113, 7.5, 260, 56);
            SnowboardSizeSpecs familyTreeOneHitter160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 117, 7.7, 265, 56);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter152);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter156);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter160);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter152);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter156);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter160);

            Terrain familyTreeOneHittert1 = new Terrain(allMountain, 8);
            Terrain familyTreeOneHittert2 = new Terrain(powder, 7);
            Terrain familyTreeOneHittert3 = new Terrain(park, 5);

            terrainRepository.save(familyTreeOneHittert1);
            terrainRepository.save(familyTreeOneHittert2);
            terrainRepository.save(familyTreeOneHittert3);

            sb18.getRidingterrains().add(familyTreeOneHittert1);
            sb18.getRidingterrains().add(familyTreeOneHittert2);
            sb18.getRidingterrains().add(familyTreeOneHittert3);

            sb18.getRiderLevels().add(intermediate);
            sb18.getRiderLevels().add(pro);

            // Family Tree Leader Board 
            Snowboard sb19 = new Snowboard(brand1, "Family Tree Leader Board", male, -2.5, 8, "Family_Tree_Leader_Board.webp", threeYears, "A big mountain burner, designed in collaboration with 5-time Xtreme Verbier Champion, Steve Klassen.", "Freeride champions and big mountain billy goats, take note. The Burton Leader Board puts control and response right beneath your feet. Directional Camber blends with Balanced Freeride Geometry to maintain stability through hair-raising lines, while a reduced sidecut and spooned 3-D contours in the nose nix any catchy contact points. An FSC™ Certified Super Fly II™ core reinforced by a carbon I-Beam™ pairs with bio-based Super Sap® Epoxy for a low carbon footprint.");
            sb19.getTechDetails().add(directionalCamberBend);
            sb19.getTechDetails().add(allMountainDirectionalShape);
            sb19.getTechDetails().add(directionalFlex);
            sb19.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs familyTreeLeaderBoard158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 114, 8.6, 252, 56);
            SnowboardSizeSpecs familyTreeLeaderBoard162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 118, 8.8, 255, 56);
            SnowboardSizeSpecs familyTreeLeaderBoard166 = new SnowboardSizeSpecs("166", 82, 120, "L", 126, 122, 9.2, 260, 56);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard158);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard162);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard166);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard158);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard162);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard166);

            Terrain familyTreeLeaderBoardt1 = new Terrain(powder, 10);
            Terrain familyTreeLeaderBoardt2 = new Terrain(allMountain, 5);
            Terrain familyTreeLeaderBoardt3 = new Terrain(park, 2);

            terrainRepository.save(familyTreeLeaderBoardt1);
            terrainRepository.save(familyTreeLeaderBoardt2);
            terrainRepository.save(familyTreeLeaderBoardt3);

            sb19.getRidingterrains().add(familyTreeLeaderBoardt1);
            sb19.getRidingterrains().add(familyTreeLeaderBoardt2);
            sb19.getRidingterrains().add(familyTreeLeaderBoardt3);

            sb19.getRiderLevels().add(intermediate);
            sb19.getRiderLevels().add(pro);

            // Skeleton Key
            Snowboard sb20 = new Snowboard(brand1, "Skeleton Key", male, -5, 4, "Skeleton_Key.webp", threeYears, "A directional utility tool designed to unlock the full spectrum of freeride terrain.", "The offspring of a one-night stand between two of Burton's most revered all-terrain boards, the Burton Skeleton Key has quickly become a staple in the quivers of our testers and team riders. From Japan-deep pow to Mount Baker's legendary banks, this uniquely hard-charging directional shape fuses camber with a slightly increased waist width that carves like a knife.");
            sb20.getTechDetails().add(directionalCamberBend);
            sb20.getTechDetails().add(freerideDirectionalShape);
            sb20.getTechDetails().add(directionalFlex);
            sb20.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs skeletonKey150 = new SnowboardSizeSpecs("150", 54, 82, "M/L", 112.5, 106.5, 7.1, 252, 53);
            SnowboardSizeSpecs skeletonKey154 = new SnowboardSizeSpecs("154", 54, 82, "L", 116.5, 110.5, 7.4, 256, 53);
            SnowboardSizeSpecs skeletonKey158 = new SnowboardSizeSpecs("158", 68, 91, "L", 120.5, 114.5, 7.7, 258, 56);
            SnowboardSizeSpecs skeletonKey162 = new SnowboardSizeSpecs("162", 82, 120, "L", 124.5, 118.5, 7.9, 262, 56);
            snowboardSizeSpecsRepository.save(skeletonKey150);
            snowboardSizeSpecsRepository.save(skeletonKey154);
            snowboardSizeSpecsRepository.save(skeletonKey158);
            snowboardSizeSpecsRepository.save(skeletonKey162);
            sb20.getBoardSizeSpecs().add(skeletonKey150);
            sb20.getBoardSizeSpecs().add(skeletonKey154);
            sb20.getBoardSizeSpecs().add(skeletonKey158);
            sb20.getBoardSizeSpecs().add(skeletonKey162);

            Terrain skeletonKeyt1 = new Terrain(allMountain, 8);
            Terrain skeletonKeyt2 = new Terrain(powder, 7);
            Terrain skeletonKeyt3 = new Terrain(park, 4);

            terrainRepository.save(skeletonKeyt1);
            terrainRepository.save(skeletonKeyt2);
            terrainRepository.save(skeletonKeyt3);

            sb20.getRidingterrains().add(skeletonKeyt1);
            sb20.getRidingterrains().add(skeletonKeyt2);
            sb20.getRidingterrains().add(skeletonKeyt3);

            sb20.getRiderLevels().add(pro);

            // Throwback
            //Snowboard sb21 = new Snowboard(brand1, "Flight Attendant",  male, -1.25, camber, allMountainDirectionalShape, twinFlex, superFly2700G, 6,  "Flight_Attendant.webp", "", ""); 
            // Descendant
            Snowboard sb22 = new Snowboard(brand1, "Descendant", male, 0, 2, "Descendant.webp", threeYears, "A soft and poppy deck that's perfect for taking what you learn in the park to the entire mountain.", "Dominate the park while getting maximum bang for your buck with the feature-packed Burton Descendant. True twin shaping gives it a freestyle punch, allowing you to ride in either direction with equal control. Soft and playful, it also steps up stability and edge control with the catch-free, park-tuned feel of PurePop Camber. Squeezebox Low provides a softer flex that maintains snappiness and ollie power. The Channel® gives you ultimate control of your stance and the fastest setup possible in a system compatible with bindings from all major brands.");
            sb22.getTechDetails().add(purePopCamberBend);
            sb22.getTechDetails().add(twinShape);
            sb22.getTechDetails().add(twinFlex);
            sb22.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs descendant148 = new SnowboardSizeSpecs("148", 45, 68, "S/M", 111.5, 107, 7.1, 246, 53);
            SnowboardSizeSpecs descendant152 = new SnowboardSizeSpecs("152", 54, 82, "M", 115.5, 111, 7.3, 248, 53);
            SnowboardSizeSpecs descendant155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.5, 250, 53);
            SnowboardSizeSpecs descendant158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 117, 7.7, 251, 56);
            SnowboardSizeSpecs descendant160 = new SnowboardSizeSpecs("162", 82, 120, "L", 123.5, 119, 7.8, 258, 56);
            SnowboardSizeSpecs descendant155W = new SnowboardSizeSpecs("155W", 54, 82, "L", 118, 114, 7.5, 264, 53);
            SnowboardSizeSpecs descendant158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121, 117, 7.7, 265, 56);
            snowboardSizeSpecsRepository.save(descendant148);
            snowboardSizeSpecsRepository.save(descendant152);
            snowboardSizeSpecsRepository.save(descendant155);
            snowboardSizeSpecsRepository.save(descendant158);
            snowboardSizeSpecsRepository.save(descendant160);
            snowboardSizeSpecsRepository.save(descendant155W);
            snowboardSizeSpecsRepository.save(descendant158W);
            sb22.getBoardSizeSpecs().add(descendant148);
            sb22.getBoardSizeSpecs().add(descendant152);
            sb22.getBoardSizeSpecs().add(descendant155);
            sb22.getBoardSizeSpecs().add(descendant158);
            sb22.getBoardSizeSpecs().add(descendant160);
            sb22.getBoardSizeSpecs().add(descendant155W);
            sb22.getBoardSizeSpecs().add(descendant158W);

            Terrain descendantt1 = new Terrain(allMountain, 8);
            Terrain descendantt2 = new Terrain(park, 7);
            Terrain descendantt3 = new Terrain(powder, 4);

            terrainRepository.save(descendantt1);
            terrainRepository.save(descendantt2);
            terrainRepository.save(descendantt3);

            sb22.getRidingterrains().add(descendantt1);
            sb22.getRidingterrains().add(descendantt2);
            sb22.getRidingterrains().add(descendantt3);

            sb22.getRiderLevels().add(intermediate);

            // Family Tree Backseat Driver
            Snowboard sb23 = new Snowboard(brand1, "Family Tree Backseat Driver", male, 0, 8, "Family_Tree_Backseat_Driver.webp", threeYears, "Free your feet, free you mind – true snowboard construction built to surf on snow.", "Surf-inspired design meets traditional snowboard construction in the Burton Backseat Driver. If you're wondering, \"where do the bindings go?\" They don't. This pow surfer is designed to surf sans-straps everywhere from your backyard to the backcountry. A spoon nose provides float and flow, working in conjunction with a V-hull in the tail that maintains a loose feeling, but transitions into a strong, powerful turn when engaged. This board is built to push boundaries, and spread the joy of surfing on snow.");
            sb23.getTechDetails().add(directionalFlatTopBend);
            sb23.getTechDetails().add(allMountainDirectionalShape);
            sb23.getTechDetails().add(directionalFlex);
            sb23.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs familyTreeBackseatDriver = new SnowboardSizeSpecs("140", 54, 82, "L", 85, 67, 4.3, 260, 53);
            snowboardSizeSpecsRepository.save(familyTreeBackseatDriver);

            sb23.getBoardSizeSpecs().add(familyTreeBackseatDriver);

            Terrain familyTreeBackseatDrivert1 = new Terrain(powder, 10);
            Terrain familyTreeBackseatDrivert2 = new Terrain(allMountain, 2);
            Terrain familyTreeBackseatDrivert3 = new Terrain(powder, 0);

            terrainRepository.save(familyTreeBackseatDrivert1);
            terrainRepository.save(familyTreeBackseatDrivert2);
            terrainRepository.save(familyTreeBackseatDrivert3);

            sb23.getRidingterrains().add(familyTreeBackseatDrivert1);
            sb23.getRidingterrains().add(familyTreeBackseatDrivert2);
            sb23.getRidingterrains().add(familyTreeBackseatDrivert3);

            sb23.getRiderLevels().add(pro);

            //Name Dropper
            Snowboard sb24 = new Snowboard(brand1, "Name Dropper", male, 0, 2, "Name_Dropper.webp", threeYears, "People will be dropping your name in no time when you unleash the fury on this park-tuned powerhouse.", "Let your riding speak for itself with the Name Dropper's next-generation, park-tuned performance. Off-Axis means all of its key ingredients, from the edges to the poppy core profile, match the angles of your stance for enhanced grip, smoother takeoffs, and stomped landings. PurePop Camber amplifies ollies and loosens up the overall feel for a more playful take on traditional camber, while the addition of effortlessly flexing Off-Axis Squeezebox Low enhances the overall soft freestyle feel.");
            sb24.getTechDetails().add(purePopCamberBend);
            sb24.getTechDetails().add(twinShape);
            sb24.getTechDetails().add(twinFlex);
            sb24.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs nameDropper148 = new SnowboardSizeSpecs("148", 45, 68, "M", 112.3, 107.8, 7.1, 247, 53);
            SnowboardSizeSpecs nameDropper151 = new SnowboardSizeSpecs("151", 54, 82, "M/L", 114.9, 110.4, 7.3, 249, 53);
            SnowboardSizeSpecs nameDropper155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.5, 251, 56);
            SnowboardSizeSpecs nameDropper158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.1, 116.6, 7.7, 253, 56);
            snowboardSizeSpecsRepository.save(nameDropper148);
            snowboardSizeSpecsRepository.save(nameDropper151);
            snowboardSizeSpecsRepository.save(nameDropper155);
            snowboardSizeSpecsRepository.save(nameDropper158);
            sb24.getBoardSizeSpecs().add(nameDropper148);
            sb24.getBoardSizeSpecs().add(nameDropper151);
            sb24.getBoardSizeSpecs().add(nameDropper155);
            sb24.getBoardSizeSpecs().add(nameDropper158);

            Terrain nameDroppert1 = new Terrain(park, 9);
            Terrain nameDroppert2 = new Terrain(allMountain, 7);
            Terrain nameDroppert3 = new Terrain(powder, 4);

            terrainRepository.save(nameDroppert1);
            terrainRepository.save(nameDroppert2);
            terrainRepository.save(nameDroppert3);

            sb24.getRidingterrains().add(nameDroppert1);
            sb24.getRidingterrains().add(nameDroppert2);
            sb24.getRidingterrains().add(nameDroppert3);

            sb24.getRiderLevels().add(intermediate);

            // Kilroy 3D 
            Snowboard sb25 = new Snowboard(brand1, "Kilroy 3D", male, 0, 3, "Kilroy_3D.webp", threeYears, "Introducing the park board's next evolution: 3D construction for an even butterier ride.", "The perfect press is still out there, and the Burton Kilroy 3D is hell bent on finding it. 3D contours in the nose and tail remove material where it's least needed, putting a new focus on flex, and opening doors to catch-free buttery exploration. Heck, if the Kilroys are backing it, we're all in.");
            sb25.getTechDetails().add(purePopCamberBend);
            sb25.getTechDetails().add(twinShape);
            sb25.getTechDetails().add(twinFlex);
            sb25.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs kilroy3D150 = new SnowboardSizeSpecs("150", 54, 82, "M/L", 114, 109, 7.3, 250, 53);
            SnowboardSizeSpecs kilroy3D154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 118, 113, 7.6, 254, 53);
            SnowboardSizeSpecs kilroy3D158 = new SnowboardSizeSpecs("158", 68, 91, "L", 122, 117, 7.8, 258, 56);
            snowboardSizeSpecsRepository.save(kilroy3D150);
            snowboardSizeSpecsRepository.save(kilroy3D154);
            snowboardSizeSpecsRepository.save(kilroy3D158);
            sb25.getBoardSizeSpecs().add(kilroy3D150);
            sb25.getBoardSizeSpecs().add(kilroy3D154);
            sb25.getBoardSizeSpecs().add(kilroy3D158);

            Terrain kilroy3Dt1 = new Terrain(park, 10);
            Terrain kilroy3Dt2 = new Terrain(allMountain, 7);
            Terrain kilroy3Dt3 = new Terrain(powder, 4);

            terrainRepository.save(kilroy3Dt1);
            terrainRepository.save(kilroy3Dt2);
            terrainRepository.save(kilroy3Dt3);

            sb25.getRidingterrains().add(kilroy3Dt1);
            sb25.getRidingterrains().add(kilroy3Dt2);
            sb25.getRidingterrains().add(kilroy3Dt3);

            sb25.getRiderLevels().add(intermediate);
            sb25.getRiderLevels().add(pro);

            // Ripcord
            Snowboard sb26 = new Snowboard(brand1, "Ripcord", male, -2.5, 2, "Ripcord.webp", threeYears, "Blast past the learning curve with the easiest, most progression-friendly men's board we make.", "Blast past the learning curve with the easiest, most progression-friendly men's board we make.");
            sb26.getTechDetails().add(flatTopBend);
            sb26.getTechDetails().add(allMountainDirectionalShape);
            sb26.getTechDetails().add(directionalFlex);
            sb26.getTechDetails().add(fly900G);
            SnowboardSizeSpecs ripcord148 = new SnowboardSizeSpecs("145", 45, 68, "S/M", 111, 106, 7.1, 244, 48);
            SnowboardSizeSpecs ripcord150 = new SnowboardSizeSpecs("150", 54, 82, "M", 116, 111, 7.4, 247, 50.5);
            SnowboardSizeSpecs ripcord154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 120, 118, 7.7, 250, 53);
            SnowboardSizeSpecs ripcord157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 123, 118, 7.9, 253, 56);
            SnowboardSizeSpecs ripcord159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 118.5, 7.9, 256, 56);
            SnowboardSizeSpecs ripcord156W = new SnowboardSizeSpecs("156W", 68, 91, "L", 122, 117, 7.8, 258, 56);
            SnowboardSizeSpecs ripcord158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 122.5, 117.5, 7.8, 259, 56);
            SnowboardSizeSpecs ripcord162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 126, 121, 8.1, 261, 56);
            snowboardSizeSpecsRepository.save(ripcord148);
            snowboardSizeSpecsRepository.save(ripcord150);
            snowboardSizeSpecsRepository.save(ripcord154);
            snowboardSizeSpecsRepository.save(ripcord157);
            snowboardSizeSpecsRepository.save(ripcord159);
            snowboardSizeSpecsRepository.save(ripcord156W);
            snowboardSizeSpecsRepository.save(ripcord158W);
            snowboardSizeSpecsRepository.save(ripcord162W);
            sb26.getBoardSizeSpecs().add(ripcord148);
            sb26.getBoardSizeSpecs().add(ripcord150);
            sb26.getBoardSizeSpecs().add(ripcord154);
            sb26.getBoardSizeSpecs().add(ripcord157);
            sb26.getBoardSizeSpecs().add(ripcord159);
            sb26.getBoardSizeSpecs().add(ripcord156W);
            sb26.getBoardSizeSpecs().add(ripcord158W);
            sb26.getBoardSizeSpecs().add(ripcord162W);

            Terrain ripcordt1 = new Terrain(allMountain, 8);
            Terrain ripcordt2 = new Terrain(park, 4);
            Terrain ripcordt3 = new Terrain(powder, 4);

            terrainRepository.save(ripcordt1);
            terrainRepository.save(ripcordt2);
            terrainRepository.save(ripcordt3);

            sb26.getRidingterrains().add(ripcordt1);
            sb26.getRidingterrains().add(ripcordt2);
            sb26.getRidingterrains().add(ripcordt3);

            sb26.getRiderLevels().add(beginner);

            // Custom X Flying V
            Snowboard sb27 = new Snowboard(brand1, "Custom X Flying V", male, -1.25, 6, "Custom_X_FV.webp", threeYears, "Get pro-caliber speed and precision with the most aggressive board in Burton's lineup.", "Pro-caliber is a strong statement for any board, but the Burton Custom X has repeatedly delivered for snowboarding's most demanding riders due to precise design and powerful drive. The confidence is in the tech, which includes the carbon-fueled snap of Squeezebox High core profiling, a competition-grade base, and 45° Carbon Highlights High-Voltage for the ultimate in lightweight responsiveness. The hardest charging board we make, the Custom X is available in two versions: choose the power of camber or the float and catch-free feel of Flying V.");
            sb27.getTechDetails().add(flyingVBend);
            sb27.getTechDetails().add(allMountainDirectionalShape);
            sb27.getTechDetails().add(twinFlex);
            sb27.getTechDetails().add(dragonfly600G);
            SnowboardSizeSpecs customXFV154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs customXFV156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs customXFV158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs customXFV162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            snowboardSizeSpecsRepository.save(customXFV154);
            snowboardSizeSpecsRepository.save(customXFV156);
            snowboardSizeSpecsRepository.save(customXFV158);
            snowboardSizeSpecsRepository.save(customXFV162);

            sb27.getBoardSizeSpecs().add(customXFV154);
            sb27.getBoardSizeSpecs().add(customXFV156);
            sb27.getBoardSizeSpecs().add(customXFV158);
            sb27.getBoardSizeSpecs().add(customXFV162);

            Terrain customXFVt1 = new Terrain(allMountain, 9);
            Terrain customXFVt2 = new Terrain(park, 5);
            Terrain customXFVt3 = new Terrain(powder, 7);

            terrainRepository.save(customXFVt1);
            terrainRepository.save(customXFVt2);
            terrainRepository.save(customXFVt3);

            sb27.getRidingterrains().add(customXFVt1);
            sb27.getRidingterrains().add(customXFVt2);
            sb27.getRidingterrains().add(customXFVt3);

            sb27.getRiderLevels().add(pro);
            
            // Talent Scout
            Snowboard sb28 = new Snowboard(brand1, "Talent Scout", female, 0, 7, "Talent_Scout.webp", threeYears, "Bad-ass with a touch of sass in an action-packed board that'll have you falling in love with camber all over again.", "The Burton Talent Scout is on a mission to track down the best of park progression. A step up in pro-driven attitude from other twins, a camber profile gives riders the power, control, and finesse to thrive on all terrain. Designed to fit like a glove, the Talent Scout's Off-Axis design aligns the Squeezebox core profiling and Frostbite Edges with the typical park rider's stance, unlocking the board's natural flex and edge hold for buttery smooth control.");
            sb28.getTechDetails().add(camberBend);
            sb28.getTechDetails().add(twinShape);
            sb28.getTechDetails().add(twinFlex);
            sb28.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs talentScout138 = new SnowboardSizeSpecs("138", 36, 54, "S/M", 101.5, 97, 6.5, 235, 48);
            SnowboardSizeSpecs talentScout141 = new SnowboardSizeSpecs("141", 45, 68, "M", 104.5, 100, 6.7, 237, 48);
            SnowboardSizeSpecs talentScout146 = new SnowboardSizeSpecs("146", 54, 82, "M/L", 109.5, 105, 7.0, 240, 50.5);
            SnowboardSizeSpecs talentScout149 = new SnowboardSizeSpecs("149", 54, 82, "M/L", 112.5, 108, 7.2, 242, 53);
            SnowboardSizeSpecs talentScout152 = new SnowboardSizeSpecs("152", 68, 91, "L", 115.5, 111, 7.4, 245, 53);
            snowboardSizeSpecsRepository.save(talentScout138);
            snowboardSizeSpecsRepository.save(talentScout141);
            snowboardSizeSpecsRepository.save(talentScout146);
            snowboardSizeSpecsRepository.save(talentScout149);
            snowboardSizeSpecsRepository.save(talentScout152);

            sb28.getBoardSizeSpecs().add(talentScout138);
            sb28.getBoardSizeSpecs().add(talentScout141);
            sb28.getBoardSizeSpecs().add(talentScout146);
            sb28.getBoardSizeSpecs().add(talentScout149);
            sb28.getBoardSizeSpecs().add(talentScout152);

            Terrain talentScoutt1 = new Terrain(allMountain, 8);
            Terrain talentScoutt2 = new Terrain(park, 8);
            Terrain talentScoutt3 = new Terrain(powder, 6);

            terrainRepository.save(talentScoutt1);
            terrainRepository.save(talentScoutt2);
            terrainRepository.save(talentScoutt3);

            sb28.getRidingterrains().add(talentScoutt1);
            sb28.getRidingterrains().add(talentScoutt2);
            sb28.getRidingterrains().add(talentScoutt3);

            sb28.getRiderLevels().add(intermediate);
            sb28.getRiderLevels().add(pro);
            
            // Family Tree Story Board
            Snowboard sb29 = new Snowboard(brand1, "Family Tree Story Board", female, -3.5, 7, "Family_Tree_Story_Board.webp", threeYears, "Whether you're in deep or up in the air, spin tall tales on the ultimate freeride shape for women who seek to send it.", "When our designers saw women reaching for men's models like the Flight Attendant, they decided it was high time to create the ultimate women's freeride machine. The Burton Story Board is designed to create hard charging moments – the kind you'll be spinning yarns about for years to come. Control, versatility and confidence are key themes. A women's-specific core profile complements the directionally cambered shape and 10mm of taper with torsional flex that drives and floats through turns on groomers and deep days alike.");
            sb29.getTechDetails().add(directionalCamberBend);
            sb29.getTechDetails().add(freerideDirectionalShape);
            sb29.getTechDetails().add(directionalFlex);
            sb29.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs familyTreeStoryBoard142 = new SnowboardSizeSpecs("142", 45, 68, "M", 105, 99, 6.6, 238, 48);
            SnowboardSizeSpecs familyTreeStoryBoard147 = new SnowboardSizeSpecs("147", 54, 82, "M/L", 110, 104, 6.9, 242, 50.5);
            SnowboardSizeSpecs familyTreeStoryBoard152 = new SnowboardSizeSpecs("152", 68, 91, "M/L", 115, 109, 7.2, 245, 53);
            snowboardSizeSpecsRepository.save(familyTreeStoryBoard142);
            snowboardSizeSpecsRepository.save(familyTreeStoryBoard147);
            snowboardSizeSpecsRepository.save(familyTreeStoryBoard152);

            sb29.getBoardSizeSpecs().add(familyTreeStoryBoard142);
            sb29.getBoardSizeSpecs().add(familyTreeStoryBoard147);
            sb29.getBoardSizeSpecs().add(familyTreeStoryBoard152);

            Terrain familyTreeStoryBoardT1 = new Terrain(allMountain, 8);
            Terrain familyTreeStoryBoardT2 = new Terrain(powder, 8);
            Terrain familyTreeStoryBoardT3 = new Terrain(park, 3);

            terrainRepository.save(familyTreeStoryBoardT1);
            terrainRepository.save(familyTreeStoryBoardT2);
            terrainRepository.save(familyTreeStoryBoardT3);

            sb29.getRidingterrains().add(familyTreeStoryBoardT1);
            sb29.getRidingterrains().add(familyTreeStoryBoardT2);
            sb29.getRidingterrains().add(familyTreeStoryBoardT3);

            sb29.getRiderLevels().add(pro);
            
            
            // Stylus 
            Snowboard sb30 = new Snowboard(brand1, "Stylus", female, 0, 2, "Stylus.webp", threeYears, "Set the Stylus to snow and make your first mark on a blank slate, the best intro to snowboarding out there.", "Hands down the easiest women’s board in the line, the Burton Stylus is perfect for aspiring riders looking to build a foundation before moving on to a more performance-oriented option. Like setting a pen to a blank piece of paper, the Stylus silences your fears, teaching balance and board control from the first time you strap in. Easy Bevel combines a soft, mellow flex with a convex base for a virtually-catch free riding experience, while Flat Top™ and a true twin shape provide a stable platform that's effortlessly maneuverable no matter which way you point it. The Channel® mounting system gives you the easiest, most adjustable setup with bindings from all major brands (not just Burton’s).");
            sb30.getTechDetails().add(flatTopBend);
            sb30.getTechDetails().add(twinShape);
            sb30.getTechDetails().add(twinFlex);
            sb30.getTechDetails().add(fly900G);
            SnowboardSizeSpecs stylus138 = new SnowboardSizeSpecs("138", 45, 68, "M/L", 101.5, 90, 5.9, 240, 48);
            SnowboardSizeSpecs stylus142 = new SnowboardSizeSpecs("142", 45, 68, "M/L", 105, 93, 6.1, 241, 50.5);
            SnowboardSizeSpecs stylus147 = new SnowboardSizeSpecs("147", 54, 82, "M/L", 110, 98, 6.4, 242, 53);
            SnowboardSizeSpecs stylus152 = new SnowboardSizeSpecs("152", 68, 91, "L", 114.5, 102, 6.7, 244, 53);
            snowboardSizeSpecsRepository.save(stylus138);
            snowboardSizeSpecsRepository.save(stylus142);
            snowboardSizeSpecsRepository.save(stylus147);
            snowboardSizeSpecsRepository.save(stylus152);

            sb30.getBoardSizeSpecs().add(stylus138);
            sb30.getBoardSizeSpecs().add(stylus142);
            sb30.getBoardSizeSpecs().add(stylus147);
            sb30.getBoardSizeSpecs().add(stylus152);

            Terrain stylusT1 = new Terrain(allMountain, 8);
            Terrain stylusT2 = new Terrain(powder, 4);
            Terrain stylusT3 = new Terrain(park, 2);


            terrainRepository.save(stylusT1);
            terrainRepository.save(stylusT2);
            terrainRepository.save(stylusT3);

            sb30.getRidingterrains().add(stylusT1);
            sb30.getRidingterrains().add(stylusT2);
            sb30.getRidingterrains().add(stylusT3);

            sb30.getRiderLevels().add(beginner);
            
            // Family Tree Stick Shift
            Snowboard sb31 = new Snowboard(brand1, "Family Tree Stick Shift", female, -2.5, 4, "Family_Tree_Stick_Shift.webp", threeYears, "Pop the clutch, rally around and enjoy the ride with this surf-inspired short board.", "Quick and nimble, yet loose and playful – it's all about balance with the Family Tree's first super short pow surfer designed specifically for women. Shorter, wider, and boasting a mid-range flex, the Stick Shift is great for speeding around every inch of the mountain, and slashing up a storm in the backcountry. Directional Flat Top delivers a loose, yet stable feel, while an early rise in the nose combines with a unique directional shape to deliver effortless float in fresh snow.");
            sb31.getTechDetails().add(directionalFlatTopBend);
            sb31.getTechDetails().add(allMountainDirectionalShape);
            sb31.getTechDetails().add(directionalFlex);
            sb31.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs familyTreeStickShift142 = new SnowboardSizeSpecs("142", 54, 82, "L", 110, 102, 6.8, 250, 48);
            SnowboardSizeSpecs  familyTreeStickShift148 = new SnowboardSizeSpecs("148", 68, 91, "L", 116, 108, 7.2, 255, 53);
            snowboardSizeSpecsRepository.save(familyTreeStickShift142);
            snowboardSizeSpecsRepository.save(familyTreeStickShift148);

            sb31.getBoardSizeSpecs().add(familyTreeStickShift142);
            sb31.getBoardSizeSpecs().add(familyTreeStickShift148);

            Terrain familyTreeStickShiftT1 = new Terrain(powder, 10);
            Terrain familyTreeStickShiftT2 = new Terrain(allMountain, 6);
            Terrain familyTreeStickShiftT3 = new Terrain(park, 2);


            terrainRepository.save(familyTreeStickShiftT1);
            terrainRepository.save(familyTreeStickShiftT2);
            terrainRepository.save(familyTreeStickShiftT3);

            sb31.getRidingterrains().add(familyTreeStickShiftT1);
            sb31.getRidingterrains().add(familyTreeStickShiftT2);
            sb31.getRidingterrains().add(familyTreeStickShiftT3);

            sb31.getRiderLevels().add(intermediate);
            sb31.getRiderLevels().add(pro);
            
            // Day Trader
            Snowboard sb32 = new Snowboard(brand1, "Day Trader", female, -3.75, 4, "Day_Trader.webp", threeYears, "Throw away the trail map and explore new stashes with the Burton team's favorite for effortless float and confidence-boosting control.", "From exploring the trail map to sneaking away in search of secret stashes, the Burton Day Trader boosts your abilities with a versatile and surfy shape that thrives on all terrain. Developed with freeride maven Kimmy Fasani, this tapered, directional board is designed to perform in fresh snow, yet is just as fun on groomers, too. Directional Flat Top profiling enhances stability and control, while the early rise in the nose adds the effortless float and feeling of rocker. Features like a sustainable FSC™ certified wood core and bio-based Super Sap® resin ensure the board is easy on both you and the environment.");
            sb32.getTechDetails().add(directionalFlatTopBend);
            sb32.getTechDetails().add(freerideDirectionalShape);
            sb32.getTechDetails().add(twinFlex);
            sb32.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs dayTrader140 = new SnowboardSizeSpecs("140", 36, 54, "M", 102.5, 98, 6.4, 238, 48);
            SnowboardSizeSpecs dayTrader145 = new SnowboardSizeSpecs("145", 45, 68, "M/L", 107.5, 103, 6.7, 241, 50.5);
            SnowboardSizeSpecs dayTrader150 = new SnowboardSizeSpecs("150", 54, 82, "M/L", 112.5, 108, 7.0, 243, 53);
            SnowboardSizeSpecs dayTrader154 = new SnowboardSizeSpecs("154", 68, 91, "L", 116.5, 1121, 7.3, 245, 53);
            snowboardSizeSpecsRepository.save(dayTrader140);
            snowboardSizeSpecsRepository.save(dayTrader145);
            snowboardSizeSpecsRepository.save(dayTrader150);
            snowboardSizeSpecsRepository.save(dayTrader154);

            sb32.getBoardSizeSpecs().add(dayTrader140);
            sb32.getBoardSizeSpecs().add(dayTrader145);
            sb32.getBoardSizeSpecs().add(dayTrader150);
            sb32.getBoardSizeSpecs().add(dayTrader154);

            Terrain dayTraderT1 = new Terrain(allMountain, 8);
            Terrain dayTraderT2 = new Terrain(powder, 8);
            Terrain dayTraderT3 = new Terrain(park, 3);

            terrainRepository.save(dayTraderT1);
            terrainRepository.save(dayTraderT2);
            terrainRepository.save(dayTraderT3);

            sb32.getRidingterrains().add(dayTraderT1);
            sb32.getRidingterrains().add(dayTraderT2);
            sb32.getRidingterrains().add(dayTraderT3);

            sb32.getRiderLevels().add(intermediate);
            sb32.getRiderLevels().add(pro);
            
            // Feelgood
            Snowboard sb33 = new Snowboard(brand1, "Feelgood", female, -1.25, 7, "Feelgood.webp", threeYears,"The most confident and proven deck in women's snowboarding is ready to act its age.", "Backed by Kelly Clark, the Burton Feelgood has been the defining force in women's snowboarding for nearly two decades. Call it a coming of age, or maybe it was just time for a facelift – either way, the Feelgood has donned a whole new look, boasting a unique shape, matched with positively powerful pop for Ferrari-like handing. Directional shaping navigates easily through variable conditions, making this the number one board for conquering all terrain. Available with the stable suspension of camber or the rocker-infused freedom of Flying V™, the Feelgood is a perfect match for aspiring pros or just riders who demand every advantage.");
            sb33.getTechDetails().add(camberBend);
            sb33.getTechDetails().add(allMountainDirectionalShape);
            sb33.getTechDetails().add(twinFlex);
            sb33.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs feelgood142 = new SnowboardSizeSpecs("142", 45, 68, "M", 106.5, 102, 6.8, 238, 50.5);
            SnowboardSizeSpecs feelgood146 = new SnowboardSizeSpecs("146", 54, 82, "M/L", 110.5, 106, 7.1, 240, 53);
            SnowboardSizeSpecs feelgood149 = new SnowboardSizeSpecs("149", 54, 82, "M/L", 113.5, 109, 7.3, 242, 53);
            SnowboardSizeSpecs feelgood152 = new SnowboardSizeSpecs("152", 68, 91, "L", 116.5, 112, 7.5, 244, 53);
            snowboardSizeSpecsRepository.save(feelgood142);
            snowboardSizeSpecsRepository.save(feelgood146);
            snowboardSizeSpecsRepository.save(feelgood149);
            snowboardSizeSpecsRepository.save(feelgood152);

            sb33.getBoardSizeSpecs().add(feelgood142);
            sb33.getBoardSizeSpecs().add(feelgood146);
            sb33.getBoardSizeSpecs().add(feelgood149);
            sb33.getBoardSizeSpecs().add(feelgood152);

            Terrain feelgoodT1 = new Terrain(allMountain, 10);
            Terrain feelgoodT2 = new Terrain(park, 6);
            Terrain feelgoodT3 = new Terrain(powder, 6);

            terrainRepository.save(feelgoodT1);
            terrainRepository.save(feelgoodT2);
            terrainRepository.save(feelgoodT3);

            sb33.getRidingterrains().add(feelgoodT1);
            sb33.getRidingterrains().add(feelgoodT2);
            sb33.getRidingterrains().add(feelgoodT3);

            sb33.getRiderLevels().add(intermediate);
            sb33.getRiderLevels().add(pro);
            
            // Rewind
             Snowboard sb34 = new Snowboard(brand1, "Rewind", female, 0, 2, "Rewind.webp", threeYears, "Step up your game with the hardest charging \"soft\" board on the mountain.", "With an extra poppy flex, the souped-up Burton Rewind is for riders who charge hard, and like to flaunt a freestyle attitude backed by steady park progression. The flat, ultra-thin, and skate-like profile improves the ride, thanks to Filet-O-Flex design, yet rips harder than any soft board out there. Ramped-up grip and a fast yet low-maintenance sintered base offer control and durability in variable conditions, while the Off-Axis construction perfectly aligns the board's design to your body's stance and positioning for board feel that fits like a glove.");
            sb34.getTechDetails().add(purePopCamberBend);
            sb34.getTechDetails().add(twinShape);
            sb34.getTechDetails().add(twinFlex);
            sb34.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs rewind141 = new SnowboardSizeSpecs("141", 45, 68, "M", 104.5, 100, 6.7, 237, 50.5);
            SnowboardSizeSpecs rewind146 = new SnowboardSizeSpecs("146", 54, 82, "M/L", 109.5, 105, 7.0, 240, 53);
            SnowboardSizeSpecs rewind149 = new SnowboardSizeSpecs("149", 54, 82, "M/L", 112.5, 108, 7.2, 242, 53);
            SnowboardSizeSpecs rewind152 = new SnowboardSizeSpecs("152", 68, 91, "L", 115.5, 111, 7.4, 245, 53);
            snowboardSizeSpecsRepository.save(rewind141);
            snowboardSizeSpecsRepository.save(rewind146);
            snowboardSizeSpecsRepository.save(rewind149);
            snowboardSizeSpecsRepository.save(rewind152);

            sb34.getBoardSizeSpecs().add(rewind141);
            sb34.getBoardSizeSpecs().add(rewind146);
            sb34.getBoardSizeSpecs().add(rewind149);
            sb34.getBoardSizeSpecs().add(rewind152);

            Terrain rewindT1 = new Terrain(allMountain, 7);
            Terrain rewindT2 = new Terrain(park, 7);
            Terrain rewindT3 = new Terrain(powder, 4);

            terrainRepository.save(rewindT1);
            terrainRepository.save(rewindT2);
            terrainRepository.save(rewindT3);

            sb34.getRidingterrains().add(rewindT1);
            sb34.getRidingterrains().add(rewindT2);
            sb34.getRidingterrains().add(rewindT3);

            sb34.getRiderLevels().add(intermediate);
            sb34.getRiderLevels().add(pro);
            
            // Hideaway
            Snowboard sb35 = new Snowboard(brand1, "Hideaway", female, -2.5, 2, "Hideaway.webp", threeYears, "Put a creative spin on all terrain with a playful and stable board that charges ahead and inspires confidence.", "A little fun with a lot of function, the Burton Hideaway is the perfect tool for taking a no-limits twin-tipped approach to the whole mountain. Plenty playful, a Flat Top™ Bend offers the forgiving freedom and stability to take on any terrain or condition. Its innovative true twin shape makes it really fun to ride in both directions, while a sintered base keeps it fast, even if you have no time to wax it.");
            sb35.getTechDetails().add(flatTopBend);
            sb35.getTechDetails().add(allMountainDirectionalShape);
            sb35.getTechDetails().add(twinFlex);
            sb35.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs hideaway140 = new SnowboardSizeSpecs("140", 36, 54, "S/M", 107.2, 103, 6.7, 235, 48);
            SnowboardSizeSpecs hideaway144 = new SnowboardSizeSpecs("144", 45, 68, "M", 111.5, 107, 7.0, 237, 50.5);
            SnowboardSizeSpecs hideaway149 = new SnowboardSizeSpecs("149", 54, 82, "M/L", 114.5, 110, 7.2, 240, 53);
            SnowboardSizeSpecs hideaway152 = new SnowboardSizeSpecs("152", 68, 91, "M/L", 118.5, 114, 7.4, 242, 53);
            SnowboardSizeSpecs hideaway155 = new SnowboardSizeSpecs("155", 68, 91, "L", 121.5, 117, 7.6, 245, 56);
            snowboardSizeSpecsRepository.save(hideaway140);
            snowboardSizeSpecsRepository.save(hideaway144);
            snowboardSizeSpecsRepository.save(hideaway149);
            snowboardSizeSpecsRepository.save(hideaway152);
            snowboardSizeSpecsRepository.save(hideaway155);

            sb35.getBoardSizeSpecs().add(hideaway140);
            sb35.getBoardSizeSpecs().add(hideaway144);
            sb35.getBoardSizeSpecs().add(hideaway149);
            sb35.getBoardSizeSpecs().add(hideaway152);
            sb35.getBoardSizeSpecs().add(hideaway155);

            Terrain hideawayT1 = new Terrain(allMountain, 9);
            Terrain hideawayT2 = new Terrain(powder, 4);
            Terrain hideawayT3 = new Terrain(park, 3);

            terrainRepository.save(hideawayT1);
            terrainRepository.save(hideawayT2);
            terrainRepository.save(hideawayT3);

            sb35.getRidingterrains().add(hideawayT1);
            sb35.getRidingterrains().add(hideawayT2);
            sb35.getRidingterrains().add(hideawayT3);

            sb35.getRiderLevels().add(beginner);
            
            // Feelgood FV
            Snowboard sb36 = new Snowboard(brand1, "Feelgood Flying V", female, -1.25, 4, "Feelgood_Flying_V.webp", threeYears, "The most confident and proven deck in women's snowboarding is ready to act its age.", "Backed by Kelly Clark, the Burton Feelgood has been the defining force in women's snowboarding for nearly two decades. Call it a coming of age, or maybe it was just time for a facelift – either way, the Feelgood has donned a whole new look, boasting a unique shape, matched with positively powerful pop for Ferrari-like handing. Directional shaping navigates easily through variable conditions, making this the number one board for conquering all terrain. Available with the stable suspension of camber or the rocker-infused freedom of Flying V™, the Feelgood is a perfect match for aspiring pros or just riders who demand every advantage.");
            sb36.getTechDetails().add(flyingVBend);
            sb36.getTechDetails().add(allMountainDirectionalShape);
            sb36.getTechDetails().add(twinFlex);
            sb36.getTechDetails().add(superFly2700G);
            SnowboardSizeSpecs feelgoodFV142 = new SnowboardSizeSpecs("142", 45, 68, "M", 106.5, 102, 6.8, 238, 50.5);
            SnowboardSizeSpecs feelgoodFV146 = new SnowboardSizeSpecs("146", 54, 82, "M/L", 110.5, 106, 7.1, 240, 53);
            SnowboardSizeSpecs feelgoodFV149 = new SnowboardSizeSpecs("149", 54, 82, "M/L", 113.5, 109, 7.3, 242, 53);
            SnowboardSizeSpecs feelgoodFV152 = new SnowboardSizeSpecs("152", 68, 91, "L", 116.5, 112, 7.5, 244, 53);
            snowboardSizeSpecsRepository.save(feelgoodFV142);
            snowboardSizeSpecsRepository.save(feelgoodFV146);
            snowboardSizeSpecsRepository.save(feelgoodFV149);
            snowboardSizeSpecsRepository.save(feelgoodFV152);

            sb36.getBoardSizeSpecs().add(feelgoodFV142);
            sb36.getBoardSizeSpecs().add(feelgoodFV146);
            sb36.getBoardSizeSpecs().add(feelgoodFV149);
            sb36.getBoardSizeSpecs().add(feelgoodFV152);

            Terrain feelgoodFVT1 = new Terrain(allMountain, 10);
            Terrain feelgoodFVT2 = new Terrain(powder, 6);
            Terrain feelgoodFVT3 = new Terrain(park, 5);

            terrainRepository.save(feelgoodFVT1);
            terrainRepository.save(feelgoodFVT2);
            terrainRepository.save(feelgoodFVT3);

            sb36.getRidingterrains().add(feelgoodFVT1);
            sb36.getRidingterrains().add(feelgoodFVT2);
            sb36.getRidingterrains().add(feelgoodFVT3);

            sb36.getRiderLevels().add(intermediate);
            sb36.getRiderLevels().add(pro);
            
             // Yeasayer
            Snowboard sb37 = new Snowboard(brand1, "Yeasayer", female, 0, 3, "Yeasayer.webp", threeYears, "Make every turn a metaphorical thumbs up with the versatility and catch-free control of a board that's built to expand your horizons.", "From unexplored peaks to your favorite parks, the Burton Yeasayer tames anything that stands in your way. The board's Flat Top profile surfs through deep powder while keeping things stable underfoot, and a true twin design keeps you in control no matter which way you point it. Available in two versions, choose the relaxed and floaty Flying V™ or catch-free control of Flat Top. A laundry list of features all work together to ensure that the ride is as friendly as it is fun, with an energetic FSC™ Certified core, and Scoop tip and tail, which turn up the edges for a catch-free feel whether you're surfing through knee deep pow or sliding a box in the park.");
            sb37.getTechDetails().add(flatTopBend);
            sb37.getTechDetails().add(twinShape);
            sb37.getTechDetails().add(twinFlex);
            sb37.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs yeasayer140 = new SnowboardSizeSpecs("140", 36, 54, "M/L", 106, 102, 6.6, 240, 48);
            SnowboardSizeSpecs yeasayer144 = new SnowboardSizeSpecs("144", 45, 68, "M/L", 109, 105, 6.8, 242, 50.5);
            SnowboardSizeSpecs yeasayer148 = new SnowboardSizeSpecs("149", 54, 82, "L", 113, 109, 7.1, 244, 53);
            SnowboardSizeSpecs yeasayer152 = new SnowboardSizeSpecs("152", 68, 91, "L", 117, 113, 7.4, 247, 53);
            snowboardSizeSpecsRepository.save(yeasayer140);
            snowboardSizeSpecsRepository.save(yeasayer144);
            snowboardSizeSpecsRepository.save(yeasayer148);
            snowboardSizeSpecsRepository.save(yeasayer152);

            sb37.getBoardSizeSpecs().add(yeasayer140);
            sb37.getBoardSizeSpecs().add(yeasayer144);
            sb37.getBoardSizeSpecs().add(yeasayer148);
            sb37.getBoardSizeSpecs().add(yeasayer152);

            Terrain yeasayerT1 = new Terrain(allMountain, 10);
            Terrain yeasayerT2 = new Terrain(powder, 6);
            Terrain yeasayerT3 = new Terrain(park, 4);

            terrainRepository.save(yeasayerT1);
            terrainRepository.save(yeasayerT2);
            terrainRepository.save(yeasayerT3);

            sb37.getRidingterrains().add(yeasayerT1);
            sb37.getRidingterrains().add(yeasayerT2);
            sb37.getRidingterrains().add(yeasayerT3);

            sb37.getRiderLevels().add(intermediate);

             // Yeasayer FV
            Snowboard sb38 = new Snowboard(brand1, "Yeasayer Flying V", female, 0, 3, "Yeasayer_Flying_V.webp", threeYears, "Make every turn a metaphorical thumbs up with the versatility and catch-free control of a board that's built to expand your horizons.", "From unexplored peaks to your favorite parks, the Burton Yeasayer tames anything that stands in your way. The board's Flat Top profile surfs through deep powder while keeping things stable underfoot, and a true twin design keeps you in control no matter which way you point it. Available in two versions, choose the relaxed and floaty Flying V™ or catch-free control of Flat Top. A laundry list of features all work together to ensure that the ride is as friendly as it is fun, with an energetic FSC™ Certified core, and Scoop tip and tail, which turn up the edges for a catch-free feel whether you're surfing through knee deep pow or sliding a box in the park.");
            sb38.getTechDetails().add(flyingVBend);
            sb38.getTechDetails().add(twinShape);
            sb38.getTechDetails().add(twinFlex);
            sb38.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs yeasayerFV140 = new SnowboardSizeSpecs("140", 36, 54, "M/L", 106, 102, 6.6, 240, 48);
            SnowboardSizeSpecs yeasayerFV144 = new SnowboardSizeSpecs("144", 45, 68, "M/L", 109, 105, 6.8, 242, 50.5);
            SnowboardSizeSpecs yeasayerFV148 = new SnowboardSizeSpecs("149", 54, 82, "L", 113, 109, 7.1, 244, 53);
            SnowboardSizeSpecs yeasayerFV152 = new SnowboardSizeSpecs("152", 68, 91, "L", 117, 113, 7.4, 247, 53);
            snowboardSizeSpecsRepository.save(yeasayerFV140);
            snowboardSizeSpecsRepository.save(yeasayerFV144);
            snowboardSizeSpecsRepository.save(yeasayerFV148);
            snowboardSizeSpecsRepository.save(yeasayerFV152);

            sb38.getBoardSizeSpecs().add(yeasayerFV140);
            sb38.getBoardSizeSpecs().add(yeasayerFV144);
            sb38.getBoardSizeSpecs().add(yeasayerFV148);
            sb38.getBoardSizeSpecs().add(yeasayerFV152);

            Terrain yeasayerFVT1 = new Terrain(allMountain, 10);
            Terrain yeasayerFVT2 = new Terrain(powder, 6);
            Terrain yeasayerFVT3 = new Terrain(park, 2);

            terrainRepository.save(yeasayerFVT1);
            terrainRepository.save(yeasayerFVT2);
            terrainRepository.save(yeasayerFVT3);

            sb38.getRidingterrains().add(yeasayerFVT1);
            sb38.getRidingterrains().add(yeasayerFVT2);
            sb38.getRidingterrains().add(yeasayerFVT3); 

            sb38.getRiderLevels().add(intermediate);
            
            //After School Special
            Snowboard sb39 = new Snowboard(brand1, "After School Special Package", kids, 0, 2, "After_School_Special.webp", twoYears,"One-stop shopping. Just plug your kid in and go with a setup that's easier than a tricycle with training wheels.", "Even the kids know this is the best deal going. Better than watching hours of cartoons, the Burton After School Special makes learning a cinch with super soft, parent-friendly bindings and a saucer-like snowboard that teaches balance and board control. With the fully adjustable bindings pre-mounted in a beginner-friendly stance, simply grab the package and go. It doesn't get any easier than this.");
            sb39.getTechDetails().add(flatTopEasyBevelBend);
            sb39.getTechDetails().add(twinShape);
            sb39.getTechDetails().add(twinFlex);
            sb39.getTechDetails().add(fly900G);
            SnowboardSizeSpecs afterSchool80 = new SnowboardSizeSpecs("80", 11, 23, "GROM XS", 48, 44, 2.9, 178, 30.5);
            SnowboardSizeSpecs afterSchool90 = new SnowboardSizeSpecs("90", 11, 23, "GROM XS", 58, 54, 3.6, 179, 33);
            SnowboardSizeSpecs afterSchool100 = new SnowboardSizeSpecs("100", 18, 25, "GROM XS", 68.5, 64.5, 4.2, 188, 35.5);
            
            snowboardSizeSpecsRepository.save(afterSchool80);
            snowboardSizeSpecsRepository.save(afterSchool90);
            snowboardSizeSpecsRepository.save(afterSchool100);

            sb39.getBoardSizeSpecs().add(afterSchool80);
            sb39.getBoardSizeSpecs().add(afterSchool90);
            sb39.getBoardSizeSpecs().add(afterSchool100);

            Terrain afterSchoolT1 = new Terrain(allMountain, 3);
            Terrain afterSchoolT2 = new Terrain(park, 1);
            Terrain afterSchoolT3 = new Terrain(powder, 1);

            terrainRepository.save(afterSchoolT1);
            terrainRepository.save(afterSchoolT2);
            terrainRepository.save(afterSchoolT3);

            sb39.getRidingterrains().add(afterSchoolT1);
            sb39.getRidingterrains().add(afterSchoolT2);
            sb39.getRidingterrains().add(afterSchoolT3); 

            sb39.getRiderLevels().add(beginner);
            
            // Chopper
            Snowboard sb40 = new Snowboard(brand1, "Chopper", kids, 0, 2, "Chopper.webp", twoYears,"The ultimate tot-friendly deck makes learning to link turns easier than finishing your lima beans.", "The Burton Chopper® is the ticket for boys who want to start snowboarding and quickly learn the basics. What makes it so perfect is the beginner-friendly combo of a convex base with upturned edges and the softest flex possible so that even the lightest weight riders can master turning and stopping. The catch-free feeling continues with a flat profile from nose to tail that’s extra stable for better balance and board control. Attach the Riglet accessory to the nose or tail of the 80-120cm sizes to tow him around and get him comfortable until he's ready to add bindings.");
            sb40.getTechDetails().add(flatTopEasyBevelBend);
            sb40.getTechDetails().add(twinShape);
            sb40.getTechDetails().add(twinFlex);
            sb40.getTechDetails().add(fly900G);
            SnowboardSizeSpecs chopper80 = new SnowboardSizeSpecs("80", 11, 23, "GROM XS", 48, 44, 2.9, 178, 30.5);
            SnowboardSizeSpecs chopper90 = new SnowboardSizeSpecs("90", 11, 23, "GROM XS", 58, 54, 3.6, 179, 33);
            SnowboardSizeSpecs chopper100 = new SnowboardSizeSpecs("100", 18, 25, "GROM XS", 68.5, 64.5, 4.2, 188, 35.5);
            SnowboardSizeSpecs chopper110 = new SnowboardSizeSpecs("110", 18, 25, "GROM S", 78.5, 74.5, 4.9, 203, 38);
            SnowboardSizeSpecs chopper115 = new SnowboardSizeSpecs("115", 23, 36, "GROM S", 83.5, 79.5, 5.2, 213, 38);
            SnowboardSizeSpecs chopper120 = new SnowboardSizeSpecs("120", 23, 36, "GROM S, SMLLS 1SZ", 88.5, 84.5, 5.6, 222, 40.5);
            SnowboardSizeSpecs chopper125 = new SnowboardSizeSpecs("125", 32, 45, "GROM S, SMLLS 1SZ", 93.5, 89.5, 6.0, 230,43);
            SnowboardSizeSpecs chopper130 = new SnowboardSizeSpecs("130", 32, 45, "GROM S, SMLLS 1SZ", 96, 92, 6.2, 232, 45);
            
            snowboardSizeSpecsRepository.save(chopper80);
            snowboardSizeSpecsRepository.save(chopper90);
            snowboardSizeSpecsRepository.save(chopper100);
            snowboardSizeSpecsRepository.save(chopper110);
            snowboardSizeSpecsRepository.save(chopper115);
            snowboardSizeSpecsRepository.save(chopper120);
            snowboardSizeSpecsRepository.save(chopper125);
            snowboardSizeSpecsRepository.save(chopper130);

            sb40.getBoardSizeSpecs().add(chopper80);
            sb40.getBoardSizeSpecs().add(chopper90);
            sb40.getBoardSizeSpecs().add(chopper100);
            sb40.getBoardSizeSpecs().add(chopper110);
            sb40.getBoardSizeSpecs().add(chopper115);
            sb40.getBoardSizeSpecs().add(chopper120);
            sb40.getBoardSizeSpecs().add(chopper125);
            sb40.getBoardSizeSpecs().add(chopper130);

            Terrain chopperT1 = new Terrain(allMountain, 5);
            Terrain chopperT2 = new Terrain(park, 3);
            Terrain chopperT3 = new Terrain(powder, 1);

            terrainRepository.save(chopperT1);
            terrainRepository.save(chopperT2);
            terrainRepository.save(chopperT3);

            sb40.getRidingterrains().add(chopperT1);
            sb40.getRidingterrains().add(chopperT2);
            sb40.getRidingterrains().add(chopperT3); 

            sb40.getRiderLevels().add(beginner);
            
            // Kilroy Twin
            Snowboard sb41 = new Snowboard(brand1, "Kilroy Twin", kids, 0, 3, "Kilroy_Twin.webp", threeYears, "The workingman's classic: a traditional camber twin, designed to thrive on all terrain.", "The rippers on ground level are looking for a board that can hang without worrying about the cost. The Burton Kilroy Twin is here to give the people what they want with a classic twin shape inspired by the Process, but with a refined construction that focuses on strength, speed, and pop.");
            sb41.getTechDetails().add(camberBend);
            sb41.getTechDetails().add(twinShape);
            sb41.getTechDetails().add(twinFlex);
            sb41.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs kilroyTwin135 = new SnowboardSizeSpecs("135", 36, 54, "Kids/S", 98.5, 94, 6.4, 235, 45.5);
            SnowboardSizeSpecs kilroyTwin140 = new SnowboardSizeSpecs("140", 45, 68, "S/M", 108.5, 104, 7.1, 245, 50.5);
   
            snowboardSizeSpecsRepository.save(kilroyTwin135);
            snowboardSizeSpecsRepository.save(kilroyTwin140);

            sb41.getBoardSizeSpecs().add(kilroyTwin135);
            sb41.getBoardSizeSpecs().add(kilroyTwin140);

            Terrain kilroyTwinT1 = new Terrain(park, 10);
            Terrain kilroyTwinT2 = new Terrain(allMountain, 7);
            Terrain kilroyTwinT3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyTwinT1);
            terrainRepository.save(kilroyTwinT2);
            terrainRepository.save(kilroyTwinT3);

            sb41.getRidingterrains().add(kilroyTwinT1);
            sb41.getRidingterrains().add(kilroyTwinT2);
            sb41.getRidingterrains().add(kilroyTwinT3); 

            sb41.getRiderLevels().add(beginner);
            
            // Family Tree Role Model
            Snowboard sb42 = new Snowboard(brand1, "Family Tree Role Model", kids, -5, 6, "Family_Tree_Role_Model.webp", threeYears, "The ultimate all-terrain board for kids, with a slightly tapered shape that's equally at home flying through powder or the air.", "Because kids are the future. The newest Family Tree addition is here to guide the youngest riders towards the freedom of freeriding, providing directional all-terrain prowess with a heavy list of pro-caliber features to boot. Directional Camber provides snappy power and response, and matches with 15mm of taper for a board that loves to turn both in deep snow and across the whole mountain.");
            sb42.getTechDetails().add(directionalCamberBend);
            sb42.getTechDetails().add(allMountainDirectionalShape);
            sb42.getTechDetails().add(twinFlex);
            sb42.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs familyTreeRoleModel130 = new SnowboardSizeSpecs("135", 36, 54, "SMLLS 1SZ/ MEN'S S", 96, 91, 6.0, 238, 45.5);
            SnowboardSizeSpecs familyTreeRoleModel140 = new SnowboardSizeSpecs("140", 45, 68, "SMLLS 1SZ, MEN'S S/M RE:FLEX", 106, 101, 6.7, 243, 48);
   
            snowboardSizeSpecsRepository.save(familyTreeRoleModel130);
            snowboardSizeSpecsRepository.save(familyTreeRoleModel140);

            sb42.getBoardSizeSpecs().add(familyTreeRoleModel130);
            sb42.getBoardSizeSpecs().add(familyTreeRoleModel140);

            Terrain familyTreeRoleModelT1 = new Terrain(allMountain, 8);
            Terrain familyTreeRoleModelT2 = new Terrain(powder, 8);
            Terrain familyTreeRoleModelT3 = new Terrain(park, 5);

            terrainRepository.save(familyTreeRoleModelT1);
            terrainRepository.save(familyTreeRoleModelT2);
            terrainRepository.save(familyTreeRoleModelT3);

            sb42.getRidingterrains().add(familyTreeRoleModelT1);
            sb42.getRidingterrains().add(familyTreeRoleModelT2);
            sb42.getRidingterrains().add(familyTreeRoleModelT3); 

            sb42.getRiderLevels().add(pro);
            
            // Yeasayer Smalls
            Snowboard sb43 = new Snowboard(brand1, "Yeasayer Smalls", kids, 0, 4, "Yeasayer_Smalls.webp", threeYears, "The playful pint-sized sister to the board that opens new doors to all-mountain progression.", "The Burton Yeasayer Smalls is the logical next step for girls who have mastered the basics and are ready to explore the entire mountain. Soft and playful, it features the forgiving performance of our Flat Top™ bend to create the stability and snap you'd expect from camber, but with a floaty, catch-free tip and tail. Filet-O-Flex core profiling makes for a super soft flex that doesn't sacrifice stability – just the thing to make you feel like you've done it all before, only not this awesome.");
            sb43.getTechDetails().add(flatTopBend);
            sb43.getTechDetails().add(twinShape);
            sb43.getTechDetails().add(twinFlex);
            sb43.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs yeasayerSmalls125 = new SnowboardSizeSpecs("125", 32, 45, "SMLLS 1SZ", 91, 87, 5.8, 230, 43);
            SnowboardSizeSpecs yeasayerSmalls130 = new SnowboardSizeSpecs("130", 32, 45, "GROM S, SMLLS 1SZ", 95, 91, 6.1, 231, 45.5);
            SnowboardSizeSpecs yeasayerSmalls134 = new SnowboardSizeSpecs("134", 36, 50, "SMLLS 1SZ", 99, 95, 6.4, 233, 45.5);
            SnowboardSizeSpecs yeasayerSmalls138 = new SnowboardSizeSpecs("138", 41, 54, "SMLLS 1SZ", 102, 99, 6.6, 235, 45.5);
            snowboardSizeSpecsRepository.save(yeasayerSmalls125);
            snowboardSizeSpecsRepository.save(yeasayerSmalls130);
            snowboardSizeSpecsRepository.save(yeasayerSmalls134);
            snowboardSizeSpecsRepository.save(yeasayerSmalls138);

            sb43.getBoardSizeSpecs().add(yeasayerSmalls125);
            sb43.getBoardSizeSpecs().add(yeasayerSmalls130);
            sb43.getBoardSizeSpecs().add(yeasayerSmalls134);
            sb43.getBoardSizeSpecs().add(yeasayerSmalls138);

            Terrain yeasayerSmallsT1 = new Terrain(allMountain, 7);
            Terrain yeasayerSmallsT2 = new Terrain(park, 4);
            Terrain yeasayerSmallsT3 = new Terrain(powder, 3);

            terrainRepository.save(yeasayerSmallsT1);
            terrainRepository.save(yeasayerSmallsT2);
            terrainRepository.save(yeasayerSmallsT3);

            sb43.getRidingterrains().add(yeasayerSmallsT1);
            sb43.getRidingterrains().add(yeasayerSmallsT2);
            sb43.getRidingterrains().add(yeasayerSmallsT3);

            sb43.getRiderLevels().add(intermediate); 
            
             // Chicklet
            Snowboard sb44 = new Snowboard(brand1, "Chicklet", kids, 0, 2, "Chicklet.webp", threeYears, "When you want to see her succeed, put her on the softest, most stable girl's beginner board in snowboarding.", "The Burton Chicklet™ is the ticket for girls who want to start snowboarding and quickly learn the basics. What makes it so perfect is the beginner-friendly combo of a convex base with upturned edges and the softest flex possible so that even the lightest weight riders can master turning and stopping. The catch-free feeling continues with a flat profile from nose to tail that’s extra stable for better balance and board control. Attach the Riglet accessory to the nose or tail of the 80-120cm sizes to tow her around and get her comfortable until she's ready to add bindings.");
            sb44.getTechDetails().add(flatTopEasyBevelBend);
            sb44.getTechDetails().add(twinShape);
            sb44.getTechDetails().add(twinFlex);
            sb44.getTechDetails().add(fly900G);
            SnowboardSizeSpecs chicklet80 = new SnowboardSizeSpecs("80", 11, 23, "GROM XS", 48, 44, 2.9, 178, 30.5);
            SnowboardSizeSpecs chicklet90 = new SnowboardSizeSpecs("90", 11, 23, "GROM XS", 58, 54, 3.6, 179, 33);
            SnowboardSizeSpecs chicklet100 = new SnowboardSizeSpecs("100", 18, 25, "GROM XS", 68.5, 64.5, 4.2, 188, 35.5);
            SnowboardSizeSpecs chicklet110 = new SnowboardSizeSpecs("110", 18, 25, "GROM S", 78.5, 74.5, 4.9, 203, 38);
            SnowboardSizeSpecs chicklet115 = new SnowboardSizeSpecs("115", 23, 36, "GROM S", 83.5, 79.5, 5.2, 213, 38);
            SnowboardSizeSpecs chicklet120 = new SnowboardSizeSpecs("120", 23, 36, "GROM S, SMLLS 1SZ", 88.5, 84.5, 5.6, 222, 40.5);
            SnowboardSizeSpecs chicklet125 = new SnowboardSizeSpecs("125", 32, 45, "GROM S, SMLLS 1SZ", 93.5, 89.5, 6.0, 230,43);
            SnowboardSizeSpecs chicklet130 = new SnowboardSizeSpecs("130", 32, 45, "GROM S, SMLLS 1SZ", 96, 92, 6.2, 232, 45);
            
            snowboardSizeSpecsRepository.save(chicklet80);
            snowboardSizeSpecsRepository.save(chicklet90);
            snowboardSizeSpecsRepository.save(chicklet100);
            snowboardSizeSpecsRepository.save(chicklet110);
            snowboardSizeSpecsRepository.save(chicklet115);
            snowboardSizeSpecsRepository.save(chicklet120);
            snowboardSizeSpecsRepository.save(chicklet125);
            snowboardSizeSpecsRepository.save(chicklet130);

            sb44.getBoardSizeSpecs().add(chicklet80);
            sb44.getBoardSizeSpecs().add(chicklet90);
            sb44.getBoardSizeSpecs().add(chicklet100);
            sb44.getBoardSizeSpecs().add(chicklet110);
            sb44.getBoardSizeSpecs().add(chicklet115);
            sb44.getBoardSizeSpecs().add(chicklet120);
            sb44.getBoardSizeSpecs().add(chicklet125);
            sb44.getBoardSizeSpecs().add(chicklet130);

            Terrain chickletT1 = new Terrain(allMountain, 5);
            Terrain chickletT2 = new Terrain(park, 3);
            Terrain chickletT3 = new Terrain(powder, 1);

            terrainRepository.save(chickletT1);
            terrainRepository.save(chickletT2);
            terrainRepository.save(chickletT3);

            sb44.getRidingterrains().add(chickletT1);
            sb44.getRidingterrains().add(chickletT2);
            sb44.getRidingterrains().add(chickletT3); 

            sb44.getRiderLevels().add(beginner);
            
            // Process Smalls
            Snowboard sb45 = new Snowboard(brand1, "Process Smalls", kids, 0, 4, "Process_Smalls.webp", threeYears, "Soft flexing and ultra-stable – a pro-caliber ride for young rippers looking to take the next step in freestyle progression.", "Whether they're tooling around the mini park or taking skills to bigger features, groms on the move will love the Burton Process Smalls. Flat Top™ blends the effortless feel of rocker with the quick-thinking control required for launching airs and landing with confidence. Filet-O-Flex creates a super soft board that still rips with maximum stability, durability, and grip. For the rider who has outgrown the Chopper® but isn't quite ready to go big, the Process Smalls hits the sweet spot on freestyle fun. Features The Channel® mounting system to give you the easiest, most adjustable setup with bindings from all major brands (not just Burton's).");
            sb45.getTechDetails().add(flatTopBend);
            sb45.getTechDetails().add(twinShape);
            sb45.getTechDetails().add(twinFlex);
            sb45.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs processSmalls125 = new SnowboardSizeSpecs("125", 32, 45, "SMLLS 1SZ", 91, 87, 5.8, 230, 43);
            SnowboardSizeSpecs processSmalls130 = new SnowboardSizeSpecs("130", 32, 45, "SMLLS 1SZ", 95, 91, 6.1, 231, 45.5);
            SnowboardSizeSpecs processSmalls134 = new SnowboardSizeSpecs("134", 36, 50, "SMLLS 1SZ", 99, 95, 6.4, 233, 45.5);
            SnowboardSizeSpecs processSmalls138 = new SnowboardSizeSpecs("138", 41, 54, "SMLLS 1SZ", 102, 99, 6.6, 235, 45.5);
            SnowboardSizeSpecs processSmalls142 = new SnowboardSizeSpecs("142", 45, 68, "SMLLS 1SZ, MEN'S S/M RE:FLEX", 107, 103, 7.0, 243, 48);
            snowboardSizeSpecsRepository.save(processSmalls125);
            snowboardSizeSpecsRepository.save(processSmalls130);
            snowboardSizeSpecsRepository.save(processSmalls134);
            snowboardSizeSpecsRepository.save(processSmalls138);
            snowboardSizeSpecsRepository.save(processSmalls142);

            sb45.getBoardSizeSpecs().add(processSmalls125);
            sb45.getBoardSizeSpecs().add(processSmalls130);
            sb45.getBoardSizeSpecs().add(processSmalls134);
            sb45.getBoardSizeSpecs().add(processSmalls138);
            sb45.getBoardSizeSpecs().add(processSmalls142);

            Terrain processSmallsT1 = new Terrain(allMountain, 7);
            Terrain processSmallsT2 = new Terrain(park, 4);
            Terrain processSmallsT3 = new Terrain(powder, 3);

            terrainRepository.save(processSmallsT1);
            terrainRepository.save(processSmallsT2);
            terrainRepository.save(processSmallsT3);

            sb45.getRidingterrains().add(processSmallsT1);
            sb45.getRidingterrains().add(processSmallsT2);
            sb45.getRidingterrains().add(processSmallsT3);

            sb45.getRiderLevels().add(intermediate); 
            
            // Custom Smalls
            Snowboard sb46 = new Snowboard(brand1, "Custom Smalls", kids, 0, 5, "Custom_Smalls.webp", threeYears, "Rule it all from park laps to pow days in a kid's version of Burton's most versatile board.", "The Burton Custom Smalls has been a highly maneuverable, skill-accelerating ride since its inception, but recent updates make it an even harder charging option for snowboarding's youngest rippers. Now boasting PurePop Camber, it serves up a balanced blend of flex and pop, perfect for taking a freestyle attitude to the whole mountain. The Channel® mounting system means the easiest, most adjustable setup possible with compatibility that works with any binding from most major brands. The Custom Smalls is a step up in performance over the Burton Process Smalls and is designed for kids who shred it all from park to pow and everything in between.");   
            sb46.getTechDetails().add(purePopCamberBend);
            sb46.getTechDetails().add(twinShape);
            sb46.getTechDetails().add(twinFlex);
            sb46.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs customSmalls125 = new SnowboardSizeSpecs("125", 32, 45, "SMLLS 1SZ", 91, 87, 5.8, 235, 43);
            SnowboardSizeSpecs customSmalls130 = new SnowboardSizeSpecs("130", 32, 45, "SMLLS 1SZ", 94, 90, 6.1, 238, 45.5);
            SnowboardSizeSpecs customSmalls135 = new SnowboardSizeSpecs("135", 36, 50, "SMLLS 1SZ, MEN'S S RE:FLEX", 99, 95, 6.4, 240, 45.5);
            SnowboardSizeSpecs customSmalls140 = new SnowboardSizeSpecs("140", 41, 54, "SMLLS 1SZ, MEN'S S RE:FLEX", 104, 100, 6.6, 242, 45.5);
            SnowboardSizeSpecs customSmalls145 = new SnowboardSizeSpecs("145", 45, 68, "SMLLS 1SZ, MEN'S S/M RE:FLEX", 109, 105, 7.0, 245, 48);
            snowboardSizeSpecsRepository.save(customSmalls125);
            snowboardSizeSpecsRepository.save(customSmalls130);
            snowboardSizeSpecsRepository.save(customSmalls135);
            snowboardSizeSpecsRepository.save(customSmalls140);
            snowboardSizeSpecsRepository.save(customSmalls145);

            sb46.getBoardSizeSpecs().add(customSmalls125);
            sb46.getBoardSizeSpecs().add(customSmalls130);
            sb46.getBoardSizeSpecs().add(customSmalls135);
            sb46.getBoardSizeSpecs().add(customSmalls140);
            sb46.getBoardSizeSpecs().add(customSmalls145);

            Terrain customSmallsT1 = new Terrain(allMountain, 8);
            Terrain customSmallsT2 = new Terrain(powder, 5);
            Terrain customSmallsT3 = new Terrain(park, 5);

            terrainRepository.save(customSmallsT1);
            terrainRepository.save(customSmallsT2);
            terrainRepository.save(customSmallsT3);

            sb46.getRidingterrains().add(customSmallsT1);
            sb46.getRidingterrains().add(customSmallsT2);
            sb46.getRidingterrains().add(customSmallsT3);

            sb46.getRiderLevels().add(intermediate); 
            sb46.getRiderLevels().add(pro);
            
            // Feelgood Smalls
            Snowboard sb47 = new Snowboard(brand1, "Feelgood Smalls", kids, 0, 5, "Feelgood_Smalls.webp", threeYears, "Experience it all in a girl's version of Burton's most versatile and time-honored board.", "We give the girls their due with a kid-friendly version of the Burton Feelgood™ that heroes like Kelly Clark ride. Now boasting PurePop Camber, it serves up a balanced blend of flex and pop, perfect for taking a freestyle attitude to the whole mountain. Perfect for the little lady who's ready to charge, this hybrid design gives her the fun twin shape, speed, and weight-savings to support her steady appetite for improvement. The Channel® mounting system means the easiest, most adjustable setup possible with compatibility that works with any binding from most major brands.");
            sb47.getTechDetails().add(purePopCamberBend);
            sb47.getTechDetails().add(twinShape);
            sb47.getTechDetails().add(twinFlex);
            sb47.getTechDetails().add(superFly800G);
            SnowboardSizeSpecs feelgoodSmalls130 = new SnowboardSizeSpecs("130", 32, 45, "SMLLS 1SZ", 94, 90, 6.1, 238, 45.5);
            SnowboardSizeSpecs feelgoodSmalls135 = new SnowboardSizeSpecs("135", 36, 50, "SMLLS 1SZ, WMNS S RE:FLEX", 99, 95, 6.4, 240, 45.5);
            SnowboardSizeSpecs feelgoodSmalls140 = new SnowboardSizeSpecs("140", 41, 54, "SMLLS 1SZ, WMNS S/M RE:FLEX", 104, 100, 6.6, 242, 45.5);
            snowboardSizeSpecsRepository.save(feelgoodSmalls130);
            snowboardSizeSpecsRepository.save(feelgoodSmalls135);
            snowboardSizeSpecsRepository.save(feelgoodSmalls140);
            
            sb47.getBoardSizeSpecs().add(feelgoodSmalls130);
            sb47.getBoardSizeSpecs().add(feelgoodSmalls135);
            sb47.getBoardSizeSpecs().add(feelgoodSmalls140);

            Terrain feelgoodSmallsT1 = new Terrain(allMountain, 8);
            Terrain feelgoodSmallsT2 = new Terrain(powder, 5);
            Terrain feelgoodSmallsT3 = new Terrain(park, 5);

            terrainRepository.save(feelgoodSmallsT1);
            terrainRepository.save(feelgoodSmallsT2);
            terrainRepository.save(feelgoodSmallsT3);

            sb47.getRidingterrains().add(feelgoodSmallsT1);
            sb47.getRidingterrains().add(feelgoodSmallsT2);
            sb47.getRidingterrains().add(feelgoodSmallsT3);

            sb47.getRiderLevels().add(intermediate); 
            sb47.getRiderLevels().add(pro);
            
            //Save all boards to DB
            snowboardRepository.save(sb1);
            snowboardRepository.save(sb2);
            snowboardRepository.save(sb3);
            snowboardRepository.save(sb4);
            snowboardRepository.save(sb5);
            snowboardRepository.save(sb6);
            snowboardRepository.save(sb7);
            snowboardRepository.save(sb8);
            snowboardRepository.save(sb9);
            snowboardRepository.save(sb10);
            snowboardRepository.save(sb11);
            snowboardRepository.save(sb12);
            snowboardRepository.save(sb13);
            snowboardRepository.save(sb14);
            snowboardRepository.save(sb15);
            snowboardRepository.save(sb16);
            snowboardRepository.save(sb17);
            snowboardRepository.save(sb18);
            snowboardRepository.save(sb19);
            snowboardRepository.save(sb20);
            snowboardRepository.save(sb22);
            snowboardRepository.save(sb23);
            snowboardRepository.save(sb24);
            snowboardRepository.save(sb25);
            snowboardRepository.save(sb26);
            snowboardRepository.save(sb27);
            snowboardRepository.save(sb28);
            snowboardRepository.save(sb29);
            snowboardRepository.save(sb30);
            snowboardRepository.save(sb31);
            snowboardRepository.save(sb32);
            snowboardRepository.save(sb33);
            snowboardRepository.save(sb34);
            snowboardRepository.save(sb35);
            snowboardRepository.save(sb36);
            snowboardRepository.save(sb37);
            snowboardRepository.save(sb38);
            snowboardRepository.save(sb39);
            snowboardRepository.save(sb40);
            snowboardRepository.save(sb41);
            snowboardRepository.save(sb42);
            snowboardRepository.save(sb43);
            snowboardRepository.save(sb44);
            snowboardRepository.save(sb45);
            snowboardRepository.save(sb46);
            snowboardRepository.save(sb47);
        }
    }
}
