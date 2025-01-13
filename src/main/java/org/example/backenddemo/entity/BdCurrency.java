package org.example.backenddemo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bd_currency")
public class BdCurrency {
    @TableId
    private String pk_currency;
    private String name;

    @Override
    public String toString() {
        return "BdCurrency{" +
                "pk_currency='" + pk_currency + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPk_currency() {
        return pk_currency;
    }

    public void setPk_currency(String pk_currency) {
        this.pk_currency = pk_currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
