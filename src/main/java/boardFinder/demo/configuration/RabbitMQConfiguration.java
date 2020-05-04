package boardFinder.demo.configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for connection to RabbitMQ Message Broker
 *
 * @author Erik
 */
@Configuration
@EnableRabbit
public class RabbitMQConfiguration {

    /**
     * Creates the Topic Exchange for the BoardSearched Event Exchange.
     *
     * @param exchangeName
     * @return a TopicExchange used for the boardSearched queue
     */
    @Bean
    public TopicExchange boardSearchedEventExchange(@Value("${boardsearched.exchange}") final String exchangeName) {
        return new TopicExchange(exchangeName);
    }

    /**
     * Creates the Topic Exchange for the BoardDispalyed Event Exchange.
     *
     * @param exchangeName
     * @return a TopicExchange used for the boardDisplayed queue
     */
    @Bean
    public TopicExchange boardDisplayedEventExchange(@Value("${boarddisplayed.exchange}") final String exchangeName) {
        return new TopicExchange(exchangeName);
    }

    /**
     * Creates the template to be able to connect to RabbitMQ and send messages
     *
     * @param rabbitConnectionFactory
     * @return RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory rabbitConnectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    /**
     * Creates the Jackson2JsonMessageConverter for serializing messeges to JSON
     * used in Rabbit MQ.
     *
     * @return Jackson2JsonMessageConverter
     */
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
