package jpaBook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "delivery_seq_generator", sequenceName = "delivery_seq", initialValue = 1, allocationSize = 10)
public class Delivery extends BaseEntity{

    @Id @GeneratedValue(generator = "delivery_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Column(insertable = false, updatable = false)
    private String city;
    @Column(insertable = false, updatable = false)
    private String street;
    @Column(insertable = false, updatable = false)
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;


}
