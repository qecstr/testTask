package com.example.testtask.Entitty;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;
import java.util.Date;

@Data
@Document(collection = "phoneMongoDB")
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
    private Date dateOfCreation;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Indexed(unique=true)
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}

