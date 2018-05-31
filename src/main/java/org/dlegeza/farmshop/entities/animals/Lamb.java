package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.NoArgsConstructor;

/**
 * 	Can be male/female
 * 	Can produce wool
 * 	Cannot produce milk
 */
@JacksonXmlRootElement(localName = Lamb.ANIMAL_TYPE)
@NoArgsConstructor
public class Lamb extends FarmAnimal {
	static final String ANIMAL_TYPE = "goat";

	public Lamb(
			@JacksonXmlProperty(localName = "name", isAttribute = true)
			@JsonProperty("name")
			String name,
			@JacksonXmlProperty(localName = "sex", isAttribute = true)
			@JsonProperty("sex")
			Sex sex,
			@JacksonXmlProperty(localName = "wool", isAttribute = true)
			@JsonProperty("wool")
			int wool) {
		super(name, sex, wool, Lamb.ANIMAL_TYPE, 0);
	}

}
