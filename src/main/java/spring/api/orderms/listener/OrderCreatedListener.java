package spring.api.orderms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import spring.api.orderms.config.RabbitMqConfig;
import spring.api.orderms.listener.dto.OrderCreatedEvent;

@Component
public class OrderCreatedListener {

    @RabbitListener(queues = RabbitMqConfig.ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {

    }
}
