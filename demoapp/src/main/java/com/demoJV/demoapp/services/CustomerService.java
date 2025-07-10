package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> getAllCustomer();
    Customers getCustomer(int id);
    Customers saveCustomer(Customers customer);
    Customers editCustomer(int id,Customers customer);
    void deleteCustomer(int id);
}
