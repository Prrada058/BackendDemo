package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArRecbill;
import org.example.backenddemo.mapper.ArRecbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class ArRecbillServiceImpl implements ArRecbillService {

    @Autowired
    private ArRecbillMapper arRecbillMapper;

    @Autowired
    private BdOrgService bdOrgService;

    @Autowired
    private BdCustomerService bdCustomerService;

    @Autowired
    private BdAccountService bdAccountService;

    @Autowired
    private BdCurrencyService bdCurrencyService;


    @Override
    public String inputValidate(Map<String, Object> arRecbill) {
        if (arRecbill == null) {
            return "?空 JSON";
        }

        String pk_org;
        String pk_customer;
        LocalDateTime create_date;
        LocalDateTime due_date;
        String billmaker;
        String pk_currency;
        double rate;
        double money;
        double local_money;
        String invoiceno;
        String billstatus;


        if (isEmpty((String) arRecbill.get("pk_org"))) {
            return "组织不能为空";
        } else {
            String TempPk_org = (String) arRecbill.get("pk_org");
            if (bdOrgService.isOrgExist(TempPk_org)) {
                pk_org = TempPk_org;
            } else {
                return "无效组织";
            }
        }

        if (isEmpty((String) arRecbill.get("pk_customer"))) {
            return "客户不能为空";
        } else {
            String TempPk_customer = (String) arRecbill.get("pk_customer");
            if (bdCustomerService.isCustomerExist(TempPk_customer)) {
                pk_customer = TempPk_customer;
            } else {
                return "无效客户";
            }
        }

        if (isEmpty((String) arRecbill.get("create_date"))) {
            return "创建时间不能为空";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            create_date = LocalDateTime.parse((String) arRecbill.get("create_date"), formatter);
        }

        if (isEmpty((String) arRecbill.get("due_date"))) {
            return "到期时间不能为空";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            due_date = LocalDateTime.parse((String) arRecbill.get("due_date"), formatter);
        }

        if (isEmpty((String) arRecbill.get("billmaker"))) {
            return "制单人不能为空";
        } else {
            String TempBillmaker = (String) arRecbill.get("billmaker");
            if (bdAccountService.isAccountExist(TempBillmaker)) {
                billmaker = TempBillmaker;
            } else {
                return "无效制单人用户";
            }
        }

        if (isEmpty((String) arRecbill.get("pk_currency"))) {
            return "币种不能为空";
        } else {
            String TempPk_currency = ((String) arRecbill.get("pk_currency")).toUpperCase();
            if (bdCurrencyService.isCurrencyExist(TempPk_currency)) {
                pk_currency = TempPk_currency;
            } else {
                return "无效币种";
            }
        }

        if (arRecbill.get("rate").getClass() == Double.class) {
            rate = (Double) arRecbill.get("rate");
        } else if (arRecbill.get("rate").getClass() == Integer.class) {
            rate = (Integer) arRecbill.get("rate");
        } else {
            return "无效汇率";
        }

        if (arRecbill.get("money").getClass() == Double.class) {
            money = (Double) arRecbill.get("money");
        } else if (arRecbill.get("money").getClass() == Integer.class) {
            money = (Integer) arRecbill.get("money");
        } else {
            return "无效金额";
        }

        if (arRecbill.get("local_money").getClass() == Double.class) {
            local_money = (Double) arRecbill.get("local_money");
        } else if (arRecbill.get("local_money").getClass() == Integer.class) {
            local_money = (Integer) arRecbill.get("local_money");
        } else {
            return "无效组织本币金额";
        }

        if (isEmpty((String) arRecbill.get("invoiceno"))) {
            return "发票号不能为空";
        } else {
            invoiceno = (String) arRecbill.get("invoiceno");
        }

        if (isEmpty((String) arRecbill.get("billstatus"))) {
            return "状态不能为空";
        } else {
            String TempBillstatus = (String) arRecbill.get("billstatus");
            if (TempBillstatus.matches("[0-5]")) {
                billstatus = TempBillstatus;
            } else {
                return "状态无效";
            }
        }


        ArRecbill new_arRecbill = new ArRecbill();

        new_arRecbill.setPk_org(pk_org);
        new_arRecbill.setPk_customer(pk_customer);
        new_arRecbill.setCreate_date(create_date);
        new_arRecbill.setDue_date(due_date);
        new_arRecbill.setBillmaker(billmaker);
        new_arRecbill.setPk_currency(pk_currency);
        new_arRecbill.setRate(rate);
        new_arRecbill.setMoney(money);
        new_arRecbill.setLocal_money(local_money);
        new_arRecbill.setInvoiceno(invoiceno);
        new_arRecbill.setBillstatus(billstatus);

        System.out.println(new_arRecbill);

        return insertArRecbill(new_arRecbill);
    }



    public String insertArRecbill(ArRecbill arRecbill) {

        arRecbillMapper.insert(arRecbill);

        System.out.println(arRecbill.getPk_recbill());

        return arRecbill.getPk_recbill();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
