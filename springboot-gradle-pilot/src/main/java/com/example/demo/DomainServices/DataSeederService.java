package com.example.demo.DomainServices;

import com.example.demo.Entities.*;
import com.example.demo.Repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DataSeederService {

    private final ProductRepository productRepository;
    private final SubProductMappingRepository mappingRepository;

    public DataSeederService(ProductRepository productRepository,
                             SubProductMappingRepository mappingRepository) {
        this.productRepository = productRepository;
        this.mappingRepository = mappingRepository;
    }

    public void seed() {
        // clear old data (optional)
        // mappingRepository.deleteAll();
        // productRepository.deleteAll();

        // create major products
        ProductEntity major1 = new ProductEntity();
        major1.setName("Major Product A");
        major1.setVersion("1.0");

        ProductEntity major2 = new ProductEntity();
        major2.setName("Major Product B");
        major2.setVersion("1.0");

        productRepository.saveAll(List.of(major1, major2));

        // create sub products
        ProductEntity sub1 = new ProductEntity();
        sub1.setName("Sub Product A1");
        sub1.setVersion("1.0");

        ProductEntity sub2 = new ProductEntity();
        sub2.setName("Sub Product A2");
        sub2.setVersion("1.0");

        ProductEntity sub3 = new ProductEntity();
        sub3.setName("Sub Product B1");
        sub3.setVersion("1.0");

        productRepository.saveAll(List.of(sub1, sub2, sub3));

        // create mappings
        SubProductMappingEntity m1 = new SubProductMappingEntity();
        SubProductMappingKeyEntity key1 = new SubProductMappingKeyEntity();
        key1.setMajorProductId(major1.getId());
        key1.setSubProductId(sub1.getId());
        m1.setId(key1);
        m1.setMajorProduct(major1);
        m1.setSubProduct(sub1);

        SubProductMappingEntity m2 = new SubProductMappingEntity();
        SubProductMappingKeyEntity key2 = new SubProductMappingKeyEntity();
        key2.setMajorProductId(major1.getId());
        key2.setSubProductId(sub2.getId());
        m2.setId(key2);
        m2.setMajorProduct(major1);
        m2.setSubProduct(sub2);

        SubProductMappingEntity m3 = new SubProductMappingEntity();
        SubProductMappingKeyEntity key3 = new SubProductMappingKeyEntity();
        key3.setMajorProductId(major2.getId());
        key3.setSubProductId(sub3.getId());
        m3.setId(key3);
        m3.setMajorProduct(major2);
        m3.setSubProduct(sub3);

        mappingRepository.saveAll(List.of(m1, m2, m3));
    }
}