package com.bcnc.two.domain.shared;

import com.bcnc.two.application.entity.PriceDto;
import com.bcnc.two.domain.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brand.brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceDto toPriceDto(Price price);
}
