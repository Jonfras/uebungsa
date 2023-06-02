package org.krejo.data.models.book;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String isbn;
}
