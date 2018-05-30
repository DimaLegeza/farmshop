package org.dlegeza.farmshop.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Stock {
	private int milk;
	private int wool;
}
