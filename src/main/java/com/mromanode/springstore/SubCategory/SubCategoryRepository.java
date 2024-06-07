package com.mromanode.springstore.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID> {
    Set<SubCategory> findByName(String name);
    Set<SubCategory> findByCategoryName(String categoryName);
    Set<SubCategory> findByCategoryId(UUID categoryId);
}
