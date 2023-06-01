package org.krejo.data;

import org.krejo.data.exception.ProductBadDTOException;
import org.krejo.data.exception.StoreBadDTOException;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductDTO;
import org.krejo.data.product.ProductEntity;
import org.krejo.data.store.StoreDTO;
import org.krejo.database.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductDataService {
    @Autowired
    ProductRepo productRepo;

    public ProductEntity convertProductToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        if(product.getId() != -1) {
            productEntity.setId(product.getId());
        }
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setManufacturer(product.getManufacturer());
        productEntity.setInventoryCount(product.getInventoryCount());
        return productEntity;
    }

    public List<Product> convertProductDTOListToProductList(List<ProductDTO> productDTOS) throws ProductBadDTOException {
        List<Product> productList = new ArrayList<>();
        for (ProductDTO p :
                productDTOS) {
            Product product = convertProductDTOToProduct(p);
        }
        return productList;
    }

    private Product convertProductDTOToProduct(ProductDTO productDTO) throws ProductBadDTOException {
        Product product = new Product();
        checkProductDTO(productDTO);

        product.setId(-1);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setManufacturer(productDTO.getManufacturer());
        product.setInventoryCount(productDTO.getInventoryCount());

        return product;
    }

    private void checkProductDTO(ProductDTO productDTO) throws ProductBadDTOException {
        if(isNullOrEmpty(productDTO.getName())) {
            throw new ProductBadDTOException("bad storeDTO");
        }
    }
    private boolean isNullOrEmpty(String string) {
        return string == null || string.equals("");
    }

    public List<Product> convertProductEntityListToProductList(List<ProductEntity> productEntityList) {

    }
}
