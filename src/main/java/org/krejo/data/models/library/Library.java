package org.krejo.data.models.library;

import lombok.Data;
import org.krejo.data.models.address.Address;
import org.krejo.data.models.book.Book;

import java.util.List;

@Data
public class Library {
    private int id;
    private String name;
    private Address address;
    List<Book> books;
}
