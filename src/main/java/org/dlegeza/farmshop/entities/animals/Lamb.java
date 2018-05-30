package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.NoArgsConstructor;
import org.dlegeza.farmshop.entities.enums.Sex;

/**
 * 	Can be male/female
 * 	Can produce wool
 * 	Cannot produce milk
 */
@JacksonXmlRootElement(localName = Lamb.ANIMAL_TYPE)
@NoArgsConstructor
public class Lamb extends FarmAnimal {
	public static final String ANIMAL_TYPE = "goat";

	public Lamb(
			@JacksonXmlProperty(localName = "name", isAttribute = true)
			String name,
			@JacksonXmlProperty(localName = "sex", isAttribute = true)
			Sex sex,
			@JacksonXmlProperty(localName = "wool", isAttribute = true)
			int wool) {
		super(name, sex, wool, Lamb.ANIMAL_TYPE, 0);
	}

}
