package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "sub_product_mapping")
public class SubProductMappingEntity {

    @EmbeddedId
    private SubProductMappingKeyEntity id;

    @MapsId("majorProductId")
    @ManyToOne
    @JoinColumn(name = "major_product_id", nullable = false)
    @JsonBackReference
    private ProductEntity majorProduct;

    @MapsId("subProductId")
    @OneToOne
    @JoinColumn(name = "sub_product_id", nullable = false, unique = true)
    @JsonBackReference
    private ProductEntity subProduct;

    public ProductEntity getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(ProductEntity subProduct) {
        this.subProduct = subProduct;
    }

    public ProductEntity getMajorProduct() {
        return majorProduct;
    }

    public void setMajorProduct(ProductEntity majorProduct) {
        this.majorProduct = majorProduct;
    }

    public SubProductMappingKeyEntity getId() {
        return id;
    }

    public void setId(SubProductMappingKeyEntity id) {
        this.id = id;
    }

    // getters / setters
}
