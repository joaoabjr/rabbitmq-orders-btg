package spring.api.orderms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import spring.api.orderms.config.RabbitMqConfig;
import spring.api.orderms.listener.dto.OrderCreatedEvent;

@Component
public class OrderCreatedListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitListener(queues = RabbitMqConfig.ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed: {}", message);
    }
}
