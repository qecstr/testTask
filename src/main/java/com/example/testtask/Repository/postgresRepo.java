package com.example.testtask.Repository;

import com.example.testtask.Entitty.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postgresRepo extends JpaRepository<Phone,Long> {


        Phone findPhoneByPhoneNumber(Long phoneNumber);
        Phone save(Phone p);
        void deleteById(Long id);
        Phone findPhoneById(Long id);
        Page<Phone> findAll(Pageable pageable);



}
