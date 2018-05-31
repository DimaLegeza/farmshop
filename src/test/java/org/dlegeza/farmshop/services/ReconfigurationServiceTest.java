package org.dlegeza.farmshop.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.dlegeza.farmshop.entities.animals.Goat;
import org.dlegeza.farmshop.entities.animals.Lamb;
import org.dlegeza.farmshop.entities.animals.Sheep;
import org.dlegeza.farmshop.entities.enums.Sex;
import org.junit.Before;
import org.junit.Test;

public class ReconfigurationServiceTest {
	private ReconfigurationService service;
	private FarmService farmService;
	private StockService stockService;

	@Before
	public void setUp() {
		// GIVEN
		this.farmService = new FarmService();
		this.stockService = new StockService(farmService);
		this.service = new ReconfigurationService(farmService, stockService);
	}

	@Test
	public void reConstructWithEmptyFarm_Success() {
		// WHEN
		this.service.constructNewFarm(new Farm());

		// THEN
		assertEquals(0, this.farmService.getFarm().getFlock().size());
		assertEquals(0, this.stockService.getStock().getWool());
		assertEquals(0, this.stockService.getStock().getMilk());
	}

	@Test
	public void reConstructWithFullFarm_Success() {
		// GIVEN
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

		// WHEN
		this.service.constructNewFarm(farm);

		// THEN
		assertEquals(5, this.farmService.getFarm().getFlock().size());
		assertEquals(67, this.stockService.getStock().getWool());
		assertEquals(80, this.stockService.getStock().getMilk());
	}
}
