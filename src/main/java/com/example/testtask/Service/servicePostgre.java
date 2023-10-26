package com.example.testtask.Service;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.Entitty.Filter;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Repository.postgresRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class servicePostgre {
    @Autowired
    postgresRepo pR;
    @Autowired
    entityToDTO eTD;
    public phoneDTO findById(Long id){
        Optional<Phone> p = pR.findById(id);
        return eTD.mapToDTO(p.get());
    }
    public phoneDTO findByPhoneNumber(Long phoneNumber){
     return eTD.mapToDTO(pR.findPhoneByPhoneNumber(phoneNumber));}
    public Phone updateById(Phone p){
        phoneDTO entity = findById(p.getId());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getPhoneNumber() == null){p.setPhoneNumber(entity.getPhoneNumber());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}

        p.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        return pR.save(p);
    }
    public Phone updateByPhoneNumber(Phone p){
        p.setId(findByPhoneNumber(p.getPhoneNumber()).getId());
        phoneDTO entity = findById(p.getId());
        if(p.getName().isEmpty()){p.setName(entity.getName());}
        if(p.getSecondNumber() == null){p.setSecondNumber(entity.getSecondNumber());}
        if(p.getDateOfBirth() == null){p.setDateOfBirth(entity.getDateOfBirth());}
        p.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        return pR.save(p);
    }
    public void deleteById(Long id){
        pR.deleteById(id);
    }
    public void deleteByPhoneNumber(Long phoneNumber){
        deleteById(findByPhoneNumber(phoneNumber).getId());
    }
    public List<Phone> getList(Filter f){
        Pageable request = PageRequest.of(f.getOffset(), f.getLimit());
        Page<Phone> allPhone = pR.findAll(request);
        return allPhone.stream().toList();
    }
    public void save(phoneDTO p){
        Phone ps = eTD.DTOtoMap(p);
        ps.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        pR.save(ps);
    }
}
