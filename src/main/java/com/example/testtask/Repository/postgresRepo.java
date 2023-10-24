package com.example.testtask.Repository;

import com.example.testtask.Entitty.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postgresRepo extends JpaRepository<Phone,Long> {
        Phone findPhoneByIdOrPhoneNumberOrSecondNumber(Long id,Long phoneNumber,Long secondNumber);


        void deleteByIdOrPhoneNumberOrSecondNumber(Long id, Long phoneNumber, Long secondNumber);


       // List<Phone> findAll(int limit,int offset);

}
