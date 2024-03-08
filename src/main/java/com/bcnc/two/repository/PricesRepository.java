package com.bcnc.two.repository;

import com.bcnc.two.entities.Brand;
import com.bcnc.two.entities.Prices;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long>, JpaSpecificationExecutor<Prices> {
    static Specification<Prices> findByDateRangeAndBrandAndProduct(LocalDateTime date, int productId, int brandId) {
        return (prices, cq, cb) -> {
            Join<Prices, Brand> brandJoin = prices.join("brand", JoinType.INNER);
            List<Order> orders = new ArrayList<>();
            orders.add(cb.desc(prices.get("priority")));
            cq.orderBy(orders);

            return cb.and(
                    cb.equal(brandJoin.get("brandId"), brandId),
                    cb.lessThanOrEqualTo(prices.get("startDate"), date),
                    cb.greaterThanOrEqualTo(prices.get("endDate"), date),
                    cb.equal(prices.get("productId"), productId)
            );
        };
    }
}
