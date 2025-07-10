package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Cataloges;

import java.util.List;

public interface CatalogeService {
    List<Cataloges> getAllCataloge();
    Cataloges getCataloge(int id);
    Cataloges saveCataloge(Cataloges cataloges);
    Cataloges editCataloge(int id, Cataloges cataloges);
    void deleteCataloge(int id);
}
