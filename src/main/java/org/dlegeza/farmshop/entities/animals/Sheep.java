package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.dlegeza.farmshop.entities.enums.Sex;

/**
 *  Can be male/female
 * 	Can produce wool
 * 	Only female can produce milk
 * 	All female can produce 30 liters of milk
 */
@JacksonXmlRootElement(localName = "sheep")
public class Sheep extends FarmAnimal {

	public Sheep(String name, Sex sex, int wool) {
		super(name, sex, wool);
	}

	public int milkAmount() {
		return Sex.F.equals(this.sex) ? 30 : 0;
	}

}
