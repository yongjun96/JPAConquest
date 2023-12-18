package jpaBook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "PARENT_SEQ_GENERATOR", sequenceName = "PARENT_SEQ", initialValue = 1, allocationSize = 20)
public class Parent {

    @Id @GeneratedValue(generator = "PARENT_SEQ",strategy = GenerationType.SEQUENCE)
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

}
