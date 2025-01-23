package spring.api.orderms.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "tb_orders")
@Getter
@Setter
public class Order {

    @MongoId
    private Long id;

    @Indexed(name = "costumer_id_index")
    private Long costumerId;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItem> items;
}
