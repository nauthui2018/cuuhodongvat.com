package model;

public class Animals {
    private int id;
    private String name;
    private String image;
    private String description;
    private int protectionLevel;
    private int staffID;

    public Animals() {
    }

    public Animals(String name, String image, String description, int protectionLevel, int staffID) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.protectionLevel = protectionLevel;
        this.staffID = staffID;
    }

    public Animals(int id, String name, String image, String description, int protectionLevel, int staffID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.protectionLevel = protectionLevel;
        this.staffID = staffID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String viewProtectionLevel(int protectionLevel) {
        switch (protectionLevel) {
            case 1:
                return "Extinct";
            case 2:
                return "Extinct in the Wild";
            case 3:
                return "Critically Endangered";
            case 4:
                return "Endangered";
            case 5:
                return "Vulnerable";
            case 6:
                return "Near threatened";
            case 7:
                return "Least concern";
            case 8:
                return "Data deficient";
            case 9:
                return "Not evaluated";
            case 10:
                return "Possibly Extinct";
            default:
                return "-- Please select --";
        }

    }
}
