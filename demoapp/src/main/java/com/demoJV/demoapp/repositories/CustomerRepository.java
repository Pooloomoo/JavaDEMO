package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
}
