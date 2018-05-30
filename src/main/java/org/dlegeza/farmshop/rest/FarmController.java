package org.dlegeza.farmshop.rest;

import org.dlegeza.farmshop.dto.FarmDTO;
import org.dlegeza.farmshop.services.FarmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("farmshop")
@RequiredArgsConstructor
public class FarmController {
	private final FarmService farmService;

	@GetMapping("flock")
	@ApiOperation(
		value = "Get whole information about farm"
	)
	public FarmDTO getFarmInfo() {
		return this.farmService.getFarm();
	}
}
