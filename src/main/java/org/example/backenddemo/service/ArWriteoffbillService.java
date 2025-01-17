package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArWriteoffbill;

import java.util.Map;

public interface ArWriteoffbillService {

    String inputValidate(Map<String, Object> arWriteoffbill);

    ArWriteoffbill getArWriteoffbillByPk(String pk_ar_writeoffbill);
}
