package com.bcnc.two.domain.in.query;

import com.bcnc.two.domain.entity.Price;
import com.bcnc.two.domain.in.query.params.SearchPricesByDateRangeAndProductAndBrandParams;

import java.util.Optional;

public interface PricesQuery {
    Optional<Price> findByDateAndProductIdAndBrandId(SearchPricesByDateRangeAndProductAndBrandParams params);
}
