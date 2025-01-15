package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bd_org")
public class BdOrg {
    @TableId(type = IdType.AUTO)
    private String pk_org;
    private String name;
    private String pk_currency;

    @Override
    public String toString() {
        return "BdOrg{" +
                "pk_org=" + pk_org +
                ", name='" + name + '\'' +
                ", currency='" + pk_currency + '\'' +
                '}';
    }

    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk_currency() {
        return pk_currency;
    }

    public void setPk_currency(String pk_currency) {
        this.pk_currency = pk_currency;
    }
}

