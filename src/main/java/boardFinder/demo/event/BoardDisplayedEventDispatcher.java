
package boardFinder.demo.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
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
    
    public void sendBoardDisplayedEvent(final BoardDisplayedEvent boardDisplayedEvent) {
        rabbitTemplate.convertAndSend(boardDisplayedEventExchange,
                boardDisplayedRoutingKey,
                boardDisplayedEvent);
    }      
}
