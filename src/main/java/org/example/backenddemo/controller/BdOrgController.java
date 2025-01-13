package org.example.backenddemo.controller;

import org.example.backenddemo.mapper.BdOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BdOrgController {

    @Autowired
    public BdOrgMapper bdOrgMapper;

    @GetMapping("orgTest")
    public Void orgTest() {
        System.out.println(bdOrgMapper.getOrgWithCur("ORG00000000000000001"));
        return null;
    }
}
