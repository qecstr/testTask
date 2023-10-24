package com.example.testtask.Repository;

import com.example.testtask.Entitty.Phone;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface postgresRepo extends CrudRepository<Phone,Long> {
        Phone findPhoneByIdOrPhoneNumberOrSecondNumber(Long id, Long phoneNumber, Long secondNumber);


        void deleteByIdOrPhoneNumberOrSecondNumber(Long id, Long phoneNumber, Long secondNumber);

        @Query
        List<Phone> findAllByPhoneNumber(Long phoneNumber);

}
