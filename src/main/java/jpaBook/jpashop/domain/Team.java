package jpaBook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "TEAM_SEQ_GENERATOR", sequenceName = "TEAM_SEQ", initialValue = 1, allocationSize = 20)
public class Team extends BaseEntity{
    public Team(){}

    @Id @GeneratedValue(generator = "TEAM_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> memberList = new ArrayList<>();

}
