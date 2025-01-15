package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCustomer;
import org.example.backenddemo.mapper.BdCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdCustomerServiceImpl implements BdCustomerService {
    @Autowired
    private BdCustomerMapper bdCustomerMapper;

    @Override
    public BdCustomer getCustomerByPk(String pk_customer) {
        return bdCustomerMapper.getCustomerByPk(pk_customer);
    }
    @Override
    public boolean isCustomerExist(String pk_customer) {
        return getCustomerByPk(pk_customer)!=null;
    }

}
