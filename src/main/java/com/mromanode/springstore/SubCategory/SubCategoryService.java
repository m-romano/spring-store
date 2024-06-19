package com.mromanode.springstore.SubCategory;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.Product.Product;
import com.mromanode.springstore.SpringstoreApplication;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class SubCategoryService {

    private static final Logger logger = LogManager.getLogger(SpringstoreApplication.class);
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public Optional<SubCategory> getSubCategoryById(UUID id) {
        logger.info("Invoked method: get subcategory by ID: {}", id);
        Optional<SubCategory> subCategory = subCategoryRepository.getSubCategoryById(id);
        logger.info("Found subcategory by ID: {}", id);
        return subCategory;
    }

    public Set<SubCategory> findSubCategoryByName(String name) {
        logger.info("Invoked method: get subcategory by name: {}", name);
        Set<SubCategory> subCategories = subCategoryRepository.findSubCategoryByName(name);
        logger.info("Found subcategory by name: {}", name);
        return subCategories;
    }

    public Set<SubCategory> findSubCategoryByDescription(String description) {
        logger.info("Invoked method: get subcategory by description: {}", description);
        Set<SubCategory> subCategories = subCategoryRepository.findSubCategoryByDescription(description);
        logger.info("Found subcategory by description: {}", description);
        return subCategories;
    }

    public Set<Category> findCategoryName(String name) {
        logger.info("Invoked method: get category by name: {}", name);
        Set<Category> categories = subCategoryRepository.findCategoryName(name);
        logger.info("Found category by name: {}", name);
        return categories;
    }

    public Optional<Category> findCategoryId(UUID id) {
        logger.info("Invoked method: get category by ID: {}", id);
        Optional<Category> category = subCategoryRepository.findCategoryId(id);
        logger.info("Found category by ID: {}", id);
        return category;
    }

    public Set<Product> findProductName(String name) {
        logger.info("Invoked method: get product by name: {}", name);
        Set<Product> products = subCategoryRepository.findProductName(name);
        logger.info("Found product by name: {}", name);
        return products;
    }

    public Optional<Product> findProductId(UUID id) {
        logger.info("Invoked method: get product by ID: {}", id);
        Optional<Product> product = subCategoryRepository.findProductId(id);
        logger.info("Found product by ID: {}", id);
        return product;
    }

    public SubCategory save(SubCategory subCategory) {
        logger.info("Invoked method: save subcategory: {}", subCategory);
        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        logger.info("Saved subcategory with ID: {}", savedSubCategory.getId());
        return savedSubCategory;
    }

    public void delete(UUID id) {
        logger.info("Invoked method: delete subcategory by ID {}", id);
        subCategoryRepository.deleteById(id);
        logger.info("Deleted subcategory: by ID: {}", id);
    }
}