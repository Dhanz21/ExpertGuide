package com.trekExpert.expertguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerId;

    private String customerName;

    private String email;

    private boolean isPreviliged;

    private String postcode;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String email, boolean isPreviliged, String postcode) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.isPreviliged = isPreviliged;
        this.postcode = postcode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPreviliged() {
        return isPreviliged;
    }

    public void setPreviliged(boolean previliged) {
        isPreviliged = previliged;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
