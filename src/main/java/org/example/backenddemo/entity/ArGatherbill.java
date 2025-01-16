package org.example.backenddemo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("ar_gatherbill")
public class ArGatherbill {

    @TableId(value = "pk_gatherbill" , type = IdType.AUTO)
    private String pk_gatherbill;

    private String pk_org;
    private String pk_customer;
    private LocalDateTime create_date;
    private String billmaker;
    private String pk_currency;
    private double rate;
    private double money;
    private double local_money;
    private String billstatus;
    private String settleflag;
    private String pk_recbill;

    @Override
    public String toString() {
        return "ArGatherbill{" +
                "pk_gatherbill='" + pk_gatherbill + '\'' +
                ", pk_org='" + pk_org + '\'' +
                ", pk_customer='" + pk_customer + '\'' +
                ", create_date=" + create_date +
                ", billmaker='" + billmaker + '\'' +
                ", pk_currency='" + pk_currency + '\'' +
                ", rate=" + rate +
                ", money=" + money +
                ", local_money=" + local_money +
                ", billstatus='" + billstatus + '\'' +
                ", settleflag='" + settleflag + '\'' +
                ", pk_recbill='" + pk_recbill + '\'' +
                '}';
    }

    public String getPk_gatherbill() {
        return pk_gatherbill;
    }

    public void setPk_gatherbill(String pk_gatherbill) {
        this.pk_gatherbill = pk_gatherbill;
    }

    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getPk_customer() {
        return pk_customer;
    }

    public void setPk_customer(String pk_customer) {
        this.pk_customer = pk_customer;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getBillmaker() {
        return billmaker;
    }

    public void setBillmaker(String billmaker) {
        this.billmaker = billmaker;
    }

    public String getPk_currency() {
        return pk_currency;
    }

    public void setPk_currency(String pk_currency) {
        this.pk_currency = pk_currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLocal_money() {
        return local_money;
    }

    public void setLocal_money(double local_money) {
        this.local_money = local_money;
    }

    public String getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(String billstatus) {
        this.billstatus = billstatus;
    }

    public String getSettleflag() {
        return settleflag;
    }

    public void setSettleflag(String settleflag) {
        this.settleflag = settleflag;
    }

    public String getPk_recbill() {
        return pk_recbill;
    }

    public void setPk_recbill(String pk_recbill) {
        this.pk_recbill = pk_recbill;
    }
}
