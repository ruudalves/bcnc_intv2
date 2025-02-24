package com.bcnc.two.application.rest.controller;

import com.bcnc.two.application.rest.request.GetPriceRequest;
import com.bcnc.two.application.rest.response.GetPriceResponse;
import com.bcnc.two.domain.Prices;
import com.bcnc.two.domain.service.PricesService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/prices")
public class PricesController {

    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService){
        this.pricesService=pricesService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Request Created"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    @GetMapping
    public GetPriceResponse getPrice(@RequestBody GetPriceRequest getPriceRequest){
        Optional<Prices> price =
                pricesService.findByValues(getPriceRequest.getPriceCheckerDto().getDate(),
                        getPriceRequest.getPriceCheckerDto().getProductId(),
                        getPriceRequest.getPriceCheckerDto().getBrandId());
        return new GetPriceResponse(price);
    }

}
