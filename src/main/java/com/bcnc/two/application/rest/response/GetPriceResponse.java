package com.bcnc.two.application.rest.response;

import com.bcnc.two.application.entity.PriceDto;
import com.bcnc.two.domain.entity.Price;
import com.bcnc.two.domain.shared.PriceMapper;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Getter
public class GetPriceResponse {

    private final ResponseEntity<PriceDto> priceDtoResponseEntity;

    public GetPriceResponse(final Optional<Price> optionalPrice){
        priceDtoResponseEntity = optionalPrice.map(prices -> new ResponseEntity<>(PriceMapper.INSTANCE.toPriceDto(optionalPrice.get()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

}
