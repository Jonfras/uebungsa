package org.krejo.database;

import org.krejo.data.models.book.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Integer> {
}
