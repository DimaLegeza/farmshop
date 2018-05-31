package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.NoArgsConstructor;

/**
 *  Can be male/female
 * 	Can produce wool
 * 	Only female can produce milk
 * 	All female can produce 30 liters of milk
 */
@JacksonXmlRootElement(localName = Sheep.ANIMAL_TYPE)
@NoArgsConstructor
public class Sheep extends FarmAnimal {
	static final String ANIMAL_TYPE = "sheep";

	public Sheep(
			@JacksonXmlProperty(localName = "name", isAttribute = true)
			@JsonProperty("name")
			String name,
			@JacksonXmlProperty(localName = "sex", isAttribute = true)
			@JsonProperty("sex")
			Sex sex,
			@JacksonXmlProperty(localName = "wool", isAttribute = true)
			@JsonProperty("wool")
			int wool) {
		super(name, sex, wool, Sheep.ANIMAL_TYPE, Sex.F.equals(sex) ? 30 : 0);
	}

}
