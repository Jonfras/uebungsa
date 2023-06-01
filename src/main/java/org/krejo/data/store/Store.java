package org.krejo.data.store;

import lombok.Data;
import org.krejo.data.address.Address;
import org.krejo.data.product.Product;

import java.util.List;
@Data
public class Store {
    private long id;
    private String name;
    private Address address;
    private List<Product> productList;
}
