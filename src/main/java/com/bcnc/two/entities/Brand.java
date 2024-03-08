package com.bcnc.two.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BRAND")
public class Brand {

    @Id
    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "BRAND_NAME")
    private String brandName;
}
