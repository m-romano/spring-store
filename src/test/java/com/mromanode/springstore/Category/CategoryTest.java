package com.mromanode.springstore.Category;

import com.mromanode.springstore.SubCategory.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CategoryTest {

    private Set<Category> categories;
    private Set<SubCategory> subCategories;

    @BeforeEach
    void setUp() {
        categories = new HashSet<>();

        Category firstCategory = new Category();
        firstCategory.setName("Electronics");
        firstCategory.setDescription("Bep Bop");

        Category secondCategory = new Category();
        secondCategory.setName("Clothes");
        secondCategory.setDescription("Dresses and More");

        categories.add(firstCategory);
        categories.add(secondCategory);

        subCategories = new HashSet<>();
        SubCategory firstSubCategory = new SubCategory();
        firstSubCategory.setName("Camera & Accessories");
        firstSubCategory.setDescription("Welcome to our Camera and Accessories section.");

        SubCategory secondSubCategory = new SubCategory();
        secondSubCategory.setName("Clothes & Dress");
        secondSubCategory.setDescription("Welcome to our Clothing and Dress section.");

        subCategories.add(firstSubCategory);
        subCategories.add(secondSubCategory);
    }

    @Test
    void testCategoryCreation() {
        assertEquals(2, categories.size());
    }

    @Test
    void testSubCategoryCreation() {
        assertEquals(2, subCategories.size());
    }

    @Test
    void testFirstCategoryDetails() {
        Category category = categories.stream().filter(c -> c.getName().equals("Electronics")).findFirst().orElse(null);
        assertNotNull(category);
        assertEquals("Bep Bop", category.getDescription());
    }

    @Test
    void testSecondCategoryDetails() {
        Category category = categories.stream().filter(c -> c.getName().equals("Clothes")).findFirst().orElse(null);
        assertNotNull(category);
        assertEquals("Dresses and More", category.getDescription());
    }

    @Test
    void testFirstSubCategoryDetails() {
        SubCategory subCategory = subCategories.stream().filter(sc -> sc.getName().equals("Camera & Accessories")).findFirst().orElse(null);
        assertNotNull(subCategory);
        assertEquals("Welcome to our Camera and Accessories section.", subCategory.getDescription());
    }

    @Test
    void testSecondSubCategoryDetails() {
        SubCategory subCategory = subCategories.stream().filter(sc -> sc.getName().equals("Clothes & Dress")).findFirst().orElse(null);
        assertNotNull(subCategory);
        assertEquals("Welcome to our Clothing and Dress section.", subCategory.getDescription());
    }
}
