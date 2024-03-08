package com.bcnc.two.controller;

import com.bcnc.two.controller.helper.PriceCheckerDto;
import com.bcnc.two.service.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/prices")
@AllArgsConstructor
public class PricesController {


    private PricesService pricesService;

    @GetMapping
    public ResponseEntity<String> getPriceDescription(@RequestBody PriceCheckerDto priceChecker){
        return ResponseEntity.ok(pricesService.getPetitionDescribed(priceChecker.getDate(),priceChecker.getProductId(),priceChecker.getBrandId()));
    }

}
