package com.Task2.jdbcmodel;

public class FirstModelForReport {
    private String groupName;
    private String productName;
    private Integer allPrihod;
    private String prihodTime;
    private Integer allRashod;
    private String rashodDate;

    public FirstModelForReport() {
    }

    public String getGroupName() {
        return groupName;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getAllPrihod() {
        return allPrihod;
    }

    public String getPrihodTime() {
        return prihodTime;
    }

    public Integer getAllRashod() {
        return allRashod;
    }

    public String getRashodDate() {
        return rashodDate;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAllPrihod(Integer allPrihod) {
        this.allPrihod = allPrihod;
    }

    public void setPrihodTime(String prihodTime) {
        this.prihodTime = prihodTime;
    }

    public void setAllRashod(Integer allRashod) {
        this.allRashod = allRashod;
    }

    public void setRashodDate(String rashodDate) {
        this.rashodDate = rashodDate;
    }
}
