package org.dlegeza.farmshop.services;

import org.dlegeza.farmshop.dto.FarmDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service that segregates operations with farm object {@link Farm}
 * Provides public access to dto representation of farm = {@link FarmDTO}
 * Modificator methods are package-visible
 */
@Service
public class FarmService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FarmService.class);
	private Farm farm;
	private FarmDTO farmDTO;

	/**
	 * re-initializes current farm {@link Farm} and farmDto {@link FarmDTO} objects
	 * limited to package access and used in {@link ReconfigurationService}
	 * @param farm
	 */
	void setFarm(final Farm farm) {
		this.farm = farm;
		this.farmDTO = new FarmDTO()
				.reset()
				.addAll(this.farm.getGoat())
				.addAll(this.farm.getLamb())
				.addAll(this.farm.getSheep());
		LOGGER.info("New farm instance was initialized");
	}

	public FarmDTO getFarm() {
		return this.farmDTO;
	}
}
