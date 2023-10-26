package com.example.testtask.Service;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.DTO.phoneMongoDTO;
import com.example.testtask.Entitty.Phone;
import com.example.testtask.Entitty.PhoneMongoDB;
import org.springframework.stereotype.Service;

@Service
public class mongoDataToDTO {
    public phoneMongoDTO mapToDTO(PhoneMongoDB phone){
        if(phone == null){
            return null;
        }
        phoneMongoDTO dto = new phoneMongoDTO();
        dto.setID(phone.getID());
        dto.setName(phone.getName());
        dto.setDateOfBirth(phone.getDateOfBirth());
        dto.setPhoneNumber(phone.getPhoneNumber());
        dto.setSecondNumber(phone.getSecondNumber());
        return dto;
    }
    public PhoneMongoDB DTOtoMap(phoneMongoDTO dto){
        PhoneMongoDB entity = new PhoneMongoDB();
        entity.setID(dto.getID());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSecondNumber(dto.getSecondNumber());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;

    }
}
