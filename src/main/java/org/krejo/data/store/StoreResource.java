package org.krejo.data.store;

import lombok.Data;
import org.krejo.data.address.Address;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductResource;

import java.util.List;
@Data
public class StoreResource {
    private long id;
    private String name;
    private String street;
    private int houseNumber;
    private int zipCode;
    private List<ProductResource> productList;
}
