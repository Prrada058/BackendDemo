package org.example.backenddemo.controller;

import org.example.backenddemo.entity.BdOrg;
import org.example.backenddemo.mapper.BdOrgMapper;
import org.example.backenddemo.service.BdOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BdOrgController {

    @Autowired
    public BdOrgMapper bdOrgMapper;

    @Autowired
    public BdOrgService bdOrgService;

    @GetMapping("orgTest")
    public Void orgTest() {
        System.out.println(bdOrgMapper.getOrgWithCur("ORG00000000000000001"));
        return null;
    }

    @PostMapping("/bd/org/new")
    public String newOrg(@RequestBody Map<String, Object> bdOrg) {
        String ValidateReturn = bdOrgService.inputValidate(bdOrg);
        return ValidateReturn;
    }
}
