package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdOrg;

import java.util.Map;

public interface BdOrgService {

    BdOrg getOrgByPk(String pk_org);

    boolean isOrgExist(String pk_org);

    String inputValidate(Map<String, Object> bdOrg);

}
