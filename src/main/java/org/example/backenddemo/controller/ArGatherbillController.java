package org.example.backenddemo.controller;


import org.example.backenddemo.entity.ArGatherbill;
import org.example.backenddemo.service.ArGatherbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArGatherbillController {

    @Autowired
    private ArGatherbillService arGatherbillService;

    @PostMapping("/arGatherbill/new")
    public String newGatherbill(@RequestBody Map<String,Object> arGatherbill) {
        return arGatherbillService.inputValidate(arGatherbill);

    }

}
