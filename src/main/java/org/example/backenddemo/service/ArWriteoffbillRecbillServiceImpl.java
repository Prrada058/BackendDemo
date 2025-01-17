package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArWriteoffbillRecbill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArWriteoffbillRecbillServiceImpl implements ArWriteoffbillRecbillService {

    @Autowired
    private ArRecbillService arRecbillService;


    @Override
    public ArWriteoffbillRecbill inputValidate(Map<String, Object> arWriteoffbillRecbill) {

        String pk_recbill;
        double money;

        if (isEmpty((String) arWriteoffbillRecbill.get("pk_recbill"))) {
            throw new IllegalArgumentException("应收单主键不能为空");
        } else {
            String TempPk_recbill = (String) arWriteoffbillRecbill.get("pk_recbill");
            if (arRecbillService.isRecbillExist(TempPk_recbill)) {
                pk_recbill = TempPk_recbill;
            } else {
                throw new IllegalArgumentException("应收单主键无效");
            }
        }

        if (arWriteoffbillRecbill.get("money").getClass() == Double.class) {
            money = (Double) arWriteoffbillRecbill.get("money");
        } else if (arWriteoffbillRecbill.get("money").getClass() == Integer.class) {
            money = (Integer) arWriteoffbillRecbill.get("money");
        } else {
            throw new IllegalArgumentException("应收单核销金额无效");
        }

        if (arRecbillService.getRecbillByPk(pk_recbill).getRemain_money() < money) {
            throw new IllegalArgumentException("应收单核销金额超过其剩余值");
        }

        ArWriteoffbillRecbill new_arWriteoffbillRecbill = new ArWriteoffbillRecbill();
        new_arWriteoffbillRecbill.setPk_recbill(pk_recbill);
        new_arWriteoffbillRecbill.setMoney(money);


        return new_arWriteoffbillRecbill;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
