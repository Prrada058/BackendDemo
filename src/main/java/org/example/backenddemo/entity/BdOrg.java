package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bd_org")
public class BdOrg {
    @TableId(type = IdType.AUTO)
    private int pk_org;
    private String name;
    private String currency;

    @Override
    public String toString() {
        return "BdOrg{" +
                "pk_org=" + pk_org +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public int getPk_org() {
        return pk_org;
    }

    public void setPk_org(int pk_org) {
        this.pk_org = pk_org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

