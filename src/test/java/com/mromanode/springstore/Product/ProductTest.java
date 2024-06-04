package com.mromanode.springstore.Product;

import com.mromanode.springstore.SubCategory.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    private Product product;
    private UUID productId;
    private Set<SubCategory> subCategories;

    @BeforeEach
    void setUp() {
        product = new Product();
        productId = UUID.randomUUID();

        product.setId(productId);
        product.setName("Sirius Cybernetics");
        product.setDescription("AI humanoid by OpenAI.");
        product.setPrice(new BigDecimal("999.99"));
        product.setDimensions("0.89 x 7.08 x 15.05 cm");
        product.setItemWeight("187 g");
        product.setModelNumber("GA04803-GB");
        product.setImageUrl("https://example.com/nintendo-gameboy-advance.jpg");

        subCategories = new HashSet<>();

        SubCategory firstSubCategory = new SubCategory();
        firstSubCategory.setName("Camera & Photo");
        firstSubCategory.setDescription("For your best shoots.");

        SubCategory secondSubCategory = new SubCategory();
        secondSubCategory.setName("Computers & Accessories");
        secondSubCategory.setDescription("Office, gaming");

        subCategories.add(firstSubCategory);
        subCategories.add(secondSubCategory);
    }

    @Test
    void createProduct() {
        assertEquals(product.getId(), productId);
        assertEquals("Sirius Cybernetics", product.getName());
        assertEquals("AI humanoid by OpenAI.", product.getDescription());
        assertEquals(new BigDecimal("999.99"), product.getPrice());
        assertEquals("0.89 x 7.08 x 15.05 cm", product.getDimensions());
        assertEquals("187 g", product.getItemWeight());
        assertEquals("GA04803-GB", product.getModelNumber());
        assertEquals("https://example.com/nintendo-gameboy-advance.jpg", product.getImageUrl());
    }

    @Test
    void updateProduct() {
        product.setId(productId);
        product.setName("Sirius Cybernetics");
        product.setDescription("AI humanoid by OpenAI.");
        product.setPrice(new BigDecimal("699.99"));
        product.setDimensions("0.89 x 7.08 x 15.05 cm");
        product.setItemWeight("187 g");
        product.setModelNumber("MA02801-GB");

        assertEquals(product.getId(), productId);
        assertEquals("Sirius Cybernetics", product.getName());
        assertEquals("AI humanoid by OpenAI.", product.getDescription());
        assertEquals(new BigDecimal("699.99"), product.getPrice());
        assertEquals("0.89 x 7.08 x 15.05 cm", product.getDimensions());
        assertEquals("187 g", product.getItemWeight());
        assertEquals("MA02801-GB", product.getModelNumber());
    }
}
