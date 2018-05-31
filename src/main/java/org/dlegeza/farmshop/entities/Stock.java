package org.dlegeza.farmshop.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Stock {
	private int milk;
	private int wool;
}
