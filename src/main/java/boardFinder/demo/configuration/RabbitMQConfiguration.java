package boardFinder.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author Erik
 */
@Configuration
@EnableRabbit
public class RabbitMQConfiguration {
    
    @Bean
    public TopicExchange boardSearchedEventExchange(@Value ("${boardsearched.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }
    
    @Bean
    public TopicExchange boardDisplayedEventExchange(@Value ("${boarddisplayed.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }

    @Bean
    public RabbitTemplate rabbitTemplate( final ConnectionFactory rabbitConnectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
    
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
