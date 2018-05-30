package org.dlegeza.farmshop.services;

import org.dlegeza.farmshop.entities.Stock;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockService {
	private Stock stock;
	private final FarmService farmService;

	public void defineStock() {
		int milkAvailable = this.farmService.getFarm().getFlock().stream().mapToInt(FarmAnimal::milkAmount).sum();
		int woolAvailable = this.farmService.getFarm().getFlock().stream().mapToInt(FarmAnimal::getWool).sum();

		this.stock = Stock.builder().milk(milkAvailable).wool(woolAvailable).build();
	}

	public Stock getStock() {
		return this.stock;
	}
}
