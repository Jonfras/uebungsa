package org.krejo.data.models.library;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.krejo.data.models.address.Address;
import org.krejo.data.models.book.Book;
import org.krejo.data.models.book.BookResource;

import java.util.List;
@Data
public class LibraryResource {
    private int id;
    private String name;
    private String street;
    private int houseNumber;
    private int zipCode;
    List<BookResource> books;
}
