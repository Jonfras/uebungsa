package org.krejo.data.services;

import org.krejo.data.models.address.Address;
import org.krejo.data.models.address.AddressDTO;
import org.krejo.data.models.address.AddressEntity;

public class AddressDataService {
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
        addressEntity.setId(null);
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
