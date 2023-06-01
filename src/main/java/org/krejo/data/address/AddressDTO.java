package org.krejo.data.address;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private int houseNumber;
    private int zipCode;
}
