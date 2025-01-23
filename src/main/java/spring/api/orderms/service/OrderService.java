package spring.api.orderms.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.api.orderms.entity.Order;
import spring.api.orderms.entity.OrderItem;
import spring.api.orderms.listener.dto.OrderCreatedEvent;
import spring.api.orderms.listener.dto.OrderItemEvent;
import spring.api.orderms.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent event) {
        var orderEntity = new Order();

        orderEntity.setId(event.codigoPedido());
        orderEntity.setCostumerId(event.codigoCliente());
        orderEntity.setItems(getOrderItems(event));
        orderEntity.setTotal(getTotal(event));
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(item -> item.preco().multiply(BigDecimal.valueOf(item.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(item -> new OrderItem(item.produto(), item.quantidade(), item.preco()))
                .toList();
    }

}
