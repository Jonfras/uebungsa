package org.krejo.data;

import org.krejo.data.address.Address;
import org.krejo.data.address.AddressEntity;
import org.krejo.data.store.Store;
import org.krejo.data.store.StoreEntity;
import org.krejo.data.store.StoreResource;
import org.krejo.database.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StoreDataService {
    List<Store> storeList = new ArrayList<>();
    @Autowired
    AddressDataService addressDataService;
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
        return store;
    }


}
