package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdAccount;
import org.example.backenddemo.mapper.BdAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdAccountServiceImpl implements BdAccountService {

    @Autowired
    private BdAccountMapper bdAccountMapper;

    @Override
    public BdAccount getAccountByPk(String pk_account) {
        return bdAccountMapper.getAccountByPk(pk_account);
    }

    @Override
    public boolean isAccountExist(String pk_account) {
        return getAccountByPk(pk_account) != null;
    }
}
