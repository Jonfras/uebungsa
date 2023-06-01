package org.krejo.data.store;

import jakarta.persistence.*;
import lombok.Data;
import org.krejo.data.address.Address;
import org.krejo.data.address.AddressEntity;
import org.krejo.data.product.ProductEntity;

import java.util.List;

@Data
@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "id"
    )
    private List<ProductEntity> productEntityList;
}
