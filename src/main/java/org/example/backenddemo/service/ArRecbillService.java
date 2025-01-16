package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArRecbill;

import java.util.Map;

public interface ArRecbillService {

    String inputValidate(Map<String, Object> arRecbill);

    ArRecbill findById(String pk_recbill);
}
