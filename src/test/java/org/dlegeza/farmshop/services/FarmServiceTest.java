package org.dlegeza.farmshop.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.dlegeza.farmshop.entities.animals.Goat;
import org.dlegeza.farmshop.entities.animals.Lamb;
import org.dlegeza.farmshop.entities.animals.Sheep;
import org.junit.Before;
import org.junit.Test;

public class FarmServiceTest {
	private FarmService service;

	@Before
	public void setUp() {
		this.service = new FarmService();
	}

	@Test
	public void farmShouldBeEmptyByDefault_Success() {
		assertNull(this.service.getFarm());
	}

	@Test
	public void farmShouldBeInitializedWithPartialContent_Success() {
		// GIVEN
		final FarmAnimal goat = new Goat();
		final List<FarmAnimal> goats = new ArrayList<>();
		goats.add(goat);
		final Farm farm = new Farm();
		farm.setGoat(goats);

		// WHEN
		this.service.setFarm(farm);

		// THEN
		assertNotNull(this.service.getFarm());
		assertEquals(1, this.service.getFarm().getFlock().size());
	}

	@Test
	public void farmShouldBeInitializedWithFullContent_Success() {
		// GIVEN
		final List<FarmAnimal> goats = new ArrayList<>();
		final List<FarmAnimal> lambs = new ArrayList<>();
		final List<FarmAnimal> sheep = new ArrayList<>();
		goats.add(new Goat());
		lambs.add(new Lamb());
		sheep.add(new Sheep());
		final Farm farm = new Farm();
		farm.setGoat(goats);
		farm.setLamb(lambs);
		farm.setSheep(sheep);

		// WHEN
		this.service.setFarm(farm);

		// THEN
		assertNotNull(this.service.getFarm());
		assertEquals(3, this.service.getFarm().getFlock().size());
	}
}
