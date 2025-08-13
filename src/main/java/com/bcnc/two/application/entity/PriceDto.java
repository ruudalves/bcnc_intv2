package com.bcnc.two.application.entity;

import com.bcnc.two.domain.entity.Price;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class PriceDto {
    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String price;

    public boolean isEquals(Price price) {
        return productId == price.getProductId()
                && brandId == price.getBrand().getBrandId()
                && priceList == price.getPriceList()
                && Objects.equals(startDate, price.getStartDate())
                && Objects.equals(endDate, price.getEndDate())
                && this.price.equals(price.getPrice().toString());
    }

}
