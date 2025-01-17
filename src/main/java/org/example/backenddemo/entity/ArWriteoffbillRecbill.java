package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ar_writeoffbill_recbill")
public class ArWriteoffbillRecbill {
    @TableId(value = "pk_ar_writeoffbill_recbill", type = IdType.AUTO)
    private String pk_ar_writeoffbill_recbill;
    private String pk_ar_writeoffbill;
    private String pk_recbill;
    private double money;

    @Override
    public String toString() {
        return "ArWriteoffbillRecbill{" +
                "pk_ar_writeoffbill_recbill='" + pk_ar_writeoffbill_recbill + '\'' +
                ", pk_ar_writeoffbill='" + pk_ar_writeoffbill + '\'' +
                ", pk_recbill='" + pk_recbill + '\'' +
                ", money=" + money +
                '}';
    }

    public String getPk_ar_writeoffbill_recbill() {
        return pk_ar_writeoffbill_recbill;
    }

    public void setPk_ar_writeoffbill_recbill(String pk_ar_writeoffbill_recbill) {
        this.pk_ar_writeoffbill_recbill = pk_ar_writeoffbill_recbill;
    }

    public String getPk_ar_writeoffbill() {
        return pk_ar_writeoffbill;
    }

    public void setPk_ar_writeoffbill(String pk_ar_writeoffbill) {
        this.pk_ar_writeoffbill = pk_ar_writeoffbill;
    }

    public String getPk_recbill() {
        return pk_recbill;
    }

    public void setPk_recbill(String pk_recbill) {
        this.pk_recbill = pk_recbill;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
