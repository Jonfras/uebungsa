package org.krejo.data.models.address;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private int houseNumber;
    private int zipCode;
}
