package com.bcnc.two.domain.in.query.params;

import java.time.LocalDateTime;

public record SearchPricesByDateRangeAndProductAndBrandParams(LocalDateTime date, int productId, int brandId) {
}
