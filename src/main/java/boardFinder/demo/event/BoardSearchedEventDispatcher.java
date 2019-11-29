
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
public class BoardSearchedEventDispatcher {
    
    private RabbitTemplate rabbitTemplate;
    
    private String boardfinderExchange;
    
    private String boardSearchedRoutingKey;
    
    @Autowired
    BoardSearchedEventDispatcher(final RabbitTemplate rabbitTemplate,
                @Value("${boardsearched.exchange}") final String boardfinderExchange,
                @Value("${boardsearched.sent.key}") final String boardfinderSearchRoutingKey) {
                this.rabbitTemplate = rabbitTemplate;
                this.boardfinderExchange = boardfinderExchange;
                this.boardSearchedRoutingKey = boardfinderSearchRoutingKey;
    }
    
    public void sendBoardSearchedEvent(final BoardSearchedEvent boardSearchedEvent) {
        rabbitTemplate.convertAndSend(
                boardfinderExchange,
                boardSearchedRoutingKey,
                boardSearchedEvent);
    }      
}
