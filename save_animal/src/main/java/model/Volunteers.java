package model;

import java.util.Date;

public class Volunteers {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int addresID;
    private String mobile;
    private String email;
    private String image;
    private String personalCode;
    private int gender;
    private String registrationProgram;
    private String reasonForRegistration;
    private int status = 1;

    public Volunteers() {

    }

    public Volunteers(String firstName, String lastName, Date dateOfBirth, int addresID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addresID = addresID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
    }

    public Volunteers(int id, String firstName, String lastName, Date dateOfBirth, int addresID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addresID = addresID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
    }

    public Volunteers(int id, String firstName, String lastName, Date dateOfBirth, int addresID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration, int status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addresID = addresID;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
        this.personalCode = personalCode;
        this.gender = gender;
        this.registrationProgram = registrationProgram;
        this.reasonForRegistration = reasonForRegistration;
        this.status = status;
    }

    public Volunteers(String firstName, String lastName, Date dateOfBirth, int addresID, String mobile, String email, String image, String personalCode, int gender, String registrationProgram, String reasonForRegistration, int status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.addresID = addresID;
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
        return addresID;
    }

    public void setAddress(int addresID) {
        this.addresID = addresID;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAddresID() {
        return addresID;
    }

    public void setAddresID(int addresID) {
        this.addresID = addresID;
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

    public String viewStatus(int status) {
        switch (status) {
            case 1:
                return "Pending";
            case 2:
                return "Approved";
            case 3:
                return "Eliminated";
            default:
                return "-- Please select --";
        }

    }
}

