package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Supplies;
import com.demoJV.demoapp.services.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/supply")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService){
        this.supplyService = supplyService;
    }

    @GetMapping("/")
    public List<Supplies> getAllSupply(){
        return supplyService.getAllSupply();
    }

    @GetMapping("/{id}")
    public Supplies getSupply(@PathVariable("id") int id){
        return supplyService.getSupply(id);
    }

    @PostMapping("/")
    public Supplies saveSupply(@RequestBody Supplies supplies){
        return supplyService.saveSupply(supplies);
    }

    @PutMapping("/{id}")
    public Supplies editSupply(@PathVariable("id") int id,@RequestBody Supplies supplies){
        return supplyService.editSupply(id,supplies);
    }

    @DeleteMapping("/{id}")
    public String deleteSupply(@PathVariable("id") int id){
        supplyService.deleteSupply(id);
        return "Your Supply has been delete.";
    }
}
