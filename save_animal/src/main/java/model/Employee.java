package com.project.teamLongHuongNguyen.model;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
    private int employeeID;
    private String employeeName;
    private String employeePosition;
    private String employeeGroup;
    private String employeeDescription;
    private Date employeeDOB;
    private String employeeDegree;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private String employeeCMND;

    private Province employeeProvince;

    private String employeeImage;
    private String employeeGender;
    private Date employeeJoinDate;
    private String[] genderList = {"Nam", "Nữ", "LGBT"};
//    private String[] groupList = {"A", "B", "C","D"};
    private String[] positionList = {"Giám đốc Trung Tâm", "Phó Giám đốc", "Quản lý tài chính","Cán bộ Hành chính và Nhân sự","Bác sĩ thú y","Trưởng nhóm chăm sóc động vật","Nhân viên chăm sóc động vật"};
    private String[] degreeList = {"Tiến sĩ","Thạc sĩ", "Đại học","Cao đẳng","Trung cấp","Trung học phổ thông","Khác"};


    public Employee() {
    }

    public String[] getGenderList() {
        return genderList;
    }

    public void setGenderList(String[] genderList) {
        this.genderList = genderList;
    }

    public String[] getPositionList() {
        return positionList;
    }

    public void setPositionList(String[] positionList) {
        this.positionList = positionList;
    }

    public String[] getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(String[] degreeList) {
        this.degreeList = degreeList;
    }

    public Employee(int employeeID, String employeeName, String employeePosition, String employeeGroup, String employeeDescription, Date employeeDOB, String employeeDegree, String employeeEmail, String employeePhone, String employeeAddress, String employeeCMND, Province employeeProvince, String employeeImage, String employeeGender, Date employeeJoinDate) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeGroup = employeeGroup;
        this.employeeDescription = employeeDescription;
        this.employeeDOB = employeeDOB;
        this.employeeDegree = employeeDegree;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeCMND = employeeCMND;
        this.employeeProvince = employeeProvince;
        this.employeeImage = employeeImage;
        this.employeeGender = employeeGender;
        this.employeeJoinDate = employeeJoinDate;
    }

    public Employee(String employeeName, String employeePosition, String employeeGroup, String employeeDescription, Date employeeDOB, String employeeDegree, String employeeEmail, String employeePhone, String employeeAddress, String employeeCMND, Province employeeProvince, String employeeImage, String employeeGender, Date employeeJoinDate) {
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeGroup = employeeGroup;
        this.employeeDescription = employeeDescription;
        this.employeeDOB = employeeDOB;
        this.employeeDegree = employeeDegree;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
        this.employeeCMND = employeeCMND;
        this.employeeProvince = employeeProvince;
        this.employeeImage = employeeImage;
        this.employeeGender = employeeGender;
        this.employeeJoinDate = employeeJoinDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public String getEmployeeDescription() {
        return employeeDescription;
    }

    public void setEmployeeDescription(String employeeDescription) {
        this.employeeDescription = employeeDescription;
    }

    public Date getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(Date employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public String getEmployeeDegree() {
        return employeeDegree;
    }

    public void setEmployeeDegree(String employeeDegree) {
        this.employeeDegree = employeeDegree;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeCMND() {
        return employeeCMND;
    }

    public void setEmployeeCMND(String employeeCMND) {
        this.employeeCMND = employeeCMND;
    }

    public Province getEmployeeProvince() {
        return employeeProvince;
    }

    public void setEmployeeProvince(Province employeeProvince) {
        this.employeeProvince = employeeProvince;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Date getEmployeeJoinDate() {
        return employeeJoinDate;
    }

    public void setEmployeeJoinDate(Date employeeJoinDate) {
        this.employeeJoinDate = employeeJoinDate;
    }
}
