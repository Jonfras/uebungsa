package org.krejo.data.product;

import lombok.Data;

@Data
public class ProductResource {
    private long id;
    private String name;
    private String manifacturer;
    private double price;
    private int inventoryCount;
}
