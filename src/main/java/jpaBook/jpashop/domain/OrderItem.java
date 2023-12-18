package jpatest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "ORDER_ITEM_SEQ_GENERATER", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 50)
public class OrderItem {

    public OrderItem(){}

    @Id @GeneratedValue(generator = "ORDER_ITEM_SEQ_GENERATER", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long OrderId;

    private Long itemId;

    private int orderPrice;

    private Integer count;

}
