package org.dlegeza.farmshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private String customer;
    private OrderDetailsDTO order;
}
