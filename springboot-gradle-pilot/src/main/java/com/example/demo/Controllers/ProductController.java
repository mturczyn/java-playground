package com.example.demo.Controllers;

import com.example.demo.Entities.ProductEntity;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductRepository  productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
