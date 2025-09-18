package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SubProductMappingKeyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "major_product_id", nullable = false)
    private int majorProductId;

    @Column(name = "sub_product_id", nullable = false)
    private int subProductId;

    public int getMajorProductId() {
        return majorProductId;
    }

    public void setMajorProductId(int majorProductId) {
        this.majorProductId = majorProductId;
    }

    public int getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(int subProductId) {
        this.subProductId = subProductId;
    }

    // getters / setters, equals(), hashCode()
}
