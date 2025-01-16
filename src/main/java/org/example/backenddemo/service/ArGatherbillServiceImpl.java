package org.example.backenddemo.service;


import org.example.backenddemo.entity.ArGatherbill;
import org.example.backenddemo.entity.ArRecbill;
import org.example.backenddemo.mapper.ArGatherbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class ArGatherbillServiceImpl implements ArGatherbillService {

    @Autowired
    private ArGatherbillMapper arGatherbillMapper;

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
        String bill_status;
        String write_off_status;

        ArRecbill arRecbill;


        if (isEmpty((String) arGatherbill.get("pk_org"))) {
            return "组织不能为空";
        } else {
            String TempPk_org = (String) arGatherbill.get("pk_org");
            if (bdOrgService.isOrgExist(TempPk_org)) {
                pk_org = TempPk_org;
            } else {
                return "无效组织";
            }
        }

        if (isEmpty((String) arGatherbill.get("pk_customer"))) {
            return "客户不能为空";
        } else {
            String TempPk_customer = (String) arGatherbill.get("pk_customer");
            if (bdCustomerService.isCustomerExist(TempPk_customer)) {
                pk_customer = TempPk_customer;
            } else {
                return "无效客户";
            }
        }

        if (isEmpty((String) arGatherbill.get("create_date"))) {
            return "创建时间不能为空";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            create_date = LocalDateTime.parse((String) arGatherbill.get("create_date"), formatter);
        }

        if (isEmpty((String) arGatherbill.get("billmaker"))) {
            return "制单人不能为空";
        } else {
            String TempBillmaker = (String) arGatherbill.get("billmaker");
            if (bdAccountService.isAccountExist(TempBillmaker)) {
                billmaker = TempBillmaker;
            } else {
                return "无效制单人用户";
            }
        }

        if (isEmpty((String) arGatherbill.get("pk_currency"))) {
            return "币种不能为空";
        } else {
            String TempPk_currency = ((String) arGatherbill.get("pk_currency")).toUpperCase();
            if (bdCurrencyService.isCurrencyExist(TempPk_currency)) {
                pk_currency = TempPk_currency;
            } else {
                return "无效币种";
            }
        }

        if (arGatherbill.get("rate").getClass() == Double.class && (Double) arGatherbill.get("rate") != 0) {
            rate = (Double) arGatherbill.get("rate");
        } else if (arGatherbill.get("rate").getClass() == Integer.class && (Integer) arGatherbill.get("rate") != 0) {
            rate = (Integer) arGatherbill.get("rate");
        } else {
            return "无效汇率";
        }

        if (arGatherbill.get("money").getClass() == Double.class) {
            money = (Double) arGatherbill.get("money");
        } else if (arGatherbill.get("money").getClass() == Integer.class) {
            money = (Integer) arGatherbill.get("money");
        } else {
            return "无效金额";
        }

        if (arGatherbill.get("local_money").getClass() == Double.class) {
            local_money = (Double) arGatherbill.get("local_money");
        } else if (arGatherbill.get("local_money").getClass() == Integer.class) {
            local_money = (Integer) arGatherbill.get("local_money");
        } else {
            return "无效组织本币金额";
        }

        if (isEmpty((String) arGatherbill.get("bill_status"))) {
            return "状态不能为空";
        } else {
            String TempBill_status = (String) arGatherbill.get("bill_status");
            if (TempBill_status.matches("[0-5]")) {
                bill_status = TempBill_status;
            } else {
                return "状态无效";
            }
        }

        if (isEmpty((String) arGatherbill.get("write_off_status"))) {
            return "核销状态不能为空";
        } else {
            String TempWrite_off_status = (String) arGatherbill.get("write_off_status");
            if (TempWrite_off_status.matches("[0-5]")) {
                write_off_status = TempWrite_off_status;
            } else {
                return "核销状态无效";
            }
        }


        ArGatherbill new_arGatherbill = new ArGatherbill();
        new_arGatherbill.setPk_org(pk_org);
        new_arGatherbill.setPk_customer(pk_customer);
        new_arGatherbill.setCreate_date(create_date);
        new_arGatherbill.setBillmaker(billmaker);
        new_arGatherbill.setPk_currency(pk_currency);
        new_arGatherbill.setRate(rate);
        new_arGatherbill.setMoney(money);
        new_arGatherbill.setLocal_money(local_money);
        new_arGatherbill.setBill_status(bill_status);
        new_arGatherbill.setWrite_off_status(write_off_status);

        System.out.println(new_arGatherbill);

        return insertArGatherbill(new_arGatherbill);
    }

    private String insertArGatherbill(ArGatherbill arGatherbill) {
        arGatherbillMapper.insert(arGatherbill);
        System.out.println(arGatherbill.getPk_gatherbill());
        return arGatherbill.getPk_gatherbill();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
