package org.krejo.data.address;

import lombok.Data;

@Data
public class Address {
    private long id;
    private String street;
    private int houseNumber;
    private int zipCode;
}
