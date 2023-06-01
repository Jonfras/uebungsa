package org.krejo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.krejo.data.address.Address;
import org.krejo.data.address.AddressDTO;
import org.krejo.data.product.ProductDTO;
import org.krejo.data.store.Store;
import org.krejo.data.store.StoreDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        AddressDTO address = new AddressDTO();
        address.setZipCode(1234);
        address.setStreet("hello");
        address.setHouseNumber(5678);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("foo");
        productDTO.setPrice(811.2);
        productDTO.setManufacturer("bar");
        productDTO.setInventoryCount(911);
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setAddress(address);
        storeDTO.setName("world");
        List<ProductDTO> productDTOS = new ArrayList<>();
        productDTOS.add(productDTO);
        storeDTO.setProductList(productDTOS);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.valueToTree(storeDTO));
        SpringApplication.run(Main.class, args);
    }
}