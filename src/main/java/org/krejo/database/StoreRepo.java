package org.krejo.database;

import org.krejo.data.store.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepo extends CrudRepository<StoreEntity, Integer> {
}
