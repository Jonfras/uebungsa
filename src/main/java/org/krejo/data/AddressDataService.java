package org.krejo.data;

import org.krejo.data.address.Address;
import org.krejo.data.address.AddressEntity;
import org.krejo.database.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AddressDataService {
    List<Address> addressList = new ArrayList<>();
    @Autowired
    AddressRepo addressRepo;

    public Address convertAddressEntityToAddress(AddressEntity addressEntity) {
        Address address = new Address();
        address.setHouseNumber(addressEntity.getHouseNumber());
        address.setId(addressEntity.getId());
        address.setStreet(addressEntity.getStreet());
        address.setZipCode(addressEntity.getZipCode());
        return address;
    }
}
