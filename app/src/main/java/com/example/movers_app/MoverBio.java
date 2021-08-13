package com.example.movers_app;

import java.util.Objects;

public class MoverBio {

    public String companyName, emailAddress, contactInfo, extraServices, inventory, pricePerDistance;



    public MoverBio(){

    }


    public MoverBio(String companyName, String contactInfo, String extraServices, String inventory, String pricePerDistance) {
        this.companyName = companyName;
        this.emailAddress = emailAddress;
        this.contactInfo = contactInfo;
        this.extraServices = extraServices;
        this.inventory = inventory;
        this.pricePerDistance = pricePerDistance;
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public String getInventory() {
        return inventory;
    }

    public String getPricePerDistance() {
        return pricePerDistance;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public void setPricePerDistance(String pricePerDistance) {
        this.pricePerDistance = pricePerDistance;
    }


}





//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MoverBio moverBio = (MoverBio) o;
//        return companyName.equals(moverBio.companyName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(companyName);
//    }
//}
