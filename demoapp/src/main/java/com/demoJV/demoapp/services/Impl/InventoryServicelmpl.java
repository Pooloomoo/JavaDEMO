package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Customers;
import com.demoJV.demoapp.models.Inventories;
import com.demoJV.demoapp.repositories.InventoryRepository;
import com.demoJV.demoapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServicelmpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventories> getAllInventory(){
        return inventoryRepository.findAll();
    }

    @Override
    public Inventories getInventory(int id){
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventories saveInventory(Inventories inventories){
        return inventoryRepository.save(inventories);
    }

    @Override
    public Inventories editInventory(int id,Inventories inventories){
        Inventories oldInventories = getInventory(id);
        if(oldInventories != null){
            oldInventories.amount = inventories.amount;
            if (inventories.product != null){
                oldInventories.product = inventories.product;
            }
            return saveInventory(oldInventories);
        }else{
            return  null;
        }
    }
    @Override
    public void deleteInventory(int id){
        inventoryRepository.deleteById(id);
    }
}
