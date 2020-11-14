package model;

public class Report {
    private int reportID;
    private String reportAddress;
    private String reportDescription;
    private String reportPersonName;
    private String reportEmail;
    private String reportPhone;
    private String reportStatus;
    private String[] statusList = {"Chưa làm","Đang làm", "Xong rồi"};

    public String[] getStatusList() {
        return statusList;
    }

    public void setStatusList(String[] statusList) {
        this.statusList = statusList;
    }

    public Report() {
    }

    public Report(int reportID, String reportAddress, String reportDescription, String reportPersonName, String reportEmail, String reportPhone, String reportStatus) {
        this.reportID = reportID;
        this.reportAddress = reportAddress;
        this.reportDescription = reportDescription;
        this.reportPersonName = reportPersonName;
        this.reportEmail = reportEmail;
        this.reportPhone = reportPhone;
        this.reportStatus = reportStatus;
    }

    public Report(String reportAddress, String reportDescription, String reportPersonName, String reportEmail, String reportPhone) {
        this.reportAddress = reportAddress;
        this.reportDescription = reportDescription;
        this.reportPersonName = reportPersonName;
        this.reportEmail = reportEmail;
        this.reportPhone = reportPhone;
    }

    public Report(String reportAddress, String reportDescription, String reportPersonName, String reportEmail, String reportPhone,String reportStatus) {
        this.reportAddress = reportAddress;
        this.reportDescription = reportDescription;
        this.reportPersonName = reportPersonName;
        this.reportEmail = reportEmail;
        this.reportPhone = reportPhone;
        this.reportStatus=reportStatus;
    }
    public Report(int reportID, String reportAddress, String reportDescription, String reportPersonName, String reportEmail, String reportPhone) {
        this.reportID=reportID;
        this.reportAddress = reportAddress;
        this.reportDescription = reportDescription;
        this.reportPersonName = reportPersonName;
        this.reportEmail = reportEmail;
        this.reportPhone = reportPhone;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getReportAddress() {
        return reportAddress;
    }

    public void setReportAddress(String reportAddress) {
        this.reportAddress = reportAddress;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportPersonName() {
        return reportPersonName;
    }

    public void setReportPersonName(String reportPersonName) {
        this.reportPersonName = reportPersonName;
    }

    public String getReportEmail() {
        return reportEmail;
    }

    public void setReportEmail(String reportEmail) {
        this.reportEmail = reportEmail;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

}
