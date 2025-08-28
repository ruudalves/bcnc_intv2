package com.bcnc.two.application.rest.request;
import com.bcnc.two.application.entity.PriceCheckerDto;
import jakarta.validation.constraints.NotNull;

public record GetPriceRequest(@NotNull PriceCheckerDto priceCheckerDto) {

}
