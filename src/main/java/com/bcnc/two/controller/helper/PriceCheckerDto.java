package com.bcnc.two.controller.helper;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceCheckerDto {

    private LocalDateTime date;

    private int productId;

    private int brandId;

}
