package com.bcnc.two.application.rest.request;
import com.bcnc.two.application.entity.PriceCheckerDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
public class GetPriceRequest {
    @NotNull
    private PriceCheckerDto priceCheckerDto;

    public GetPriceRequest(@JsonProperty("priceCheckDto") @NotNull final PriceCheckerDto priceCheckerDto){
        this.priceCheckerDto=priceCheckerDto;
    }

    public PriceCheckerDto getPriceCheckerDto() {
        return this.priceCheckerDto;
    }

}
