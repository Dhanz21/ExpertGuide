package com.trekExpert.expertguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private boolean isPreviliged;

    private String postcode;

    public Customer() {
    }

    public Customer(Long id, String name, String email, boolean isPreviliged, String postcode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isPreviliged = isPreviliged;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
