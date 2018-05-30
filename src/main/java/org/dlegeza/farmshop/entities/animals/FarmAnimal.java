package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FarmAnimal {
	@JacksonXmlProperty(localName = "name", isAttribute = true)
	String name;
	@JacksonXmlProperty(localName = "sex", isAttribute = true)
	Sex sex;
	@JacksonXmlProperty(localName = "wool", isAttribute = true)
	private int wool;

	public int milkAmount() {
		return 0;
	}
}
