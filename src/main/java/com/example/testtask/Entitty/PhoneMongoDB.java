package com.example.testtask.Entitty;


import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Timestamp;

@Document
@Entity
@Table(name = "phoneMongo")
public class PhoneMongoDB {
    @Column(name = "name")
    private String name;
    @Column(name = "dateOfBirth")
    private String dateOfBirth;
    @Column(name = "phoneNumber")
    private Long phoneNumber;
    @Column(name = "secondNumber")
    private Long secondNumber;
    @Column(name = "dateOfCreation")
    private Timestamp dateOfCreation;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Long secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}

