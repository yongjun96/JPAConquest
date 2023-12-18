package jpatest;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


//@Table(name = "USER") // 쿼리가 나갈 때 table을 강제로 지정해줌
@Setter
@Getter
//@Entity --> JPA를 사용할 때 꼭 있어야 함.
@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 20)
public class Member {

    //JPA는 기본생성자가 하나 있어야 한다.
    public Member(){}

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    //@Column(name = "name") // @Column은 DB의 컬럼명과 변수의 컬럼명이 다를 때 매칭해줌
    //@Column(unique = true, length = 10) // DB의 제한조건 추가 unique, 길이 10
    private String name;

    private String city;

    private String street;

    private String zipCode;
}
