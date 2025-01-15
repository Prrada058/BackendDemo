package org.example.backenddemo.controller;

import org.example.backenddemo.dto.ArRecbillFull;
import org.example.backenddemo.mapper.ArRecbillMapper;
import org.example.backenddemo.service.ArRecbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class ArRecbillController {

    @Autowired
    private ArRecbillMapper arRecbillMapper;

    @Autowired
    private ArRecbillService arRecbillService;

    @GetMapping("/arRecbill/list")
    public List<ArRecbillFull> getAll() {
        return arRecbillMapper.getFullRecbill();
    }

    @PostMapping("/arRecbill/new")
    public String createArRecbill(@RequestBody Map<String, Object> arRecbill) {
        String ValidateReturn = arRecbillService.inputValidate(arRecbill);
        return ValidateReturn;
    }

}
