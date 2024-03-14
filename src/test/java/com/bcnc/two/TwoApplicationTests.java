package com.bcnc.two;

import com.bcnc.two.application.rest.controller.PricesController;
import com.bcnc.two.application.rest.controller.helper.PriceCheckerDto;
import com.bcnc.two.application.rest.controller.helper.PriceDto;
import com.bcnc.two.application.rest.request.GetPriceRequest;
import com.bcnc.two.domain.Brand;
import com.bcnc.two.domain.Prices;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoApplicationTests {

	@Autowired
	private PricesController pricesController;

    private GetPriceRequest setUp(String date){
		PriceCheckerDto priceCheckerDto = new PriceCheckerDto();
		priceCheckerDto.setBrandId(1);
		priceCheckerDto.setProductId(35455);
		priceCheckerDto.setDate(LocalDateTime.parse(date));
		return new GetPriceRequest(priceCheckerDto);
	}

    @Test
	@Order(1)
	void should_getPrice_at10amOn14() {
		ResponseEntity<PriceDto> response = pricesController.getPrice(setUp("2020-06-14T10:00:00")).getPriceDtoResponseEntity();
		Prices mockPrice = new Prices();
		Brand mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("ZARA");
		mockPrice.setPrice(35.5);
		mockPrice.setPriceList(1);
		mockPrice.setId(1);
		mockPrice.setBrand(mockBrand);
		mockPrice.setPriority(0);
		mockPrice.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
		mockPrice.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		mockPrice.setCurrency("EUR");
		mockPrice.setProductId(35455);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(Objects.requireNonNull(response.getBody()).isEquals(mockPrice));
	}

	@Test
	@Order(2)
	void should_getPrice_at16Of14(){
		ResponseEntity<PriceDto> response = pricesController.getPrice(setUp("2020-06-14T16:00:00")).getPriceDtoResponseEntity();
		Prices mockPrice = new Prices();
		Brand mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("ZARA");
		mockPrice.setPrice(25.45);
		mockPrice.setPriceList(2);
		mockPrice.setId(1);
		mockPrice.setBrand(mockBrand);
		mockPrice.setPriority(1);
		mockPrice.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00"));
		mockPrice.setEndDate(LocalDateTime.parse("2020-06-14T18:30:00"));
		mockPrice.setCurrency("EUR");
		mockPrice.setProductId(35455);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(Objects.requireNonNull(response.getBody()).isEquals(mockPrice));
	}

	@Test
	@Order(3)
	void should_getPrice_at21hOn14(){
		ResponseEntity<PriceDto> response = pricesController.getPrice(setUp("2020-06-14T21:00:00")).getPriceDtoResponseEntity();
		Prices mockPrice = new Prices();
		Brand mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("ZARA");
		mockPrice.setPrice(35.5);
		mockPrice.setPriceList(1);
		mockPrice.setId(1);
		mockPrice.setBrand(mockBrand);
		mockPrice.setPriority(0);
		mockPrice.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
		mockPrice.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		mockPrice.setCurrency("EUR");
		mockPrice.setProductId(35455);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(Objects.requireNonNull(response.getBody()).isEquals(mockPrice));
	}

	@Test
	@Order(4)
	void should_getPrice_at10hOn15(){
		ResponseEntity<PriceDto> response = pricesController.getPrice(setUp("2020-06-15T10:00:00")).getPriceDtoResponseEntity();
		Prices mockPrice = new Prices();
		Brand mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("ZARA");
		mockPrice.setPrice(30.5);
		mockPrice.setPriceList(3);
		mockPrice.setId(1);
		mockPrice.setBrand(mockBrand);
		mockPrice.setPriority(1);
		mockPrice.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
		mockPrice.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
		mockPrice.setCurrency("EUR");
		mockPrice.setProductId(35455);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(Objects.requireNonNull(response.getBody()).isEquals(mockPrice));
	}

	@Test
	@Order(5)
	void should_getPrice_at21hOn16(){
		ResponseEntity<PriceDto> response = pricesController.getPrice(setUp("2020-06-16T21:00:00")).getPriceDtoResponseEntity();
		Prices mockPrice = new Prices();
		Brand mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("ZARA");
		mockPrice.setPrice(38.95);
		mockPrice.setPriceList(4);
		mockPrice.setId(1);
		mockPrice.setBrand(mockBrand);
		mockPrice.setPriority(1);
		mockPrice.setStartDate(LocalDateTime.parse("2020-06-15T16:00:00"));
		mockPrice.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		mockPrice.setCurrency("EUR");
		mockPrice.setProductId(35455);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(Objects.requireNonNull(response.getBody()).isEquals(mockPrice));
	}

}
