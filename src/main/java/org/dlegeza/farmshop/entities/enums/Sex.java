package org.dlegeza.farmshop.entities.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sex {
	@JsonProperty("m") M,
	@JsonProperty("f") F
}
