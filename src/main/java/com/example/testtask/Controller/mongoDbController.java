package com.example.testtask.Controller;

import com.example.testtask.DBinitializr.DbInit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo")
public class mongoDbController {

    @GetMapping("/Get")
    public void get(){


    }
}
