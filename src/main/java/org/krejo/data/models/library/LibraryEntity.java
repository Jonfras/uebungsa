package org.krejo.data.models.library;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.models.address.AddressEntity;
import org.krejo.data.models.book.BookEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "library")
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "libraryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookEntity> books = new ArrayList<>();
}
