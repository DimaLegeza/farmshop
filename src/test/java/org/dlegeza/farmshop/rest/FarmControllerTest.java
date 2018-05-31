package org.dlegeza.farmshop.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.dto.FarmDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.Stock;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.dlegeza.farmshop.entities.animals.Goat;
import org.dlegeza.farmshop.entities.animals.Lamb;
import org.dlegeza.farmshop.entities.animals.Sheep;
import org.dlegeza.farmshop.entities.enums.Sex;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FarmControllerTest extends BaseTest {

	@Test
	public void getFarmInfo_Success() {
		// WHEN
		ResponseEntity<FarmDTO> farm = this.restTemplate.getForEntity("/farmshop/flock", FarmDTO.class);

		// THEN
		assertEquals(HttpStatus.OK, farm.getStatusCode());
		assertNotNull(farm.getBody());
		assertEquals(5, farm.getBody().getFlock().size());
		assertEquals("Alice", farm.getBody().getFlock().get(0).getName());
		assertEquals(Sex.F, farm.getBody().getFlock().get(0).getSex());
		assertEquals(0, farm.getBody().getFlock().get(0).getWool());
		assertEquals(50, farm.getBody().getFlock().get(0).getMilk());
	}

	@Test
	public void testFarmReconstruction_Success() {
		// GIVEN
		final List<FarmAnimal> goats = new ArrayList<>();
		final List<FarmAnimal> lambs = new ArrayList<>();
		final List<FarmAnimal> sheep = new ArrayList<>();
		goats.add(new Goat("Alison", Sex.F, 0));
		goats.add(new Goat("Andy", Sex.M, 0));
		lambs.add(new Lamb("John", Sex.M, 5));
		sheep.add(new Sheep("Tony", Sex.M, 34));
		sheep.add(new Sheep("Melany", Sex.F, 28));
		Farm farm = new Farm();
		farm.setSheep(sheep);
		farm.setLamb(lambs);
		farm.setGoat(goats);

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Farm> entity = new HttpEntity<>(farm, headers);

		// WHEN

		ResponseEntity<FarmDTO> persisted = this.restTemplate.exchange("/farmshop/flock", HttpMethod.PUT, entity, FarmDTO.class);

		// THEN
		assertEquals(HttpStatus.OK, persisted.getStatusCode());
		assertNotNull(persisted.getBody());

		assertEquals("Melany", persisted.getBody().getFlock().get(4).getName());
		assertEquals(Sex.F, persisted.getBody().getFlock().get(4).getSex());
		assertEquals("sheep", persisted.getBody().getFlock().get(4).getType());
		assertEquals(28, persisted.getBody().getFlock().get(4).getWool());
		assertEquals(30, persisted.getBody().getFlock().get(4).getMilk());

		ResponseEntity<Stock> stock = this.restTemplate.getForEntity("/farmshop/stock", Stock.class);

		assertEquals(HttpStatus.OK, stock.getStatusCode());
		assertNotNull(stock.getBody());

		assertEquals(67, stock.getBody().getWool());
		assertEquals(80, stock.getBody().getMilk());

	}
}
