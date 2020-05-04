
package boardFinder.demo.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Event dispatcher class to dispatch events of displayed snowboards to RabbitMQ Message Broker. 
 * @author Erik
 */

@Component
public class BoardDisplayedEventDispatcher {
    
    private RabbitTemplate rabbitTemplate;
    
    private String boardDisplayedEventExchange;
    
    private String boardDisplayedRoutingKey;
    
    @Autowired
    BoardDisplayedEventDispatcher(final RabbitTemplate rabbitTemplate,
                @Value("${boarddisplayed.exchange}") final String boardDisplayedEventExchange,
                @Value("${boarddisplayed.sent.key}") final String boardDisplayedRoutingKey) {
                this.rabbitTemplate = rabbitTemplate;
                this.boardDisplayedEventExchange = boardDisplayedEventExchange;
                this.boardDisplayedRoutingKey = boardDisplayedRoutingKey;
    }
    
    /** 
     * Dispatches a boardDisplayedEvent to the RabbitMQ Message Broker
     * @param boardDisplayedEvent 
     */
    public void sendBoardDisplayedEvent(final BoardDisplayedEvent boardDisplayedEvent) {
        rabbitTemplate.convertAndSend(boardDisplayedEventExchange,
                boardDisplayedRoutingKey,
                boardDisplayedEvent);
    }      
}
