package com.example.demo.Repositories;

import com.example.demo.Entities.ProductEntity;
import com.example.demo.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProductMappingRepository extends JpaRepository<SubProductMappingEntity, SubProductMappingKeyEntity> {
}