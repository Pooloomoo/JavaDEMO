package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Supplies;

import java.util.List;

public interface SupplyService {
    List<Supplies> getAllSupply();
    Supplies getSupply(int id);
    Supplies saveSupply(Supplies supplies);
    Supplies editSupply(int id,Supplies supplies);
    void deleteSupply(int id);
}
