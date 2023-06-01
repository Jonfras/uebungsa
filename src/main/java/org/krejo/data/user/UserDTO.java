package org.krejo.data.user;

import lombok.Data;
import org.krejo.data.product.Product;

import java.util.List;
@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private List<Product> productList;
}
