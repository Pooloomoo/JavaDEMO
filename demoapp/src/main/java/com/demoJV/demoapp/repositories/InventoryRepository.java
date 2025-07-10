package com.demoJV.demoapp.repositories;

import com.demoJV.demoapp.models.Inventories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventories,Integer> {
}
