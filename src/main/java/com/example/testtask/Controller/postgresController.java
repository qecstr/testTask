package com.example.testtask.Controller;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.Entitty.Filter;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Repository.postgresRepo;
import com.example.testtask.Service.entityToDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@AllArgsConstructor
public class postgresController {
    @Autowired
    postgresRepo pR;

    entityToDTO eTD;

    @GetMapping("/getById")
    @ResponseBody
    public phoneDTO getById(@RequestParam Long id){
        return eTD.mapToDTO(pR.findPhoneById(id));
    }
    @GetMapping("/getByNumber")
    @ResponseBody
    public phoneDTO getByPhoneNumber(@RequestParam Long phoneNumber){
        return eTD.mapToDTO(pR.findPhoneByPhoneNumber(phoneNumber));
    }
    @PutMapping("/updateById")
    public Phone updateById( Phone p){
       Phone entity = pR.findPhoneById(p.getId());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getPhoneNumber() == null){p.setPhoneNumber(entity.getPhoneNumber());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}

       p.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        return pR.save(p);
    }
    @PutMapping("/updateByPhoneNumber")
    public Phone updateByPhoneNumber( Phone p){
        p.setId(pR.findPhoneByPhoneNumber(p.getPhoneNumber()).getId());
        Phone entity = pR.findPhoneById(p.getId());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}
        p.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        return pR.save(p);
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id){
        pR.deleteById(id);
    }
    @DeleteMapping("/deleteByPhoneNumber")
    public void deleteByPhoneNumber(@RequestParam Long phoneNumber){

        pR.deleteById(pR.findPhoneByPhoneNumber(phoneNumber).getId());
    }

    @GetMapping("/getList")
    public List<Phone> getList(Filter f){
        Pageable request = PageRequest.of(f.getOffset(), f.getLimit());
        Page<Phone> allPhone = pR.findAll(request);
        return allPhone.stream().toList();
    }
}
