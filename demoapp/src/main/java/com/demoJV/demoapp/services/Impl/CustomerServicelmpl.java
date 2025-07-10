package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Customers;
import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.repositories.CustomerRepository;
import com.demoJV.demoapp.repositories.UserRepository;
import com.demoJV.demoapp.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicelmpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServicelmpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customers> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Customers getCustomer(int id){
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customers saveCustomer(Customers customer){
        return customerRepository.save(customer);
    }

    @Override
    public Customers editCustomer(int id,Customers customer){
        Customers oldCustomer = getCustomer(id);
        if(oldCustomer != null){
            oldCustomer.name = customer.name;
            oldCustomer.surname = customer.surname;
            oldCustomer.phone = customer.phone;
            return saveCustomer(oldCustomer);
        }else{
            return  null;
        }
    }

    @Override
    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }
}
