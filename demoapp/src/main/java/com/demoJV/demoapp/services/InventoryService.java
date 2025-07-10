package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Inventories;

import java.util.List;

public interface InventoryService {
    List<Inventories> getAllInventory();
    Inventories getInventory(int id);
    Inventories saveInventory(Inventories inventories);
    Inventories editInventory(int id,Inventories inventories);
    void deleteInventory(int id);
}
