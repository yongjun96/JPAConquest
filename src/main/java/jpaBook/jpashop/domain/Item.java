package jpatest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "ITEM_SEQ_GENERATOR", sequenceName = "ITEM_SEQ", initialValue = 1, allocationSize = 50)
public class Item {

    public Item(){}

    @Id @GeneratedValue(generator = "ITEM_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

}
