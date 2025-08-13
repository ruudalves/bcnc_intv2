package com.bcnc.two.application.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceCheckerDto {
    @NotNull
    private LocalDateTime date;
    @NotNull
    private int productId;
    @NotNull
    private int brandId;

}
