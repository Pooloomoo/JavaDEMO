package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Cataloges;
import com.demoJV.demoapp.repositories.CatalogeRepository;
import com.demoJV.demoapp.services.CatalogeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogeServicelmpl implements CatalogeService {

    private final CatalogeRepository catalogeRepository;

    public CatalogeServicelmpl(CatalogeRepository catalogeRepository){
        this.catalogeRepository = catalogeRepository;
    }

    @Override
    public List<Cataloges> getAllCataloge(){
        return catalogeRepository.findAll();
    }

    @Override
    public Cataloges getCataloge(int id){
        return  catalogeRepository.findById(id).orElse(null);
    }

    @Override
    public Cataloges saveCataloge(Cataloges cataloge){
        return catalogeRepository.save(cataloge);
    }

    @Override
    public Cataloges editCataloge(int id,Cataloges cataloge){
        Cataloges oldCataloge = getCataloge(id);
        if(oldCataloge != null){
            oldCataloge = cataloge;
            if(cataloge != null){
                oldCataloge.product = cataloge.product;
            }
            return catalogeRepository.save(oldCataloge);
        }else{
            return null;
        }
    }

    @Override
    public void deleteCataloge(int id){
        catalogeRepository.deleteById(id);
    }
}
