package org.ecommerce.order.dao.repository;

import org.ecommerce.order.dao.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
