package org.dlegeza.farmshop.rest;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.dlegeza.farmshop.entities.animals.Goat;
import org.dlegeza.farmshop.entities.animals.Lamb;
import org.dlegeza.farmshop.entities.animals.Sheep;
import org.dlegeza.farmshop.entities.enums.Sex;
import org.dlegeza.farmshop.services.ReconfigurationService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {
	@Autowired
	private ReconfigurationService reconfigurationService;
	@Autowired
	TestRestTemplate restTemplate;

	@Before
	public void setUp() {
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

		this.reconfigurationService.constructNewFarm(farm);
	}
}
