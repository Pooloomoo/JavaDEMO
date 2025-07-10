package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Supplies;
import com.demoJV.demoapp.services.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService){
        this.supplyService = supplyService;
    }

    @GetMapping("/supply")
    public List<Supplies> getAllSupply(){
        return supplyService.getAllSupply();
    }

    @GetMapping("/supply/{id}")
    public Supplies getSupply(@PathVariable("id") int id){
        return supplyService.getSupply(id);
    }

    @PostMapping("/supply")
    public Supplies saveSupply(@RequestBody Supplies supplies){
        return supplyService.saveSupply(supplies);
    }

    @PutMapping("/supply/{id}")
    public Supplies editSupply(@PathVariable("id") int id,@RequestBody Supplies supplies){
        return supplyService.editSupply(id,supplies);
    }

    @DeleteMapping("/supply/{id}")
    public String deleteSupply(@PathVariable("id") int id){
        supplyService.deleteSupply(id);
        return "Your Supply has been delete.";
    }
}
