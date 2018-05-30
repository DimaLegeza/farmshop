package org.dlegeza.farmshop.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.dlegeza.farmshop.dto.OrderDTO;
import org.dlegeza.farmshop.entities.Stock;
import org.dlegeza.farmshop.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("farmshop")
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;

	@GetMapping("stock")
	@ApiOperation(
		value = "Current status on stocks availability"
	)
	public Stock getStockInfo() {
		return this.stockService.getStock();
	}

	@PostMapping("order")
	@ApiOperation(
			value = "Make and order for amount of milk and wool"
	)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Order was successfully processed"),
			@ApiResponse(code = 422, message = "Could not process order - insufficient amount of resources")
	})
	public ResponseEntity<OrderDTO> order(@RequestBody OrderDTO order) {
		OrderDTO processedOrder = this.stockService.processOrder(order);
		HttpStatus status = processedOrder != null ? HttpStatus.ACCEPTED : HttpStatus.UNPROCESSABLE_ENTITY;
		return ResponseEntity
				.status(status)
				.body(order);
	}
}
