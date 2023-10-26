package com.example.testtask.Controller;

import com.example.testtask.DBinitializr.DbInit;
import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.DTO.phoneMongoDTO;
import com.example.testtask.Entitty.Filter;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Entitty.PhoneMongoDB;
import com.example.testtask.Repository.mongoRepo;
import com.example.testtask.Service.serviceMongoDb;
import com.example.testtask.Service.servicePostgre;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo")
public class mongoDbController {
    @Autowired
    private serviceMongoDb mS;


    @GetMapping("/getById")
    public phoneMongoDTO getById(@RequestParam Long id){
        return mS.findById(id);
    }
    @GetMapping("/getByNumber")
    @ResponseBody
    public phoneMongoDTO getByPhoneNumber(@RequestParam Long phoneNumber){
        return mS.findByPhoneNumber(phoneNumber);
    }
    @PutMapping("/updateById")
    public PhoneMongoDB updateById(PhoneMongoDB p){
        return mS.updateById(p);
    }
    @PutMapping("/updateByPhoneNumber")
    public PhoneMongoDB updateByPhoneNumber( PhoneMongoDB p){
        return mS.updateByPhoneNumber(p);
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id){
        mS.deleteById(id);
    }
    @DeleteMapping("/deleteByPhoneNumber")
    public void deleteByPhoneNumber(@RequestParam Long phoneNumber){
        mS.deleteByPhoneNumber(phoneNumber);

    }

    @GetMapping("/getList")
    public List<PhoneMongoDB> getList(Filter f){
        return mS.getList(f);
    }
    @PostMapping("/save")
    public void save(@RequestParam phoneMongoDTO p){

        mS.save(p);
    }
}
