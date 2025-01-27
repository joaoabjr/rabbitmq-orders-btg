package spring.api.orderms.controller.dto;

import java.math.BigDecimal;

import spring.api.orderms.entity.OrderEntity;

public record OrderResponse(Long orderId, Long customerId, BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity) {
        return new OrderResponse(entity.getOrderId(), entity.getCostumerId(), entity.getTotal());
    }
}
