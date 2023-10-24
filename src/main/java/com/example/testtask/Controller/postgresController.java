package com.example.testtask.Controller;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Repository.postgresRepo;
import com.example.testtask.Service.entityToDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class postgresController {
    @Autowired
    postgresRepo pR;

    entityToDTO eTD;
    @PostMapping("/save")
    public void save(){

    }
    @GetMapping("/get")
    @ResponseBody
    public phoneDTO get(@RequestBody Phone p){


       return eTD.mapToDTO( pR.findPhoneByIdOrPhoneNumberOrSecondNumber(p.getId(),p.getPhoneNumber(),p.getSecondNumber()));
    }
}
