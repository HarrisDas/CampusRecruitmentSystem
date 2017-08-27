package com.example.harri.thecampusrecruitmentsystem.AccountInfoFlow;
import java.io.Serializable;
/**
 * Created by harri on 7/17/2017.
 */

public class CompanyInfo implements Serializable {

    private String companyUUID;
    private String companyEmail;
    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;
    private String companyWebPage;
    private Boolean companyVacancyAvailableCheck;
    private String companyURL;
    private String companyJobInfo;
    public CompanyInfo() {
    }

    public CompanyInfo(String companyUUID,
                       String companyEmail,
                       String companyName,
                       String companyAddress,
                       String companyPhoneNumber,
                       String companyWebPage,
                       Boolean companyVacancyAvailableCheck,
                       String companyURL,
                       String companyJobInfo
                       ) {

        this.companyUUID = companyUUID;
        this.companyEmail = companyEmail;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyWebPage = companyWebPage;
        this.companyVacancyAvailableCheck = companyVacancyAvailableCheck;
        this.companyURL = companyURL;
    this.companyJobInfo=companyJobInfo;;
    }

    public String getCompanyUUID() {
        return companyUUID;
    }

    public void setCompanyUUID(String companyUUID) {
        this.companyUUID = companyUUID;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCompanyWebPage() {
        return companyWebPage;
    }

    public void setCompanyWebPage(String companyWebPage) {
        this.companyWebPage = companyWebPage;
    }

    public Boolean getCompanyVacancyAvailableCheck() {
        return companyVacancyAvailableCheck;
    }

    public void setCompanyVacancyAvailableCheck(Boolean companyVacancyAvailableCheck) {
        this.companyVacancyAvailableCheck = companyVacancyAvailableCheck;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;
    }

    public String getCompanyJobInfo() {
        return companyJobInfo;
    }
    public void setCompanyJobInfo(String companyjobinfo) {
        this.companyJobInfo=companyjobinfo;
    }
}
