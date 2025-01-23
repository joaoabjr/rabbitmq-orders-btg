package spring.api.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.api.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {

}
