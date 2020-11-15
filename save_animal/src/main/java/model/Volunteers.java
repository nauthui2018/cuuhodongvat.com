package model;

import java.util.Date;

public class Volunteers {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int addressID;
    private String mobile;
    private String email;
    private String image;
    private String personalCode;
    private int gender;
    private String registrationProgram;
    private String reasonForRegistration;
    private String status;
    private String[] statusList = {"Pending","Approved","Eliminated"};

    public Volunteers() {

    }

    public Volunteers(String firstName, String lastName, Date dateOfBirth, int addressID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addressID = addressID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
    }

    public Volunteers(int id, String firstName, String lastName, Date dateOfBirth, int addressID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addressID = addressID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
    }

    public Volunteers(int id, String firstName, String lastName, Date dateOfBirth, int addressID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addressID = addressID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
        this.status = status;
    }

    public Volunteers(String firstName, String lastName, Date dateOfBirth, int addressID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addressID = addressID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAddress() {
        return addressID;
    }

    public void setAddress(int addresID) {
        this.addressID = addresID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRegistrationProgram() {
        return registrationProgram;
    }

    public void setRegistrationProgram(String registrationProgram) {
        this.registrationProgram = registrationProgram;
    }

    public String getReasonForRegistration() {
        return reasonForRegistration;
    }

    public void setReasonForRegistration(String reasonForRegistration) {
        this.reasonForRegistration = reasonForRegistration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String[] getStatusList() {
        return statusList;
    }

    public void setStatusList(String[] statusList) {
        this.statusList = statusList;
    }

    public String viewGender(int gender) {
        switch (gender) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            case 3:
                return "Other Gender";
            default:
                return "-- Please select --";
        }
    }
}
