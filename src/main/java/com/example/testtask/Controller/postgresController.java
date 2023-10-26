package com.example.testtask.Controller;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.Entitty.Filter;
import com.example.testtask.Entitty.Phone;

import com.example.testtask.Service.entityToDTO;
import com.example.testtask.Service.servicePostgre;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/postgre")
public class postgresController {
    @Autowired
    private servicePostgre pS;


    @GetMapping("/getById")
    @ResponseBody
    public phoneDTO getById(@RequestParam Long id){
        return pS.findById(id);
    }
    @GetMapping("/getByNumber")
    @ResponseBody
    public phoneDTO getByPhoneNumber(@RequestParam Long phoneNumber){
        return pS.findByPhoneNumber(phoneNumber);
    }
    @PutMapping("/updateById")
    public Phone updateById( Phone p){
        return pS.updateById(p);
    }
    @PutMapping("/updateByPhoneNumber")
    public Phone updateByPhoneNumber( Phone p){
       return pS.updateByPhoneNumber(p);
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id){
        pS.deleteById(id);
    }
    @DeleteMapping("/deleteByPhoneNumber")
    public void deleteByPhoneNumber(@RequestParam Long phoneNumber){
        pS.deleteByPhoneNumber(phoneNumber);

    }

    @GetMapping("/getList")
    public List<Phone> getList(Filter f){
            return pS.getList(f);
    }
    @PostMapping("/save")
    public void save(@RequestParam phoneDTO p){

        pS.save(p);
    }
}
