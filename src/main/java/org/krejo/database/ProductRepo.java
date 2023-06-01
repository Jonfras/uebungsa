package org.krejo.database;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.krejo.data.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Integer> {
}
