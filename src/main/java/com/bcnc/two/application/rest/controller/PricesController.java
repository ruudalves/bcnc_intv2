package com.bcnc.two.application.rest.controller;

import com.bcnc.two.application.rest.controller.helper.PriceCheckerDto;
import com.bcnc.two.application.rest.request.GetPriceRequest;
import com.bcnc.two.application.rest.response.GetPriceResponse;
import com.bcnc.two.domain.Prices;
import com.bcnc.two.application.rest.controller.helper.PriceDto;
import com.bcnc.two.domain.service.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/v1/price")
public class PricesController {

    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService){
        this.pricesService=pricesService;
    }

    @GetMapping
    public GetPriceResponse getPrice(@RequestBody GetPriceRequest getPriceRequest){
        Optional<Prices> price =
                pricesService.findByValues(getPriceRequest.getPriceCheckerDto().getDate(),
                        getPriceRequest.getPriceCheckerDto().getProductId(),
                        getPriceRequest.getPriceCheckerDto().getBrandId());
        return new GetPriceResponse(price);
    }

}
