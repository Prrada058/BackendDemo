package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCustomer;

public interface BdCustomerService {

    BdCustomer getCustomerByPk(String pk_customer);

    boolean isCustomerExist(String pk_customer);
}
