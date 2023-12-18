package jpaBook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "CATEGOEY_SEQ_GENERATOR", sequenceName = "CATEGOEY_SEQ", initialValue = 1, allocationSize = 20)
public class Category extends BaseEntity{

    @Id @GeneratedValue(generator = "CATEGOEY_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "CATEGOEY_ID")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Item> items = new ArrayList<>();

}
