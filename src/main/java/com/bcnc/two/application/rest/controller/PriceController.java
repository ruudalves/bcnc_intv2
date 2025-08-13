package com.bcnc.two.application.rest.controller;

import com.bcnc.two.application.rest.request.GetPriceRequest;
import com.bcnc.two.application.rest.response.GetPriceResponse;
import com.bcnc.two.domain.entity.Price;
import com.bcnc.two.domain.in.query.PricesQuery;
import com.bcnc.two.domain.in.query.params.SearchPricesByDateRangeAndProductAndBrandParams;
import com.bcnc.two.domain.shared.PriceMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/prices")
public class PriceController {

    private final PricesQuery pricesQuery;
    private final PriceMapper mapper;

    @Autowired
    public PriceController(PricesQuery pricesQuery, PriceMapper mapper){
        this.pricesQuery=pricesQuery;
        this.mapper = mapper;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Request Created"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    @GetMapping
    public GetPriceResponse getPrice(@RequestBody GetPriceRequest getPriceRequest){
        Optional<Price> price =
                pricesQuery.findByDateAndProductIdAndBrandId(new SearchPricesByDateRangeAndProductAndBrandParams(getPriceRequest.getPriceCheckerDto().getDate(),
                        getPriceRequest.getPriceCheckerDto().getProductId(),
                        getPriceRequest.getPriceCheckerDto().getBrandId()));
        return new GetPriceResponse(price, mapper);
    }

}
