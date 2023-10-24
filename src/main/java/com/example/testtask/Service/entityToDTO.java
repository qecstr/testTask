package com.example.testtask.Service;

import com.example.testtask.DTO.phoneDTO;
import com.example.testtask.Entitty.Phone;
import org.springframework.stereotype.Service;

@Service
public class entityToDTO {
    public phoneDTO mapToDTO(Phone phone){
        phoneDTO dto = new phoneDTO();
        dto.setId(phone.getId());
        dto.setName(phone.getName());
        dto.setDateOfBirth(phone.getDateOfBirth());
        dto.setPhoneNumber(phone.getPhoneNumber());
        dto.setSecondNumber(phone.getSecondNumber());
        return dto;
    }
    public Phone DTOtoMap(phoneDTO dto){
        Phone entity = new Phone();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSecondNumber(dto.getSecondNumber());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;

    }
}
