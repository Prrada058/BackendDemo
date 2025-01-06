package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Account {
    @TableId(type = IdType.AUTO)
    private int accId;
    private String accName;
    private String accPassword;
    private String accEmail;
    private String accProfilePhoto;

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", accPassword='" + accPassword + '\'' +
                ", accEmail='" + accEmail + '\'' +
                ", accProfilePhoto='" + accProfilePhoto + '\'' +
                '}';
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    public String getAccEmail() {
        return accEmail;
    }

    public void setAccEmail(String accEmail) {
        this.accEmail = accEmail;
    }

    public String getAccProfilePhoto() {
        return accProfilePhoto;
    }

    public void setAccProfilePhoto(String accProfilePhoto) {
        this.accProfilePhoto = accProfilePhoto;
    }
}
