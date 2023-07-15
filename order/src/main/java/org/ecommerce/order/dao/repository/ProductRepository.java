package org.ecommerce.order.dao.repository;

import org.ecommerce.order.dao.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByCode(String code);

    @Query("UPDATE Product set quantite=quantite+:quantity where code=:code and quantite>=:quantity")
    int updateQuantity(String code, int quantity);
}
