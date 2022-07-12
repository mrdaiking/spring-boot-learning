package com.appsdeveloperblog.app.ws.ui.model.request;

public class AddressRequestModel {
    private String city;
    private String country;
    private String costalCode;
    private String streetName;
    private String type;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCostalCode() {
        return costalCode;
    }

    public void setCostalCode(String costalCode) {
        this.costalCode = costalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
