package org.krejo.database;

import org.krejo.data.models.address.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<AddressEntity, Integer> {
}
