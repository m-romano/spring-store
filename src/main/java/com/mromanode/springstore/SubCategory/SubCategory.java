package com.mromanode.springstore.SubCategory;

import com.mromanode.springstore.Category.Category;
import com.mromanode.springstore.Product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "subcategories")
@Getter @Setter
@NoArgsConstructor
public class SubCategory {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "subCategories")
    private Set<Product> products;

}
