package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCurrency;

public interface BdCurrencyService {

    BdCurrency getCurrencyByPk(String pk_currency);

    boolean isCurrencyExist(String pk_currency);
}
