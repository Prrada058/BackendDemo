package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ar_writeoffbill_gatherbill")
public class ArWriteoffbillGatherbill {

    @TableId(value = "pk_ar_writeoffbill_gatherbill", type = IdType.AUTO)
    private String pk_ar_writeoffbill_gatherbill;
    private String pk_ar_writeoffbill;
    private String pk_gatherbill;
    private double money;

    @Override
    public String toString() {
        return "ArWriteoffbillGatherbill{" +
                "pk_ar_writeoffbill_gatherbill='" + pk_ar_writeoffbill_gatherbill + '\'' +
                ", pk_ar_writeoffbill='" + pk_ar_writeoffbill + '\'' +
                ", pk_gatherbill='" + pk_gatherbill + '\'' +
                ", money=" + money +
                '}';
    }

    public String getPk_ar_writeoffbill_gatherbill() {
        return pk_ar_writeoffbill_gatherbill;
    }

    public void setPk_ar_writeoffbill_gatherbill(String pk_ar_writeoffbill_gatherbill) {
        this.pk_ar_writeoffbill_gatherbill = pk_ar_writeoffbill_gatherbill;
    }

    public String getPk_ar_writeoffbill() {
        return pk_ar_writeoffbill;
    }

    public void setPk_ar_writeoffbill(String pk_ar_writeoffbill) {
        this.pk_ar_writeoffbill = pk_ar_writeoffbill;
    }

    public String getPk_gatherbill() {
        return pk_gatherbill;
    }

    public void setPk_gatherbill(String pk_gatherbill) {
        this.pk_gatherbill = pk_gatherbill;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
