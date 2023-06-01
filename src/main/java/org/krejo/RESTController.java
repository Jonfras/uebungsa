package org.krejo;

import org.krejo.data.AddressDataService;
import org.krejo.data.StoreDataService;
import org.krejo.data.store.StoreResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RESTController {
    @Autowired
    private StoreDataService storeDataService;
    @Autowired
    private AddressDataService addressDataService;

    @GetMapping("/stores")
    public List<StoreResource> getAllStores() {
        return storeDataService.getStoreResources();
    }

    @
}
