package com.example.testtask.Service;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.DTO.phoneMongoDTO;
import com.example.testtask.Entitty.Filter;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Entitty.PhoneMongoDB;
import com.example.testtask.Repository.mongoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class serviceMongoDb {
    @Autowired
    mongoRepo mR;
    @Autowired
    mongoDataToDTO mTD;
    public phoneMongoDTO findById(Long id){

        return mTD.mapToDTO(mR.findPhoneMongoDBByID(id));
    }
    public phoneMongoDTO findByPhoneNumber(Long phoneNumber){
        return mTD.mapToDTO(mR.findPhoneMongoDBByPhoneNumber(phoneNumber));}
    public PhoneMongoDB updateById(PhoneMongoDB p){
        phoneMongoDTO entity = findById(p.getID());
        deleteById(p.getID());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getPhoneNumber() == null){p.setPhoneNumber(entity.getPhoneNumber());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}

        p.setDateOfCreation(new Date(System.currentTimeMillis()));
        return mR.save(p);
    }
    public PhoneMongoDB updateByPhoneNumber(PhoneMongoDB p){
        p.setID(findByPhoneNumber(p.getPhoneNumber()).getID());
        phoneMongoDTO entity = findById(p.getID());
        deleteById(p.getID());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}
        p.setDateOfCreation(new Date(System.currentTimeMillis()));
        return mR.save(p);
    }
    public void deleteById(Long id){
        mR.deleteByID(id);
    }
    public void deleteByPhoneNumber(Long phoneNumber){
        deleteById(findByPhoneNumber(phoneNumber).getID());
    }
    public List<PhoneMongoDB> getList(Filter f){
        Pageable request = PageRequest.of(f.getOffset(), f.getLimit());
        Page<PhoneMongoDB> allPhone = mR.findAll(request);
        return allPhone.stream().toList();
    }
    public void save(phoneMongoDTO p){
        PhoneMongoDB ps = mTD.DTOtoMap(p);
        ps.setDateOfCreation(new Date(System.currentTimeMillis()));
        mR.save(ps);
    }
}
