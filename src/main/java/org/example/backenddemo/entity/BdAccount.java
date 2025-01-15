package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bd_account")
public class BdAccount {
    @TableId(type = IdType.AUTO)
    private String pk_account;
    private String name;

    public String getPk_account() {
        return pk_account;
    }

    public void setPk_account(String pk_account) {
        this.pk_account = pk_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
