package com.mromanode.springstore.Product;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.SubCategory.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String dimensions;

    @Column(name = "item_weight", nullable = false)
    private String itemWeight;

    @Column(name = "model_number", nullable = false)
    private String modelNumber;

    @ManyToMany
    @JoinTable(
            name = "product_subcategories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private Set<SubCategory> subCategories;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

}

