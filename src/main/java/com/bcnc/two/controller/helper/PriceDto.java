package com.bcnc.two.controller.helper;

import com.bcnc.two.entities.Prices;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PriceDto {
    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String price;

    public PriceDto fromPrice(Prices price){
        PriceDto dto = new PriceDto();
        dto.setPrice(price.getPrice().toString().concat(price.getCurrency()));
        dto.setPriceList(price.getPriceList());
        dto.setBrandId(price.getBrand().getBrandId());
        dto.setEndDate(price.getEndDate());
        dto.setStartDate(price.getStartDate());
        dto.setProductId(price.getProductId());
        return dto;
    }
}
