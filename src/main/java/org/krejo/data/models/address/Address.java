package org.krejo.data.models.address;

import lombok.Data;

@Data
public class Address {
    private int id;
    private String street;
    private int houseNumber;
    private int zipCode;
}
