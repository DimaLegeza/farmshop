package org.dlegeza.farmshop.dto;

import java.util.ArrayList;
import java.util.List;

import org.dlegeza.farmshop.entities.animals.FarmAnimal;

import lombok.Getter;

@Getter
public class FarmDTO {
	private List<FarmAnimal> flock;

	public FarmDTO reset() {
		this.flock = new ArrayList<>();
		return this;
	}

	public FarmDTO addAll(List<FarmAnimal> animal) {
		if (this.flock == null) {
			this.flock = new ArrayList<>();
		}
		this.flock.addAll(animal);
		return this;
	}
}
