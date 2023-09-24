package com.vansh.hospitalmanagement1.Hospital_Panel.Authentication;

public class Hospital {
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalEmail;
    private String hospitalPassword;
    private String hospitalPhone;
    private String hospitalLicense;

    private String hospitalKey;

    public Hospital() {
        // Default constructor required for Firebase
    }

    public Hospital(String hospitalKey,String hospitalName, String hospitalAddress, String hospitalEmail, String hospitalPassword, String hospitalPhone, String hospitalLicense) {
        this.hospitalKey = hospitalKey;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.hospitalEmail = hospitalEmail;
        this.hospitalPassword = hospitalPassword;
        this.hospitalPhone = hospitalPhone;
        this.hospitalLicense = hospitalLicense;
    }

    public String getHospitalKey() {
        return hospitalName;
    }

    public void setHospitalKey(String hospitalKey) {
        this.hospitalKey = hospitalKey;
    }
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getHospitalPassword() {
        return hospitalPassword;
    }

    public void setHospitalPassword(String hospitalPassword) {
        this.hospitalPassword = hospitalPassword;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    public String getHospitalLicense() {
        return hospitalLicense;
    }

    public void setHospitalLicense(String hospitalLicense) {
        this.hospitalLicense = hospitalLicense;
    }
}
