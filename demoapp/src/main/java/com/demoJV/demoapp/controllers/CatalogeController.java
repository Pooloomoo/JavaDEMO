package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Cataloges;
import com.demoJV.demoapp.services.CatalogeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cataloge")
public class CatalogeController {

    private final CatalogeService catalogeService;

    public CatalogeController(CatalogeService catalogeService){
        this.catalogeService = catalogeService;
    }

    @GetMapping("/")
    public List<Cataloges> getAllCataloge(){
        return catalogeService.getAllCataloge();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cataloges> getCataloge(@PathVariable("id") int id){
        return new ResponseEntity<>(catalogeService.getCataloge(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public Cataloges saveCataloge(@RequestBody Cataloges cataloge){
        return catalogeService.saveCataloge(cataloge);
    }

    @PutMapping("/{id}")
    public Cataloges editCataloge(@PathVariable("id") int id,@RequestBody Cataloges cataloge){
        return catalogeService.editCataloge(id,cataloge);
    }

    @DeleteMapping("/{id}")
    public String deleteCataloge(@PathVariable("id") int id){
        catalogeService.deleteCataloge(id);
        return "Your Cataloge has been delete";
    }
}
