package jpatest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@SequenceGenerator(name = "ORDER_SEQ_GENERATOR", sequenceName = "ORDER_SEQ", initialValue = 1, allocationSize = 50)
public class Order {

    public Order(){}

    @Id @GeneratedValue(generator = "ORDER_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long memberId;

    private LocalDateTime orderDate;

    private String status;



}
