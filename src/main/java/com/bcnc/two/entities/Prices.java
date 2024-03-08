package com.bcnc.two.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="PRICES")
public class Prices implements Serializable {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "BRAND_ID")
    private int brandId;
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
