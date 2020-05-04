package boardFinder.demo.event;

import java.io.Serializable;

import lombok.*;

/**
 * Event class to be dispatched to the RabbitMQ Message Broker that represents the search parameters of a snowboard search. 
 * @author Erik
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardSearchedEvent implements Serializable {
 
    private final String gender;
    private final int weight;
    private final double shoeSize;
    private final String riderLevel;
    private final String terrain;
    private final String shape;
    private final String flex;
    private final String bend;

}
