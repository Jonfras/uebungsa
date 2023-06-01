package org.krejo.data;

import org.krejo.data.exception.ProductBadDTOException;
import org.krejo.data.exception.StoreBadDTOException;
import org.krejo.data.exception.StoreEntityNotFoundException;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductEntity;
import org.krejo.data.store.Store;
import org.krejo.data.store.StoreDTO;
import org.krejo.data.store.StoreEntity;
import org.krejo.data.store.StoreResource;
import org.krejo.database.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoreDataService {
    List<Store> storeList = new ArrayList<>();
    @Autowired
    AddressDataService addressDataService;
    @Autowired
    ProductDataService productDataService;
    @Autowired
    private StoreRepo storeRepo;

    public List<StoreResource> getStoreResources() {
        List<StoreResource> result = new ArrayList<>();
        for (StoreEntity storeEntity : storeRepo.findAll()) {
            StoreResource storeResource =
                    convertStoreToStoreResource(convertStoreEntityToStore(storeEntity));
            result.add(storeResource);
        }
        return result;
    }

    private StoreResource convertStoreToStoreResource(Store store) {
        StoreResource storeResource = new StoreResource();
        storeResource.setName(store.getName());
        storeResource.setStreet(store.getAddress().getStreet());
        storeResource.setProductList(store.getProductList());
        storeResource.setId(store.getId());
        storeResource.setHouseNumber(store.getAddress().getHouseNumber());
        storeResource.setZipCode(store.getAddress().getZipCode());
        return storeResource;
    }

    private Store convertStoreEntityToStore(StoreEntity storeEntity) {
        Store store = new Store();

        store.setId(storeEntity.getId());
        store.setName(storeEntity.getName());
        store.setAddress(addressDataService.convertAddressEntityToAddress(storeEntity.getAddress()));
        store.setProductList(productDataService.convertProductEntityListToProductList(storeEntity.getProductEntityList()));

        return store;
    }


    public StoreResource getStoreResource(int storeId) throws StoreEntityNotFoundException {
        Optional<StoreEntity> storeEntity = storeRepo.findById(storeId);
        if (!storeEntity.isPresent()) {
            throw new StoreEntityNotFoundException(String.format("The store with the id " + storeId + " does not exist!"));
        }
        return convertStoreToStoreResource(convertStoreEntityToStore(storeEntity.get()));
    }

    public StoreResource addStore(StoreDTO storeDTO) throws StoreBadDTOException, ProductBadDTOException {
        StoreResource storeResource = new StoreResource();
        checkStoreDTO(storeDTO);
        storeResource.setId(-1);
        storeResource.setName(storeDTO.getName());
        storeResource.setStreet(storeDTO.getAddress().getStreet());
        storeResource.setHouseNumber(storeDTO.getAddress().getHouseNumber());
        storeResource.setZipCode(storeDTO.getAddress().getZipCode());
        storeResource.setProductList(productDataService.convertProductListToProductResourceList(productDataService.convertProductDTOListToProductList(storeDTO.getProductList())));

        StoreEntity storeEntity = this.storeRepo.save(convertStoreToStoreEntity(storeResource));
        return convertStoreToStoreResource(convertStoreEntityToStore(storeEntity));
    }

    private StoreEntity convertStoreToStoreEntity(Store newStore) {
        StoreEntity storeEntity = new StoreEntity();
        if(newStore.getId() != -1) {
            storeEntity.setId(newStore.getId());
        }
        storeEntity.setName(newStore.getName());
        storeEntity.setAddress(addressDataService.convertAddressToAddressEntity(newStore.getAddress()));
        storeEntity.setId(newStore.getId());

        List<ProductEntity> productEntities = new ArrayList<>();
        for (Product p :
                newStore.getProductList()) {
            productEntities.add(productDataService.convertProductToProductEntity(p));
        }
        storeEntity.setProductEntityList(productEntities);
        return storeEntity;
    }

    private void checkStoreDTO(StoreDTO storeDTO) throws StoreBadDTOException {
        if(isNullOrEmpty(storeDTO.getName())) {
            throw new StoreBadDTOException("bad storeDTO");
        }
        if(isNullOrEmpty(storeDTO.getAddress().getStreet())) {
            throw new StoreBadDTOException("bad storeDTO");
        }
        if(isNullOrEmpty(storeDTO.getProductList().get(0).getName())) {
            throw new StoreBadDTOException("bad storeDTO");
        }
    }
    private boolean isNullOrEmpty(String string) {
        return string == null || string.equals("");
    }

    public StoreResource editStore(int storeId, StoreDTO storeDTO) throws StoreBadDTOException {
        StoreResource storeResource = new StoreResource();
        checkStoreDTO(storeDTO);
        storeResource.setId(storeId);
        storeResource.setName(storeResource.getName());
        storeResource.setStreet(storeDTO.getAddress().getStreet());
        storeResource.setHouseNumber(storeDTO.getAddress().getHouseNumber());
        storeResource.setZipCode(storeDTO.getAddress().getZipCode());
        storeResource.setProductList(storeDTO.getProductList());
    }
}






























