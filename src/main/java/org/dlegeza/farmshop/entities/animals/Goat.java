package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.NoArgsConstructor;

/**
 * 	Can be male/female
 * 	Cannot produce wool
 * 	Only female can produce milk
 * 	All female can produce 50 liters of milk
 */
@JacksonXmlRootElement(localName = "goat")
@NoArgsConstructor
public class Goat extends FarmAnimal {

	public Goat(String name, Sex sex, int wool) {
		super(name, sex, wool);
	}

	public int milkAmount() {
		return Sex.F.equals(this.sex) ? 50 : 0;
	}

}
