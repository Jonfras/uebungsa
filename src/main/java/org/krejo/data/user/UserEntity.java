package org.krejo.data.user;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.product.Product;
import org.krejo.data.product.ProductEntity;

import java.util.List;
@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "id"
    )
    private List<ProductEntity> productList;
}
