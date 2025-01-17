package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArRecbill;

import java.util.Map;

public interface ArRecbillService {

    String inputValidate(Map<String, Object> arRecbill);

    ArRecbill getRecbillByPk(String pk_recbill);

    boolean isRecbillExist(String pk_recbill);

    void writeoff(String pk_recbill, double money);
}
