package org.example.backenddemo.service;

import org.example.backenddemo.entity.BdCustomer;
import org.example.backenddemo.mapper.BdCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

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
        return getCustomerByPk(pk_customer) != null;
    }

    @Override
    public String inputValidate(Map<String, Object> bdCustomer) {
        if (bdCustomer == null) {
            return "空JSON?";
        }

        String name;

        if (isEmpty((String) bdCustomer.get("name"))) {
            return "用户名不能为空";
        } else {
            name = (String) bdCustomer.get("name");
        }

        BdCustomer new_bdCustomer = new BdCustomer();
        new_bdCustomer.setName(name);

        System.out.println(new_bdCustomer);


        return insertBdCustomer(new_bdCustomer);

    }


    private String insertBdCustomer(BdCustomer bdCustomer) {
        bdCustomerMapper.insert(bdCustomer);
        return bdCustomer.getPk_customer();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}



