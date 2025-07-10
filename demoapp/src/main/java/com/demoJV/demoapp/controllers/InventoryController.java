package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Inventories;
import com.demoJV.demoapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public List<Inventories> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/inventory/{id}")
    public Inventories getInventory(@PathVariable("id") int id){
        return inventoryService.getInventory(id);
    }

    @PostMapping("/inventory")
    public Inventories saveInventory(@RequestBody Inventories inventories){
        return inventoryService.saveInventory(inventories);
    }

    @PutMapping("/inventory/{id}")
    public Inventories editInventory(@PathVariable("id") int id,@RequestBody Inventories inventories){
        return inventoryService.editInventory(id,inventories);
    }

    @DeleteMapping("/inventory/{id}")
    public String deleteInventory(@PathVariable("id") int id){
        inventoryService.deleteInventory(id);
        return "Your Inventory has been delete";
    }
}
