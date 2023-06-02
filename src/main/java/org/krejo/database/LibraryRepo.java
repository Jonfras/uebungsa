package org.krejo.database;

import org.krejo.data.models.library.LibraryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepo extends CrudRepository<LibraryEntity, Integer> {
}
