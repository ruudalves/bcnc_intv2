package com.bcnc.two.controller;

import com.bcnc.two.controller.helper.PriceCheckerDto;
import com.bcnc.two.entities.Prices;
import com.bcnc.two.controller.helper.PriceDto;
import com.bcnc.two.service.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/prices")
@AllArgsConstructor
public class PricesController {


    private PricesService pricesService;

    @GetMapping
    public ResponseEntity<PriceDto> getPrice(@RequestBody PriceCheckerDto priceChecker){
        Optional<Prices> price = pricesService.getPetitionDescribed(priceChecker.getDate(),priceChecker.getProductId(),priceChecker.getBrandId());
        PriceDto priceDto = new PriceDto();
        return price.map(prices -> ResponseEntity.ok(priceDto.fromPrice(prices))).orElseGet(() ->  ResponseEntity.notFound().build());
    }

}
