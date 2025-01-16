package org.example.backenddemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArGatherbillServiceImpl implements ArGatherbillService {

    @Autowired
    private ArRecbillService arRecbillService;

    @Autowired
    private BdOrgService bdOrgService;

    @Autowired
    private BdCustomerService bdCustomerService;

    @Autowired
    private BdAccountService bdAccountService;

    @Autowired
    private BdCurrencyService bdCurrencyService;

    @Override
    public String inputValidate(Map<String, Object> arGatherbill) {
        if (arGatherbill == null) {
            return "?空 JSON";
        }

        String pk_org;
        String pk_customer;
        LocalDateTime create_date;
        String billmaker;
        String pk_currency;
        double rate;
        double money;
        double local_money;
        String billstatus;
        String settleflag;
        String pk_recbill;

        if (isEmpty((String) arGatherbill.get("pk_recbill"))) {
//            nothing happend
        } else {
            String TempPk_recbill = (String) arGatherbill.get("pk_recbill");
            if (true) {
                System.out.println(arRecbillService.findById(TempPk_recbill));


                pk_recbill = TempPk_recbill;
            } else {
                return "无效应收单号";
            }
        }


        return "success";
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
