package org.example.backenddemo.controller;

import org.example.backenddemo.service.ArWriteoffbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArWriteoffbillController {

    @Autowired
    private ArWriteoffbillService arWriteoffbillService;

    @PostMapping("/arWriteoffbill/new")
    public String newWriteoffbill(@RequestBody Map<String, Object> arWriteoffbill) {
        String ValidateReturn = arWriteoffbillService.inputValidate(arWriteoffbill);

        return ValidateReturn;
    }


}
