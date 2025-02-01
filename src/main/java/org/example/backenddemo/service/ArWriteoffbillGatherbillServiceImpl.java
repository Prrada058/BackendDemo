package org.example.backenddemo.service;

import org.example.backenddemo.entity.ArWriteoffbillGatherbill;
import org.example.backenddemo.mapper.ArWriteoffbillGatherbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArWriteoffbillGatherbillServiceImpl implements ArWriteoffbillGatherbillService {

    @Autowired
    private ArGatherbillService arGatherbillService;

    @Autowired
    private ArWriteoffbillGatherbillMapper arWriteoffbillGatherbillMapper;


    @Override
    public ArWriteoffbillGatherbill inputValidate(Map<String, Object> arWriteoffbillGatherbill) {

        String pk_gatherbill;
        double money;


        if (isEmpty((String) arWriteoffbillGatherbill.get("pk_gatherbill"))) {
            throw new IllegalArgumentException("收款单主键不能为空");
        } else {
            String TempPk_gatherbill = (String) arWriteoffbillGatherbill.get("pk_gatherbill");
            if (arGatherbillService.isGatherbillExist(TempPk_gatherbill)) {
                pk_gatherbill = TempPk_gatherbill;
            } else {
                throw new IllegalArgumentException("收款单主键无效");
            }
        }

        if (arWriteoffbillGatherbill.get("money").getClass() == Double.class) {
            money = (Double) arWriteoffbillGatherbill.get("money");
        } else if (arWriteoffbillGatherbill.get("money").getClass() == Integer.class) {
            money = (Integer) arWriteoffbillGatherbill.get("money");
        } else {
            throw new IllegalArgumentException("收款单核销金额无效");
        }

        if (arGatherbillService.getGatherbillByPk(pk_gatherbill).getRemain_money() < money) {
            throw new IllegalArgumentException("收款单核销金额超过其剩余值");
        }

        ArWriteoffbillGatherbill new_arWriteoffbillGatherbill = new ArWriteoffbillGatherbill();
        new_arWriteoffbillGatherbill.setPk_gatherbill(pk_gatherbill);
        new_arWriteoffbillGatherbill.setMoney(money);


        return new_arWriteoffbillGatherbill;
    }

    @Override
    public String insertArWriteoffbillGatherbill(ArWriteoffbillGatherbill arWriteoffbillGatherbill) {
        arWriteoffbillGatherbillMapper.insert(arWriteoffbillGatherbill);
        return arWriteoffbillGatherbill.getPk_ar_writeoffbill_gatherbill();
    }

    public List<ArWriteoffbillGatherbill> selectArWriteoffbillGatherbillBy;

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
