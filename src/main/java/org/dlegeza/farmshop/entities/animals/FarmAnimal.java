package org.dlegeza.farmshop.entities.animals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.dlegeza.farmshop.entities.enums.Sex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
		property = "type",
		visible = true)
@JsonSubTypes({
		@JsonSubTypes.Type(name = "sheep", value = Sheep.class),
		@JsonSubTypes.Type(name = "lamb", value = Lamb.class),
		@JsonSubTypes.Type(name = "goat", value = Goat.class)
})
public class FarmAnimal {
	private String name;
	private Sex sex;
	private int wool;
	private String type;

	@JsonIgnore
	private int milk;
}
