package jpaBook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "ORDER_ITEM_SEQ_GENERATER", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 50)
public class OrderItem extends BaseEntity{

    public OrderItem(){}

    @Id
    @GeneratedValue(generator = "ORDER_ITEM_SEQ_GENERATER", strategy = GenerationType.SEQUENCE)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    private int orderPrice;

    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

}
