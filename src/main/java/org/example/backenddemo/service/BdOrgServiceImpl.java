package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdOrg;
import org.example.backenddemo.mapper.BdOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BdOrgServiceImpl implements BdOrgService {

    @Autowired
    private BdOrgMapper bdOrgMapper;

    @Autowired
    private BdCurrencyService bdCurrencyService;

    @Override
    public BdOrg getOrgByPk(String pk_org) {
        return bdOrgMapper.getOrgByPk(pk_org);
    }

    @Override
    public boolean isOrgExist(String pk_org) {
        return getOrgByPk(pk_org) != null;
    }

    @Override
    public String inputValidate(Map<String, Object> bdOrg) {
        if (bdOrg == null) {
            return "空JSON?";
        }

        String name;
        String pk_currency;

        if (isEmpty((String) bdOrg.get("name"))) {
            return "组织名不能为空";
        } else {
            name = (String) bdOrg.get("name");
        }

        if (isEmpty((String) bdOrg.get("pk_currency"))) {
            return "组织本币不能为空";
        } else {
            String TempPk_currency = ((String) bdOrg.get("pk_currency")).toUpperCase();
            if (bdCurrencyService.isCurrencyExist(TempPk_currency)) {
                pk_currency = TempPk_currency;
            } else {
                return "无效币种";
            }
        }

        BdOrg new_bdOrg = new BdOrg();

        new_bdOrg.setName(name);
        new_bdOrg.setPk_currency(pk_currency);

        System.out.println(new_bdOrg);

        return insertBdOrg(new_bdOrg);
    }

    private String insertBdOrg(BdOrg bdOrg) {

        bdOrgMapper.insert(bdOrg);

        return bdOrg.getPk_org();

    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }


}
