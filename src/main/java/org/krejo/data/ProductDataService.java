package org.krejo.data;

import org.krejo.data.exception.ProductBadDTOException;
import org.krejo.data.exception.StoreBadDTOException;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductDTO;
import org.krejo.data.product.ProductEntity;
import org.krejo.data.product.ProductResource;
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
            productList.add(convertProductDTOToProduct(p));
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
        List<Product> productList = new ArrayList<>();

        for (ProductEntity productEntity :
                productEntityList) {
            Product product = convertProductEntityToProduct(productEntity);
            productList.add(product);
        }
        return productList;
    }

    private Product convertProductEntityToProduct(ProductEntity productEntity) {
        Product product = new Product();

        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setManufacturer(productEntity.getManufacturer());
        product.setInventoryCount(productEntity.getInventoryCount());

        return product;
    }


    public List<ProductResource> convertProductListToProductResourceList(List<Product> products) {
        List<ProductResource> productResourceList = new ArrayList<>();

        for (Product product :
                products) {
            productResourceList.add(convertProductToProductResource(product));
        }
        return productResourceList;
    }

    private ProductResource convertProductToProductResource(Product product) {
        ProductResource productResource = new ProductResource();

        productResource.setId(product.getId());
        productResource.setName(product.getName());
        productResource.setPrice(product.getPrice());
        productResource.setManufacturer(product.getManufacturer());
        productResource.setInventoryCount(product.getInventoryCount());

        return productResource;
    }
}
