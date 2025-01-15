package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("BD_CUSTOMER")
public class BdCustomer {
    @TableId(type = IdType.AUTO)
    private String pk_customer;
    private String name;

    @Override
    public String toString() {
        return "BdCustomer{" +
                "pk_customer='" + pk_customer + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPk_customer() {
        return pk_customer;
    }

    public void setPk_customer(String pk_customer) {
        this.pk_customer = pk_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
