package org.dlegeza.farmshop.rest;

import org.dlegeza.farmshop.entities.Stock;
import org.dlegeza.farmshop.services.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("farmshop")
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;

	@GetMapping("stock")
	@ApiOperation(
		value = "Get information about currently available stocks"
	)
	public Stock getStockInfo() {
		return this.stockService.getStock();
	}
}
