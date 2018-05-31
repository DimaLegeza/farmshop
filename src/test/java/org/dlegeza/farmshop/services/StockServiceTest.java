package org.dlegeza.farmshop.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.dto.OrderDTO;
import org.dlegeza.farmshop.dto.OrderDetailsDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.dlegeza.farmshop.entities.animals.Goat;
import org.dlegeza.farmshop.entities.animals.Lamb;
import org.dlegeza.farmshop.entities.animals.Sheep;
import org.dlegeza.farmshop.entities.enums.Sex;
import org.junit.Before;
import org.junit.Test;

public class StockServiceTest {
	private StockService service;

	@Before
	public void setUp() {
		// GIVEN
		final FarmService farmService = new FarmService();
		final List<FarmAnimal> goats = new ArrayList<>();
		final List<FarmAnimal> lambs = new ArrayList<>();
		final List<FarmAnimal> sheep = new ArrayList<>();
		goats.add(new Goat("Alice", Sex.F, 0));
		goats.add(new Goat("Stanislas", Sex.M, 0));
		lambs.add(new Lamb("Teemo", Sex.M, 5));
		sheep.add(new Sheep("Robert", Sex.M, 34));
		sheep.add(new Sheep("Betty", Sex.F, 28));
		Farm farm = new Farm();
		farm.setSheep(sheep);
		farm.setLamb(lambs);
		farm.setGoat(goats);

		farmService.setFarm(farm);

		this.service = new StockService(farmService);
		this.service.defineStock();
	}

	@Test
	public void stockShouldBeDefined_Success() {
		// THEN
		assertEquals(80, this.service.getStock().getMilk());
		assertEquals(67, this.service.getStock().getWool());
	}

	@Test
	public void submitOrder_Success() {
		// GIVEN
		OrderDTO order = new OrderDTO("Customer BV", new OrderDetailsDTO(20, 20));

		// WHEN
		OrderDTO result = this.service.processOrder(order);

		// THEN
		assertNotNull(result);
	}

	@Test
	public void submitOrder_Failure() {
		// GIVEN
		OrderDTO order = new OrderDTO("Customer BV", new OrderDetailsDTO(100, 20));

		// WHEN
		OrderDTO result = this.service.processOrder(order);

		// THEN
		assertNull(result);
	}

	@Test
	public void submitMultipleOrdersAndLastRejected_Success() {
		// WHEN
		OrderDTO order = new OrderDTO("Customer BV", new OrderDetailsDTO(20, 20));

		// THEN
		assertNotNull(this.service.processOrder(order));
		assertNotNull(this.service.processOrder(order));
		assertNotNull(this.service.processOrder(order));
		assertNull(this.service.processOrder(order));
	}

}
