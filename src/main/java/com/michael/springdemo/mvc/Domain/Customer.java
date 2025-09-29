package com.michael.springdemo.mvc.Domain;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    private String place;

    @Min(value=0, message="must be greater than zero")
    @Max(value=10, message="must be smaller than 10")
    private int freePasses;

    @NotNull(message="is required")
    @Pattern(regexp = "^[0-9]+$", message = "Only digits allowed")
    @Size(min = 10, max = 15, message = "Phone number must be 10-15 digits")
    private String phoneNumber;

    @NotNull(message="is required")
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digit")
    private String postalCode;

    @NotNull(message="is required")
    @Pattern(regexp="^[0-9]+$", message="only digits is allowed")
    @Size(max=3, message="age should not more than 3 digits")
    private String age;

    public Customer(){}
    public Customer(String firstName, String lastName, String place, int freePasses, String phoneNumber, String postalCode, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.place=place;
        this.freePasses = freePasses;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.age=age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
