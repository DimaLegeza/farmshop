package org.dlegeza.farmshop.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthControllerTest extends BaseTest {

	@Test
	public void testHealth_Success() {
		// WHEN
		ResponseEntity<String> healthEntity = this.restTemplate.getForEntity("/health-check", String.class);

		// THEN
		assertEquals(HttpStatus.OK, healthEntity.getStatusCode());
		assertNotNull(healthEntity.getBody());
		assertEquals("Running", healthEntity.getBody());
	}

}
