package jpaBook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "CHILD_SEQ_GENERATOR", sequenceName = "CHILD_SEQ", initialValue = 1, allocationSize = 20)
public class Child {

    @Id @GeneratedValue(generator = "CHILD_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

}
