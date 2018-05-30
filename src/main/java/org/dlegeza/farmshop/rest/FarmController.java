package org.dlegeza.farmshop.rest;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.dlegeza.farmshop.dto.FarmDTO;
import org.dlegeza.farmshop.entities.Farm;
import org.dlegeza.farmshop.services.FarmService;
import org.dlegeza.farmshop.services.ReconfigurationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("farmshop")
@RequiredArgsConstructor
public class FarmController {
	private final FarmService farmService;
	private final ReconfigurationService reconfigurationService;

	@GetMapping("flock")
	@ApiOperation(
		value = "Get information about farm and animals"
	)
	public FarmDTO getFarmInfo() {
		return this.farmService.getFarm();
	}

	@PutMapping("flock")
	@ApiOperation(
		value = "Re-initialize farm"
	)
	public FarmDTO setNewModel(@RequestBody Farm farm) {
		this.reconfigurationService.constructNewFarm(farm);
		return this.farmService.getFarm();
	}
}
