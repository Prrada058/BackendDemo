package org.example.backenddemo.dto;

public class LoginRequest {
    private String accName;
    private String accPassword;
    private String accToken;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "accName='" + accName + '\'' +
                ", accPassword='" + accPassword + '\'' +
                ", accToken='" + accToken + '\'' +
                '}';
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

    public String getAccToken() {
        return accToken;
    }

    public void setAccToken(String accToken) {
        this.accToken = accToken;
    }
}
