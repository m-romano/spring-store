package com.mromanode.springstore.Product;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.SubCategory.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Set<Product> findByName(String name);
    Set<Product> findByPrice(BigDecimal price);
    Set<Product> findByModelNumber(String modelNumber);

}
