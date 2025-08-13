package com.bcnc.two.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@Table(name="price")
@AllArgsConstructor
@RequiredArgsConstructor
public class Price implements Serializable {

    @Id
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String currency;
}
