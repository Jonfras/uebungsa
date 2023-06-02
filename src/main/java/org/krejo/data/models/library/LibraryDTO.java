package org.krejo.data.models.library;

import lombok.Data;
import org.krejo.data.models.address.Address;
import org.krejo.data.models.address.AddressDTO;
import org.krejo.data.models.book.Book;

import java.util.List;

@Data
public class LibraryDTO {
    private String name;
    private AddressDTO address;

}
