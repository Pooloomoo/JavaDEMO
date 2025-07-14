package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Inventories;
import com.demoJV.demoapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public List<Inventories> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventories getInventory(@PathVariable("id") int id){
        return inventoryService.getInventory(id);
    }

    @PostMapping("/")
    public Inventories saveInventory(@RequestBody Inventories inventories){
        return inventoryService.saveInventory(inventories);
    }

    @PutMapping("/{id}")
    public Inventories editInventory(@PathVariable("id") int id,@RequestBody Inventories inventories){
        return inventoryService.editInventory(id,inventories);
    }

    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable("id") int id){
        inventoryService.deleteInventory(id);
        return "Your Inventory has been delete";
    }
}
