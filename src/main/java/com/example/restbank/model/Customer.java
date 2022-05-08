package com.example.restbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    private String customerName;
    private String city;
    private String state;
    private String country;
    private int phoneNo;
    private String password;

    public Customer() {

    }

    public Customer(int accountID, String customerName, String city, String state, String country, int phoneNo,
                    String password) {
        super();
        this.accountID = accountID;
        this.customerName = customerName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int acctID) {
        this.accountID = acctID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String custName) {
        this.customerName = custName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return accountID == customer.accountID && phoneNo == customer.phoneNo && Objects.equals(customerName, customer.customerName) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(country, customer.country) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, customerName, city, state, country, phoneNo, password);
    }
}