package org.krejo.data.user;

import lombok.Data;
import org.krejo.data.product.Product;

import java.util.List;

@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private List<Product> productList;
}
