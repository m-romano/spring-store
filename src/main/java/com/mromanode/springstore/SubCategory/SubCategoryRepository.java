package com.mromanode.springstore.SubCategory;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID> {
    Optional<SubCategory> getSubCategoryById(UUID uuid);
    Set<SubCategory> findSubCategoryByName(String name);
    Set<SubCategory> findSubCategoryByDescription(String description);
    Set<Category> findCategoryName(String name);
    Optional<Category> findCategoryId(UUID id);
    Set<Product> findProductName(String name);
    Optional<Product> findProductId(UUID id);
}

