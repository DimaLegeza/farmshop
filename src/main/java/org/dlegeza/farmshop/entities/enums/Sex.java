package org.dlegeza.farmshop.entities.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sex {
	@JsonProperty("m")
	M("m"),
	@JsonProperty("f")
	F("f");

	private String value;

	public static Sex ofValue(String value) {
		for (Sex sex: Sex.values()) {
			if (value.equalsIgnoreCase(sex.value)) {
				return sex;
			}
		}
		return null;
	}
}
