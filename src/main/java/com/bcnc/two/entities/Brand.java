package com.bcnc.two.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "BRAND_NAME")
    private String brandName;
    @OneToMany(mappedBy = "brand")
    private Set<Prices> price;
}
