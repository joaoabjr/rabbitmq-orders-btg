package spring.api.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.api.orderms.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {

}
