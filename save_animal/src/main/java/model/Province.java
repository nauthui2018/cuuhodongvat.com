package com.project.teamLongHuongNguyen.model;

public class Province {
    private int provinceID;
    private String provinceName;
    private String provinceCode;

    public Province(int provinceID, String provinceName, String provinceCode) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
