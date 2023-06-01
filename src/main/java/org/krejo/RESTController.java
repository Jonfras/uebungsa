package org.krejo;

import org.krejo.data.AddressDataService;
import org.krejo.data.ProductDataService;
import org.krejo.data.StoreDataService;
import org.krejo.data.exception.ProductBadDTOException;
import org.krejo.data.exception.StoreBadDTOException;
import org.krejo.data.exception.StoreEntityNotFoundException;
import org.krejo.data.store.StoreDTO;
import org.krejo.data.store.StoreResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RESTController {
    @Autowired
    private StoreDataService storeDataService;
    @Autowired
    private AddressDataService addressDataService;
    @Autowired
    private ProductDataService productDataService;

    @GetMapping("/stores")
    public List<StoreResource> getAllStores() {
        return storeDataService.getStoreResources();
    }

    @GetMapping("/stores/{storeId}")
    public StoreResource getStore(
            @PathVariable int storeId
    ) throws StoreEntityNotFoundException {
        return storeDataService.getStoreResource(storeId);
    }

    @PostMapping("/stores")
    public StoreResource addStore(
            @RequestBody StoreDTO storeDTO
            ) throws StoreBadDTOException, ProductBadDTOException {
        return storeDataService.addStore(storeDTO);
    }

    @PutMapping("/stores/{storeId}")
    public StoreResource editStore(
            @PathVariable int storeId,
            @RequestBody StoreDTO storeDTO
    ) {
        return storeDataService.editStore(storeId, storeDTO);
    }
}
