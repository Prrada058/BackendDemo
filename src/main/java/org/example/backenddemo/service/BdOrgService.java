package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdOrg;

public interface BdOrgService {
    BdOrg getOrgByPk(String pk_org);

    boolean isOrgExist(String pk_org);
}
