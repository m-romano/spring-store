package com.mromanode.springstore.Category;

import com.mromanode.springstore.Product.Product;
import com.mromanode.springstore.SubCategory.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Getter @Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private Set<SubCategory> subCategories;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;


}