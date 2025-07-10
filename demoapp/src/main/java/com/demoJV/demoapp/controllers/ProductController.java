package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Products;
import com.demoJV.demoapp.services.CustomerService;
import com.demoJV.demoapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Products> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public Products getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public Products saveProduct(@RequestBody Products product){
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public Products editProduct(@PathVariable("id") int id,@RequestBody Products product){
        return productService.editProduct(id,product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "Product has delete";
    }
}
