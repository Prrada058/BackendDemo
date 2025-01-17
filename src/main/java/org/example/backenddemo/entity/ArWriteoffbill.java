package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("ar_writeoffbill")
public class ArWriteoffbill {
    @TableId(value = "pk_ar_writeoffbill", type = IdType.AUTO)
    private String pk_ar_writeoffbill;
    private String pk_org;
    private String pk_customer;
    private LocalDateTime create_date;
    private String billmaker;
    private String bill_status;

    @Override
    public String toString() {
        return "ArWriteoffbill{" +
                "pk_ar_writeoffbill='" + pk_ar_writeoffbill + '\'' +
                ", pk_org='" + pk_org + '\'' +
                ", pk_customer='" + pk_customer + '\'' +
                ", create_date=" + create_date +
                ", billmaker='" + billmaker + '\'' +
                ", bill_status='" + bill_status + '\'' +
                '}';
    }

    public String getPk_ar_writeoffbill() {
        return pk_ar_writeoffbill;
    }

    public void setPk_ar_writeoffbill(String pk_ar_writeoffbill) {
        this.pk_ar_writeoffbill = pk_ar_writeoffbill;
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

    public String getBill_status() {
        return bill_status;
    }

    public void setBill_status(String bill_status) {
        this.bill_status = bill_status;
    }
}
