package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArWriteoffbill;
import org.example.backenddemo.entity.ArWriteoffbillGatherbill;
import org.example.backenddemo.entity.ArWriteoffbillRecbill;
import org.example.backenddemo.mapper.ArWriteoffbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class ArWriteoffbillServiceImpl implements ArWriteoffbillService {

    @Autowired
    private ArWriteoffbillMapper arWriteoffbillMapper;

    @Autowired
    private BdOrgService bdOrgService;

    @Autowired
    private BdCustomerService bdCustomerService;

    @Autowired
    private BdAccountService bdAccountService;

    @Autowired
    private ArWriteoffbillGatherbillService arWriteoffbillGatherbillService;

    @Autowired
    private ArWriteoffbillRecbillService arWriteoffbillRecbillService;

    @Autowired
    private ArGatherbillService arGatherbillService;

    @Autowired
    private ArRecbillService arRecbillService;


    @Override
    public String inputValidate(Map<String, Object> arWriteoffbill) {

        String pk_org;
        String pk_customer;
        LocalDateTime create_date;
        String billmaker;
        String bill_status;

        System.out.println(arWriteoffbill);


        if (isEmpty((String) arWriteoffbill.get("pk_org"))) {
            return "组织不能为空";
        } else {
            String TempPk_org = (String) arWriteoffbill.get("pk_org");
            if (bdOrgService.isOrgExist(TempPk_org)) {
                pk_org = TempPk_org;
            } else {
                return "无效组织";
            }
        }

        if (isEmpty((String) arWriteoffbill.get("pk_customer"))) {
            return "客户不能为空";
        } else {
            String TempPk_customer = (String) arWriteoffbill.get("pk_customer");
            if (bdCustomerService.isCustomerExist(TempPk_customer)) {
                pk_customer = TempPk_customer;
            } else {
                return "无效客户";
            }
        }

        if (isEmpty((String) arWriteoffbill.get("create_date"))) {
            return "创建时间不能为空";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            create_date = LocalDateTime.parse((String) arWriteoffbill.get("create_date"), formatter);
        }


        if (isEmpty((String) arWriteoffbill.get("billmaker"))) {
            return "制单人不能为空";
        } else {
            String TempBillmaker = (String) arWriteoffbill.get("billmaker");
            if (bdAccountService.isAccountExist(TempBillmaker)) {
                billmaker = TempBillmaker;
            } else {
                return "无效制单人用户";
            }
        }

        if (isEmpty((String) arWriteoffbill.get("bill_status"))) {
            return "状态不能为空";
        } else {
            String TempBill_status = (String) arWriteoffbill.get("bill_status");
            if (TempBill_status.matches("[0-5]")) {
                bill_status = TempBill_status;
            } else {
                return "状态无效";
            }
        }


        List<ArWriteoffbillGatherbill> gatherbillList = new ArrayList<>();

        if (arWriteoffbill.get("gatherbill") == null || Objects.equals(arWriteoffbill.get("gatherbill").toString(), "[]")) {
            return "空收款单";
        } else {
            for (Object item : (List) arWriteoffbill.get("gatherbill")) {
                try {
                    ArWriteoffbillGatherbill newBill;
                    newBill = arWriteoffbillGatherbillService.inputValidate((Map<String, Object>) item);
                    for (ArWriteoffbillGatherbill bill : gatherbillList) {
                        if (bill.getPk_gatherbill().equals(newBill.getPk_gatherbill())) {
                            return "收款单主键重复";
                        }
                    }
                    gatherbillList.add(newBill);

                } catch (Exception e) {
                    return e.getMessage();
                }
                System.out.println(gatherbillList);
            }
        }


        List<ArWriteoffbillRecbill> recbillList = new ArrayList<>();

        if (arWriteoffbill.get("recbill") == null || Objects.equals(arWriteoffbill.get("recbill").toString(), "[]")) {
            return "空应收单";
        } else {
            for (Object item : (List) arWriteoffbill.get("recbill")) {
                try {
                    ArWriteoffbillRecbill newBill;
                    newBill = arWriteoffbillRecbillService.inputValidate((Map<String, Object>) item);
                    for (ArWriteoffbillRecbill bill : recbillList) {
                        if (bill.getPk_recbill().equals(newBill.getPk_recbill())) {
                            return "应收单主键重复";
                        }
                    }
                    recbillList.add(newBill);

                } catch (Exception e) {
                    return e.getMessage();
                }
                System.out.println(recbillList);
            }
        }


        double gatherbillTotal = 0;
        for (ArWriteoffbillGatherbill item : gatherbillList) {
            gatherbillTotal += item.getMoney();
        }

        double recbillTotal = 0;
        for (ArWriteoffbillRecbill item : recbillList) {
            recbillTotal += item.getMoney();
        }

        double epsilon = 1e-9; // 防止小数爆掉

        if (Math.abs(gatherbillTotal - recbillTotal) > epsilon) {
            return "应收单和收款单费用不一致，无法核销";
        }

        ArWriteoffbill new_arWriteoffbill = new ArWriteoffbill();

        new_arWriteoffbill.setPk_org(pk_org);
        new_arWriteoffbill.setPk_customer(pk_customer);
        new_arWriteoffbill.setBillmaker(billmaker);
        new_arWriteoffbill.setCreate_date(create_date);
        new_arWriteoffbill.setBill_status(bill_status);

        String pk_ar_writeoffbill = insertArWriteoffbill(new_arWriteoffbill);

        for (ArWriteoffbillGatherbill item : gatherbillList) {
            item.setPk_ar_writeoffbill(pk_ar_writeoffbill);
            arGatherbillService.writeoff(item.getPk_gatherbill(), item.getMoney());
            arWriteoffbillGatherbillService.insertArWriteoffbillGatherbill(item);


        }

        for (ArWriteoffbillRecbill item : recbillList) {
            item.setPk_ar_writeoffbill(pk_ar_writeoffbill);
            arRecbillService.writeoff(item.getPk_recbill(), item.getMoney());
            arWriteoffbillRecbillService.insertArWriteoffbillRecbill(item);
        }


        return pk_ar_writeoffbill;
    }

    private String insertArWriteoffbill(ArWriteoffbill arWriteoffbill) {
        arWriteoffbillMapper.insert(arWriteoffbill);
        System.out.println(arWriteoffbill.getPk_ar_writeoffbill());
        return arWriteoffbill.getPk_ar_writeoffbill();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
