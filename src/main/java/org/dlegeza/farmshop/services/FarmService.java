package org.dlegeza.farmshop.services;

import org.dlegeza.farmshop.dto.FarmDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
	private Farm farm;

	public void setFarm(final Farm farm) {
		this.farm = farm;
	}

	public FarmDTO getFarm() {
		return new FarmDTO()
			.reset()
			.addAll(this.farm.getGoat())
			.addAll(this.farm.getLamb())
			.addAll(this.farm.getSheep());
	}
}
