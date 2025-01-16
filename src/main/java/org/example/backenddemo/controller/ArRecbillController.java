package org.example.backenddemo.controller;

import org.example.backenddemo.mapper.ArRecbillMapper;
import org.example.backenddemo.service.ArRecbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
public class ArRecbillController {

    @Autowired
    private ArRecbillMapper arRecbillMapper;

    @Autowired
    private ArRecbillService arRecbillService;


    @PostMapping("/arRecbill/new")
    public String createArRecbill(@RequestBody Map<String, Object> arRecbill) {
        String ValidateReturn = arRecbillService.inputValidate(arRecbill);
        return ValidateReturn;
    }

}
