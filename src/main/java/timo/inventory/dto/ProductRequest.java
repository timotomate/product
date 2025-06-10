package timo.inventory.dto;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String name;
    private Integer price;
    private Integer stock;
}
