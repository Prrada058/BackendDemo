package org.example.backenddemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ArRecbillFull {
    private String recbillid;
    private String orgId;
    private String orgName;
    private String orgDefaultCurrency;
    private String customerid;
    private String customerName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recbillCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recbillDueDate;
    private String recbillCreaterId;
    private String recbillCreaterName;
    private String recbillCurrencyId;
    private String recbillCurrencyName;
    private double recbillCurrencyRate;
    private double recbillMoney;
    private double recbillLocalMoney;
    private String recbillInvoiceNo;
    private String recbillStatus;

    @Override
    public String toString() {
        return "ArRecbillFull{" +
                "recbillid='" + recbillid + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgDefaultCurrency='" + orgDefaultCurrency + '\'' +
                ", customerid='" + customerid + '\'' +
                ", customerName='" + customerName + '\'' +
                ", recbillCreateDate=" + recbillCreateDate +
                ", recbillDueDate=" + recbillDueDate +
                ", recbillCreaterId='" + recbillCreaterId + '\'' +
                ", recbillCreaterName='" + recbillCreaterName + '\'' +
                ", recbillCurrencyId='" + recbillCurrencyId + '\'' +
                ", recbillCurrencyName='" + recbillCurrencyName + '\'' +
                ", recbillCurrencyRate=" + recbillCurrencyRate +
                ", recbillMoney=" + recbillMoney +
                ", recbillLocalMoney=" + recbillLocalMoney +
                ", recbillInvoiceNo='" + recbillInvoiceNo + '\'' +
                ", recbillStatus=" + recbillStatus +
                '}';
    }

    public String getRecbillid() {
        return recbillid;
    }

    public void setRecbillid(String recbillid) {
        this.recbillid = recbillid;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDefaultCurrency() {
        return orgDefaultCurrency;
    }

    public void setOrgDefaultCurrency(String orgDefaultCurrency) {
        this.orgDefaultCurrency = orgDefaultCurrency;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getRecbillCreateDate() {
        return recbillCreateDate;
    }

    public void setRecbillCreateDate(LocalDateTime recbillCreateDate) {
        this.recbillCreateDate = recbillCreateDate;
    }

    public LocalDateTime getRecbillDueDate() {
        return recbillDueDate;
    }

    public void setRecbillDueDate(LocalDateTime recbillDueDate) {
        this.recbillDueDate = recbillDueDate;
    }

    public String getRecbillCreaterId() {
        return recbillCreaterId;
    }

    public void setRecbillCreaterId(String recbillCreaterId) {
        this.recbillCreaterId = recbillCreaterId;
    }

    public String getRecbillCreaterName() {
        return recbillCreaterName;
    }

    public void setRecbillCreaterName(String recbillCreaterName) {
        this.recbillCreaterName = recbillCreaterName;
    }

    public String getRecbillCurrencyId() {
        return recbillCurrencyId;
    }

    public void setRecbillCurrencyId(String recbillCurrencyId) {
        this.recbillCurrencyId = recbillCurrencyId;
    }

    public String getRecbillCurrencyName() {
        return recbillCurrencyName;
    }

    public void setRecbillCurrencyName(String recbillCurrencyName) {
        this.recbillCurrencyName = recbillCurrencyName;
    }

    public double getRecbillCurrencyRate() {
        return recbillCurrencyRate;
    }

    public void setRecbillCurrencyRate(double recbillCurrencyRate) {
        this.recbillCurrencyRate = recbillCurrencyRate;
    }

    public double getRecbillMoney() {
        return recbillMoney;
    }

    public void setRecbillMoney(double recbillMoney) {
        this.recbillMoney = recbillMoney;
    }

    public double getRecbillLocalMoney() {
        return recbillLocalMoney;
    }

    public void setRecbillLocalMoney(double recbillLocalMoney) {
        this.recbillLocalMoney = recbillLocalMoney;
    }

    public String getRecbillInvoiceNo() {
        return recbillInvoiceNo;
    }

    public void setRecbillInvoiceNo(String recbillInvoiceNo) {
        this.recbillInvoiceNo = recbillInvoiceNo;
    }

    public String getRecbillStatus() {
        return recbillStatus;
    }

    public void setRecbillStatus(String recbillStatus) {
        this.recbillStatus = recbillStatus;
    }
}
