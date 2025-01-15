package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCurrency;
import org.example.backenddemo.mapper.BdCurrencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdCurrencyServiceImpl implements BdCurrencyService {

    @Autowired
    private BdCurrencyMapper bdCurrencyMapper;

    @Override
    public BdCurrency getCurrencyByPk(String pk_currency) {
        return bdCurrencyMapper.getCurrencyByPk(pk_currency);
    }

    @Override
    public boolean isCurrencyExist(String pk_currency) {
        return getCurrencyByPk(pk_currency) != null;
    }


}
