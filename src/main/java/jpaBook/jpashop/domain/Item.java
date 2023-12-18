package jpaBook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "ITEM_SEQ_GENERATOR", sequenceName = "ITEM_SEQ", initialValue = 1, allocationSize = 50)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Item extends BaseEntity{

    public Item(){}

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(generator = "ITEM_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private int price;

    @ManyToMany
    @JoinTable(name = "Items")
    private List<Category> categoryList = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItemList = new ArrayList<>();


}
