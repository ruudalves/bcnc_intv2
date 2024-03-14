package com.bcnc.two.application.rest.response;

import com.bcnc.two.application.rest.controller.helper.PriceDto;
import com.bcnc.two.domain.Prices;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class GetPriceResponse {

    @Getter
    private final ResponseEntity<PriceDto> priceDtoResponseEntity;

    public GetPriceResponse(final Optional<Prices> price){

        PriceDto priceDto = new PriceDto();
        if(price.isPresent()){
            priceDtoResponseEntity = new ResponseEntity<>(priceDto.fromPrice(price.get()), HttpStatus.OK);
        } else {
            priceDtoResponseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
