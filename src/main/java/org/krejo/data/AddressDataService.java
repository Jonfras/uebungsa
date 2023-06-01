package org.krejo.data;

import org.krejo.data.address.Address;
import org.krejo.data.address.AddressDTO;
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

    public AddressEntity convertAddressToAddressEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        if(address.getId() != -1) {
            addressEntity.setId(address.getId());
        }
        addressEntity.setHouseNumber(address.getHouseNumber());
        addressEntity.setId(address.getId());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setZipCode(address.getZipCode());
        return addressEntity;
    }

    public Address convertAddressDTOToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setHouseNumber(addressDTO.getHouseNumber());
        address.setId(-1);
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());
        return address;
    }
}
