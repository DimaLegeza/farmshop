package org.dlegeza.farmshop.services;

import lombok.RequiredArgsConstructor;
import org.dlegeza.farmshop.dto.OrderDTO;
import org.dlegeza.farmshop.dto.OrderDetailsDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.entities.Stock;
import org.dlegeza.farmshop.entities.animals.FarmAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);
	private Stock stock;
	private final FarmService farmService;

	/**
	 * re-configure current stock on basis of new {@link Farm}
	 * limited to package access and is used within {@link ReconfigurationService}
	 */
	void defineStock() {
		int milkAvailable = this.farmService.getFarm().getFlock().stream().mapToInt(FarmAnimal::getMilk).sum();
		int woolAvailable = this.farmService.getFarm().getFlock().stream().mapToInt(FarmAnimal::getWool).sum();

		this.stock = this.stockBuilder(milkAvailable, woolAvailable);
		LOGGER.info("stock was re-initialized with milk : {} and wool : {}", milkAvailable, woolAvailable);
	}

	/**
	 * @return {@link Stock} - current state of stock
	 */
	public Stock getStock() {
		return this.stock;
	}

	/**
	 *
	 * @param details - order details of the customer {@link OrderDetailsDTO}
	 * @return boolean value that represents if amount of wool and milk is enough to process the request
	 */
	public boolean isEnoughInStock(OrderDetailsDTO details) {
		return this.stock.getMilk() >= details.getMilk() && this.stock.getWool() >= details.getWool();
	}

	/**
	 * In case of sufficient amount of resources order is processed and stock amounts decreased
	 * @param order - order details of the customer {@link OrderDTO}
	 */
	public OrderDTO processOrder(OrderDTO order) {
		if (!this.isEnoughInStock(order.getOrder())) {
			LOGGER.error("order rejected: {}", order);
			return null;
		}
		this.stock = this.stockBuilder(
				this.stock.getMilk() - order.getOrder().getMilk(),
				this.stock.getWool() - order.getOrder().getWool()
		);
		LOGGER.warn("order processed: {}", order);
		return order;
	}

	private Stock stockBuilder(int milk, int wool) {
		return Stock.builder().milk(milk).wool(wool).build();
	}
}
