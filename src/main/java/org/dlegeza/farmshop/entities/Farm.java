package org.dlegeza.farmshop.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

import org.dlegeza.farmshop.entities.animals.FarmAnimal;

import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "flock")
@Setter
@Getter
public class Farm {
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<FarmAnimal> goat;
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<FarmAnimal> lamb;
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<FarmAnimal> sheep;
}
