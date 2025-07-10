package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Customers;
import com.demoJV.demoapp.models.Products;
import com.demoJV.demoapp.repositories.CustomerRepository;
import com.demoJV.demoapp.repositories.ProductRepository;
import com.demoJV.demoapp.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicelmpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServicelmpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Products getProduct(int id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Products saveProduct(Products product){
        return productRepository.save(product);
    }

    @Override
    public Products editProduct(int id,Products product){
        Products oldProduct = getProduct(id);
        if(oldProduct != null){
            oldProduct.name = product.name;
            oldProduct.price = product.price;
            if ((product.supply != null && product.supply.id > 0) && (product.catalog != null && product.catalog.id > 0)) {
                oldProduct.catalog = product.catalog;
                oldProduct.supply = product.supply;
            }
            return saveProduct(oldProduct);
        }else{
            return  null;
        }
    }

    @Override
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
