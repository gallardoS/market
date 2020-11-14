package com.swamigallardo.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long productId;
    private String name;
    private Long categoryId;
    private Double price;
    private int stock;
    private boolean active;
    private Category category;
}
