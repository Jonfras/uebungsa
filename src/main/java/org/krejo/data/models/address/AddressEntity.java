package org.krejo.data.models.address;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.models.library.LibraryEntity;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private int houseNumber;
    private int zipCode;

}
