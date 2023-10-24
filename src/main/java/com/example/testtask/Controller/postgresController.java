package com.example.testtask.Controller;

import com.example.testtask.Repository.postgresRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class postgresController {
    @Autowired
    postgresRepo pR;
    @PostMapping("/save")
    public void save(){

    }
}
