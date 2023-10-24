package com.example.testtask.DTO;

import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class phoneDTO {
    private String name;
    private Date dateOfBirth;
    private Long phoneNumber;
    private Long secondNumber;
    private Long id;
}

