package com.wecode.employeemanagementsystem.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Employee implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false, updatable = false)
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String jobTitle;
        private String city;
        private String imageUrl;
        @Column(nullable = false, updatable = false)
        private String employeeCode;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String email, String phone, String jobTitle, String city, String imageUrl, String employeeCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.city = city;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", city='" + city + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
