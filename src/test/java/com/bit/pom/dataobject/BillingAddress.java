package com.bit.pom.dataobject;

public class BillingAddress {

    private String firstName;   // = "demo";
    private String lastName;   //  = "user";
    private String companyName;   //  = "My Infotech Company";
    private String country;   //  = "India";
    private String address_1;   //  = "123,BTM";
    private String address_2;   //  = "Near My Landmark";
    private String city;   //  = "Bangalore";
    private String state;   //  = "Karnataka";
    private String postcode;   //  = "560039";
    private String phone;   //  = "9878767656";
    private String email;   //  = "MyName@email.com";

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String companyName, String country, String address_1, String address_2, String city, String state, String postcode, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BillingAddress setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public BillingAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress_1() {
        return address_1;
    }

    public BillingAddress setAddress_1(String address_1) {
        this.address_1 = address_1;
        return this;
    }

    public String getAddress_2() {
        return address_2;
    }

    public BillingAddress setAddress_2(String address_2) {
        this.address_2 = address_2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public BillingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public BillingAddress setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BillingAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }
}
