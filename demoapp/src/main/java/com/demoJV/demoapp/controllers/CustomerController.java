package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Customers;
import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.services.CustomerService;
import com.demoJV.demoapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customers> getAllCustomer(){
        System.out.println("get Customer");
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public Customers getCustomer(@PathVariable("id") int id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public Customers saveCustomer(@RequestBody Customers customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public Customers editCustomer(@PathVariable("id") int id,@RequestBody Customers customer){
        return  customerService.editCustomer(id,customer);

    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
        return "Delete Success";
    }

}
