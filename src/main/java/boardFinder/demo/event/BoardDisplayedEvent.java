package boardFinder.demo.event;

import java.io.Serializable;

import lombok.*;

/**
 *
 * @author Erik
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardDisplayedEvent implements Serializable {
 
    private final long displayedBoardId;
    private final String model;
    private final String brand;
    private final String gender;
    private final String bend;

}
