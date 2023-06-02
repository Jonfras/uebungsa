package org.krejo.data.models.user;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.models.book.BookEntity;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<BookEntity> borrowedBooks;

}
