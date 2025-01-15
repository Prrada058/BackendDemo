package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("ar_recbill")
public class ArRecbill {

    @TableId(value = "pk_recbill", type = IdType.AUTO)
    private String pk_recbill;

    private String pk_org;
    private String pk_customer;
    private LocalDateTime create_date;
    private LocalDateTime due_date;
    private String billmaker;
    private String pk_currency;
    private double rate;
    private double money;
    private double local_money;
    private String invoiceno;
    private String billstatus;

    @Override
    public String toString() {
        return "ArRecbill{" +
                "pk_recbill='" + pk_recbill + '\'' +
                ", pk_org='" + pk_org + '\'' +
                ", pk_customer='" + pk_customer + '\'' +
                ", create_date=" + create_date +
                ", due_date=" + due_date +
                ", billmaker='" + billmaker + '\'' +
                ", pk_currency='" + pk_currency + '\'' +
                ", rate=" + rate +
                ", money=" + money +
                ", local_money=" + local_money +
                ", invoiceno='" + invoiceno + '\'' +
                ", billstatus=" + billstatus +
                '}';
    }

    public String getPk_recbill() {
        return pk_recbill;
    }

    public void setPk_recbill(String pk_recbill) {
        this.pk_recbill = pk_recbill;
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

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
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

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(String billstatus) {
        this.billstatus = billstatus;
    }
}
