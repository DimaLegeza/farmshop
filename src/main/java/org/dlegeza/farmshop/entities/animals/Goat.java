package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.NoArgsConstructor;
import org.dlegeza.farmshop.entities.enums.Sex;

/**
 * 	Can be male/female
 * 	Cannot produce wool
 * 	Only female can produce milk
 * 	All female can produce 50 liters of milk
 */
@JacksonXmlRootElement(localName = Goat.ANIMAL_TYPE)
@NoArgsConstructor
public class Goat extends FarmAnimal {
	public static final String ANIMAL_TYPE = "goat";

	public Goat(
			@JacksonXmlProperty(localName = "name", isAttribute = true)
			String name,
			@JacksonXmlProperty(localName = "sex", isAttribute = true)
			Sex sex,
			@JacksonXmlProperty(localName = "wool", isAttribute = true)
			int wool) {
		super(name, sex, wool, Goat.ANIMAL_TYPE, Sex.F.equals(sex) ? 50 : 0);
	}

}
