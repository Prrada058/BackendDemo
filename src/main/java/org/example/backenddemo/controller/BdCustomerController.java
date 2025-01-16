package org.example.backenddemo.controller;


import org.example.backenddemo.entity.BdCustomer;
import org.example.backenddemo.service.BdCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BdCustomerController {
    @Autowired
    private BdCustomerService bdCustomerService;

    @PostMapping("/bd/customer/new")
    public String newCustomer(@RequestBody Map<String, Object> bdCustomer) {
        String ValidateReturn = bdCustomerService.inputValidate(bdCustomer);
        return ValidateReturn;

    }
}
