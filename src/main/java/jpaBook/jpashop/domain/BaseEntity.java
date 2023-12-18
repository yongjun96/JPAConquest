package jpaBook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "insert_memeber")
    private String createdBy;
    private LocalDateTime createdDate;
    @Column(name = "update_member")
    private String lastModfiedBy;
    private LocalDateTime lastModifiedDate;

}
