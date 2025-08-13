package com.bcnc.two.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "BRAND_NAME")
    private String brandName;
    @OneToMany(mappedBy = "brand")
    private Set<Price> prices;
}
