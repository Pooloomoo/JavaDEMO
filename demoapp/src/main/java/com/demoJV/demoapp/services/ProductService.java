package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProduct();
    Products getProduct(int id);
    Products saveProduct(Products product);
    Products editProduct(int id,Products product);
    void deleteProduct(int id);
}
