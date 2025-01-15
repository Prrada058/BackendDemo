package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdOrg;
import org.example.backenddemo.mapper.BdOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdOrgServiceImpl implements BdOrgService {

    @Autowired
    private BdOrgMapper bdOrgMapper;

    @Override
    public BdOrg getOrgByPk(String pk_org) {
        return bdOrgMapper.getOrgByPk(pk_org);
    }

    @Override
    public boolean isOrgExist(String pk_org){
        return getOrgByPk(pk_org)!=null;
    }

}
