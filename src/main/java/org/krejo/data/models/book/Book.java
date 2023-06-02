package org.krejo.data.models.book;

import lombok.Data;
import org.krejo.data.models.library.Library;

@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String isbn;
    private Library library;
}
