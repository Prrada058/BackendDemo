package org.example.backenddemo.dto;

public class BdOrgFull {
    private String orgId;
    private String orgName;
    private String currencyId;
    private String currencyName;

    @Override
    public String toString() {
        return "BdOrg{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", currencyName='" + currencyName + '\'' +
                '}';
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

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
