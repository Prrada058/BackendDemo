package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCustomer;

import java.util.Map;

public interface BdCustomerService {

    BdCustomer getCustomerByPk(String pk_customer);

    boolean isCustomerExist(String pk_customer);

    String inputValidate(Map<String, Object> bdCustomer);
}
