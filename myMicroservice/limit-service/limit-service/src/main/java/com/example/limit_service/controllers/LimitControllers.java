package com.example.limit_service.controllers;

import com.example.limit_service.beans.Limits;
import com.example.limit_service.configurations.LimitConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/limits")
public class LimitControllers {

    @Autowired
    private LimitConfigurations limitConfigurations;

    @GetMapping(path = "/")
    public Limits retrieveLimit(){
        return new Limits(
                limitConfigurations.getMinimum(),
                limitConfigurations.getMaximum()
        );
    }
}
