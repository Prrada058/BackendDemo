package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdAccount;

public interface BdAccountService {

    BdAccount getAccountByPk(String pk_account);
    boolean isAccountExist(String pk_account);

}
