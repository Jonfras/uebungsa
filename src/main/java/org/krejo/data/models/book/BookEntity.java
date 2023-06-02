package org.krejo.data.models.book;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.models.library.LibraryEntity;

@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String isbn;
    @ManyToOne
    private LibraryEntity libraryEntity;
}
