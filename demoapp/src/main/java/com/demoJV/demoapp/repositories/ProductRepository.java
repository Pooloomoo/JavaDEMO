package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}
