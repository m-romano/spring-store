package com.mromanode.springstore.Category;

import java.util.Set;

public interface CategoryRepository {
    Set<Category> findByName(String name);
    Set<Category> findBySubCategoryName(String subCategoryName);
    Set<Category> findByProductName(String productName);
}
