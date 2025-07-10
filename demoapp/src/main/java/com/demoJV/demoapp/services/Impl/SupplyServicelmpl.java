package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Supplies;
import com.demoJV.demoapp.repositories.SupplyRepository;
import com.demoJV.demoapp.services.SupplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServicelmpl implements SupplyService {
    private final SupplyRepository supplyRepository;

    public SupplyServicelmpl(SupplyRepository supplyRepository){
        this.supplyRepository = supplyRepository;
    }

    @Override
    public List<Supplies> getAllSupply(){
        return supplyRepository.findAll();
    }

    @Override
    public Supplies getSupply(int id){
        return supplyRepository.findById(id).orElse(null);
    }

    @Override
    public Supplies saveSupply(Supplies supplies){
        return supplyRepository.save(supplies);
    }

    @Override
    public Supplies editSupply(int id,Supplies supplies){
        Supplies oldSupplies = getSupply(id);
        if(oldSupplies != null){
            oldSupplies = supplies;
            if(supplies.product != null){
                oldSupplies.product = supplies.product;
            }
            return supplyRepository.save(oldSupplies);
        }else{
            return null;
        }
    }

    @Override
    public void deleteSupply(int id){
        supplyRepository.deleteById(id);
    }
}
