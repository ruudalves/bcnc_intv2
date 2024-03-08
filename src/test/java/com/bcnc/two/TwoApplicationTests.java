package com.bcnc.two;

import com.bcnc.two.entities.Prices;
import com.bcnc.two.repository.PricesRepository;
import com.bcnc.two.service.PricesService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TwoApplicationTests {

	@Autowired
	private PricesService pricesService;
	@Autowired
	private PricesRepository pricesRepository;
    @Test
	@Order(1)
	void get_pricesAt10amOn14() {
		Optional<Prices> optionalPrices = pricesService.findByValues(LocalDateTime.parse("2020-06-14T10:00:00"),35455,1);
		assertTrue(optionalPrices.isPresent());
		assertEquals("35.5EUR", String.valueOf(optionalPrices.get().getPrice()).concat(optionalPrices.get().getCurrency()));
	}

	@Test
	@Order(2)
	void get_priceAt16Of14(){
		Optional<Prices> optionalPrices = pricesService.findByValues(LocalDateTime.parse("2020-06-14T16:00:00"),35455,1);
		assertTrue(optionalPrices.isPresent());
		assertEquals("25.45EUR", String.valueOf(optionalPrices.get().getPrice()).concat(optionalPrices.get().getCurrency()));
	}

	@Test
	@Order(3)
	void should_getPrice_at21hOn14(){
		Optional<Prices> optionalPrices = pricesService.findByValues(LocalDateTime.parse("2020-06-14T21:00:00"),35455,1);
		assertTrue(optionalPrices.isPresent());
		assertEquals("35.5EUR", String.valueOf(optionalPrices.get().getPrice()).concat(optionalPrices.get().getCurrency()));
	}

	@Test
	@Order(4)
	void should_getPrice_at10hOn15(){
		Optional<Prices> optionalPrices = pricesService.findByValues(LocalDateTime.parse("2020-06-15T10:00:00"),35455,1);
		assertTrue(optionalPrices.isPresent());
		assertEquals("30.5EUR", String.valueOf(optionalPrices.get().getPrice()).concat(optionalPrices.get().getCurrency()));
	}

	@Test
	@Order(5)
	void should_getPrice_at21hOn16(){
		Optional<Prices> optionalPrices = pricesService.findByValues(LocalDateTime.parse("2020-06-16T21:00:00"),35455,1);
		assertTrue(optionalPrices.isPresent());
		assertEquals("38.95EUR", String.valueOf(optionalPrices.get().getPrice()).concat(optionalPrices.get().getCurrency()));
	}

}
