package com.bcnc.two.infrastructure.repository;

import com.bcnc.two.domain.entity.Brand;
import com.bcnc.two.domain.entity.Price;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;

public interface SpringDataH2PriceRepository extends JpaRepository<Price, Long>, JpaSpecificationExecutor<Price> {

    static Specification<Price> findByDateRangeAndBrandAndProduct(LocalDateTime date, int productId, int brandId) {
        return (prices, cq, cb) -> {
            Join<Price, Brand> brandJoin = prices.join("brand", JoinType.INNER);
            CriteriaBuilder criteriaBuilder = cb;

            Subquery<Integer> subquery = cq.subquery(Integer.class);
            Root<Price> subFrom = subquery.from(Price.class);
            Join<Price, Brand> pricesBrandJoin = subFrom.join("brand", JoinType.LEFT);
            subquery.select(criteriaBuilder.max(subFrom.get("priority")).as(Integer.class));
            subquery.where(criteriaBuilder.and(criteriaBuilder.equal(pricesBrandJoin.get("brandId"), brandId),
                    criteriaBuilder.lessThanOrEqualTo(subFrom.get("startDate"), date),
                    criteriaBuilder.greaterThanOrEqualTo(subFrom.get("endDate"), date),
                    criteriaBuilder.equal(subFrom.get("productId"), productId)));


            return cb.and(cb.and(cb.equal(brandJoin.get("brandId"), brandId),
                            cb.lessThanOrEqualTo(prices.get("startDate"), date),
                            cb.greaterThanOrEqualTo(prices.get("endDate"), date),
                            cb.equal(prices.get("productId"), productId)),
                    cb.equal(prices.get("priority"),subquery));
        };
    }
}
