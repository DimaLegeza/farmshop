package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.NoArgsConstructor;

/**
 * 	Can be male/female
 * 	Can produce wool
 * 	Cannot produce milk
 */
@JacksonXmlRootElement(localName = "lamb")
@NoArgsConstructor
public class Lamb extends FarmAnimal {

	public Lamb(String name, Sex sex, int wool) {
		super(name, sex, wool);
	}

}
