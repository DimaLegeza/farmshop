package org.dlegeza.farmshop.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.dlegeza.farmshop.dto.OrderDTO;
import org.dlegeza.farmshop.dto.OrderDetailsDTO;
import org.dlegeza.farmshop.entities.Stock;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class StockControllerTest extends BaseTest {

	@Test
	public void testOriginalSetup_Success() {
		// WHEN
		ResponseEntity<Stock> stock = this.restTemplate.getForEntity("/farmshop/stock", Stock.class);

		// THEN
		assertEquals(HttpStatus.OK, stock.getStatusCode());
		assertNotNull(stock.getBody());
		assertEquals(67, stock.getBody().getWool());
		assertEquals(80, stock.getBody().getMilk());
	}

	@Test
	public void testShouldHandleOrder_Success() {
		// GIVEN
		OrderDTO order = new OrderDTO("Customer BV", new OrderDetailsDTO(20, 20));

		// WHEN
		ResponseEntity<OrderDTO> orderResponse = this.restTemplate.postForEntity("/farmshop/order", order, OrderDTO.class);

		// THEN
		assertEquals(HttpStatus.ACCEPTED, orderResponse.getStatusCode());
		assertNotNull(orderResponse.getBody());
		assertEquals(order, orderResponse.getBody());

		ResponseEntity<Stock> stock = this.restTemplate.getForEntity("/farmshop/stock", Stock.class);

		assertEquals(HttpStatus.OK, stock.getStatusCode());
		assertNotNull(stock.getBody());
		assertEquals(47, stock.getBody().getWool());
		assertEquals(60, stock.getBody().getMilk());
	}

	@Test
	public void testShouldFailToHandleOrder_Success() {
		// GIVEN
		OrderDTO order = new OrderDTO("Customer BV", new OrderDetailsDTO(100, 20));

		// WHEN
		ResponseEntity<OrderDTO> orderResponse = this.restTemplate.postForEntity("/farmshop/order", order, OrderDTO.class);

		// THEN
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, orderResponse.getStatusCode());
		assertNotNull(orderResponse.getBody());
		assertEquals(order, orderResponse.getBody());

		ResponseEntity<Stock> stock = this.restTemplate.getForEntity("/farmshop/stock", Stock.class);

		assertEquals(HttpStatus.OK, stock.getStatusCode());
		assertNotNull(stock.getBody());
		assertEquals(67, stock.getBody().getWool());
		assertEquals(80, stock.getBody().getMilk());
	}


}
