package com.customer.categorizer.domain.customer;

public class Customer {

    private Long id;
    private String name;
    private Country country;
    private String phone;
    private State state;

    public Customer() {
    }


    public Customer(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Customer(Long id, String name, Country country, String phone, State state) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
