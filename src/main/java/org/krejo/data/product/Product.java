package org.krejo.data.product;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private String manifacturer;
    private double price;
    private int inventoryCount;
}
