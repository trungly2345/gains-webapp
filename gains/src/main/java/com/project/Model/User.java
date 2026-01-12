package com.project.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; // raw password (NOT stored)

    @Column(nullable = false, unique = true)
    private String email;

    private int age;
    private String gender;
    private double bodyweight;

    @Column(name = "date_created", updatable = false)
    private LocalDateTime dateCreated;

    protected User() {}

    @PrePersist
    protected void onCreate() {
        this.dateCreated = LocalDateTime.now();
    }


    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBodyweight() {
        return bodyweight;
    }

    public void setBodyweight(double bodyweight) {
        this.bodyweight = bodyweight;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}