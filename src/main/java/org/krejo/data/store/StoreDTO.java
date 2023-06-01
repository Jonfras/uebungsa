package org.krejo.data.store;

import lombok.Data;
import org.krejo.data.address.Address;
import org.krejo.data.address.AddressDTO;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductDTO;

import java.util.List;
@Data
public class StoreDTO {
    private String name;
    private AddressDTO address;
    private List<ProductDTO> productList;
}
