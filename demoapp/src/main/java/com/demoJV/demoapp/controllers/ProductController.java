package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Products;
import com.demoJV.demoapp.models.payment.PromptpayDTO;
import com.demoJV.demoapp.services.ProductService;
import com.demoJV.demoapp.services.PromptPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PromptPayService promptPayService;


    @GetMapping("/")
    public List<Products> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("/")
    public Products saveProduct(@RequestBody Products product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Products editProduct(@PathVariable("id") int id,@RequestBody Products product){
        return productService.editProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "Product has delete";
    }

    @PostMapping("/buy")
    public ResponseEntity<Map<String,String>> payProduct(@RequestBody PromptpayDTO promptpayDTO){
        Products products = productService.getProduct(promptpayDTO.getProduct_Id());
        String idPay = products.supply.phone;
        int amountPay = products.price;

        String base64QR = promptPayService.generatePromptPayQR(idPay, amountPay);

        Map<String, String> response = new HashMap<>();
        response.put("qrBase64", base64QR);
        return ResponseEntity.ok(response);
    }
}
