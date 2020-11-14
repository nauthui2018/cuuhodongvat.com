package model;

import java.util.List;

public class Donor {
    private int donorID;
    private String donorName;
    private String donorSurrogate;
    private String donorAddress;
    private String donorEmail;
    private String donorPhone;
    private Double donorMoney;
    private Double donorTotalMoney;
    private String donorImage;

//    private List<HoatDong> hoatDongList;


    public int getDonorID() {
        return donorID;
    }

    public void setDonorID(int donorID) {
        this.donorID = donorID;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorSurrogate() {
        return donorSurrogate;
    }

    public void setDonorSurrogate(String donorSurrogate) {
        this.donorSurrogate = donorSurrogate;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }

    public Double getDonorMoney() {
        return donorMoney;
    }

    public void setDonorMoney(Double donorMoney) {
        this.donorMoney = donorMoney;
    }

    public Double getDonorTotalMoney() {
        return donorTotalMoney;
    }

    public void setDonorTotalMoney(Double donorTotalMoney) {
        this.donorTotalMoney = donorTotalMoney;
    }

    public String getDonorImage() {
        return donorImage;
    }

    public void setDonorImage(String donorImage) {
        this.donorImage = donorImage;
    }

    public Donor(int donorID, String donorName, String donorSurrogate, String donorAddress, String donorEmail, String donorPhone, Double donorMoney, Double donorTotalMoney, String donorImage) {
        this.donorID = donorID;
        this.donorName = donorName;
        this.donorSurrogate = donorSurrogate;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.donorPhone = donorPhone;
        this.donorMoney = donorMoney;
        this.donorTotalMoney = donorTotalMoney;
        this.donorImage=donorImage;

    }
    public Donor(String donorName, String donorSurrogate, String donorAddress, String donorEmail, String donorPhone, Double donorMoney, Double donorTotalMoney,String donorImage) {
        this.donorName = donorName;
        this.donorSurrogate = donorSurrogate;
        this.donorAddress = donorAddress;
        this.donorEmail = donorEmail;
        this.donorPhone = donorPhone;
        this.donorMoney = donorMoney;
        this.donorTotalMoney = donorTotalMoney;
        this.donorImage=donorImage;
    }
}
