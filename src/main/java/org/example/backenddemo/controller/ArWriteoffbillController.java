package org.example.backenddemo.controller;

import org.example.backenddemo.entity.ArWriteoffbill;
import org.example.backenddemo.service.ArWriteoffbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/arWriteoffbill/select")
    public ArWriteoffbill selectWriteoffbill(@RequestParam String pk_ar_writeoffbill) {

        return arWriteoffbillService.getArWriteoffbillByPk(pk_ar_writeoffbill);
    }


}
