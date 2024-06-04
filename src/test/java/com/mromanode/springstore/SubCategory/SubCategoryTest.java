package com.mromanode.springstore.SubCategory;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.Product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubCategoryTest {

    private Set<SubCategory> subCategories;
    private Set<Category> categories;
    private Set<Product> products;
    private UUID subCategoryId;

    @BeforeEach
    void setUp() {
        subCategoryId = UUID.randomUUID();

        categories = new HashSet<>();

        Category electronics = new Category();
        electronics.setName("Electronics");
        electronics.setDescription("Mobile and stuff");

        categories.add(electronics);

        subCategories = new HashSet<>();
        SubCategory firstSubCategory = new SubCategory();
        firstSubCategory.setName("Gadgets");
        firstSubCategory.setDescription("For your geekery.");

        SubCategory secondSubCategory = new SubCategory();
        secondSubCategory.setName("Home Appliances");
        secondSubCategory.setDescription("Never make a coffee for yourself again.");

        subCategories.add(firstSubCategory);
        subCategories.add(secondSubCategory);

        products = new HashSet<>();
        Product firstProduct = new Product();
        firstProduct.setId(UUID.randomUUID());
        firstProduct.setName("Sirius Cybernetics AI Humanoid");
        firstProduct.setDescription("AI humanoid by OpenAI.");
        firstProduct.setPrice(new BigDecimal("999.99"));
        firstProduct.setDimensions("0.89 x 7.08 x 15.05 cm");
        firstProduct.setItemWeight("187 g");
        firstProduct.setModelNumber("GA04803-GB");
        firstProduct.setImageUrl("https://upload.example.com/gameboy-advance-purple.png");

        Product secondProduct = new Product();
        secondProduct.setId(UUID.randomUUID());
        secondProduct.setName("Super Smart Vacuum");
        secondProduct.setDescription("Smart vacuum cleaner by OpenAI.");
        secondProduct.setPrice(new BigDecimal("499.99"));
        secondProduct.setDimensions("30 x 30 x 10 cm");
        secondProduct.setItemWeight("3.5 kg");
        secondProduct.setModelNumber("SV001");
        secondProduct.setImageUrl("https://upload.example.com/robot-vacuum-cleaner.png");


        products.add(firstProduct);
        products.add(secondProduct);
    }

    @Test
    void testSubCategoryCreation() {
        assertNotNull(subCategoryId);
        assertEquals(2, subCategories.size());
    }

    @Test
    void testProductCreation() {
        assertEquals(2, products.size());
    }

    @Test
    void testCategoryCreation() {
        assertEquals(1, categories.size());
        Category category = categories.iterator().next();
        assertEquals("Electronics", category.getName());
        assertEquals("Mobile and stuff", category.getDescription());
    }

    @Test
    void testFirstProductDetails() {
        Product product = products.stream().filter(p -> p.getName().equals("Sirius Cybernetics AI Humanoid")).findFirst().orElse(null);
        assertNotNull(product);
        assertEquals("AI humanoid by OpenAI.", product.getDescription());
        assertEquals(new BigDecimal("999.99"), product.getPrice());
        assertEquals("0.89 x 7.08 x 15.05 cm", product.getDimensions());
        assertEquals("187 g", product.getItemWeight());
        assertEquals("GA04803-GB", product.getModelNumber());
        assertEquals("https://upload.example.com/gameboy-advance-purple.png", product.getImageUrl());
    }

    @Test
    void testSecondProductDetails() {
        Product product = products.stream().filter(p -> p.getName().equals("Super Smart Vacuum")).findFirst().orElse(null);
        assertNotNull(product);
        assertEquals("Smart vacuum cleaner by OpenAI.", product.getDescription());
        assertEquals(new BigDecimal("499.99"), product.getPrice());
        assertEquals("30 x 30 x 10 cm", product.getDimensions());
        assertEquals("3.5 kg", product.getItemWeight());
        assertEquals("SV001", product.getModelNumber());
        assertEquals("https://upload.example.com/robot-vacuum-cleaner.png", product.getImageUrl());
    }

}
