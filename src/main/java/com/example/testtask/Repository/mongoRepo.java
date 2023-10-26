package com.example.testtask.Repository;

import com.example.testtask.Entitty.Phone;
import com.example.testtask.Entitty.PhoneMongoDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mongoRepo extends MongoRepository<PhoneMongoDB,Long> {
    PhoneMongoDB findPhoneMongoDBByPhoneNumber(Long phoneNumber);
    Page<PhoneMongoDB> findAll(Pageable pageable);
    PhoneMongoDB findPhoneMongoDBByID(Long id);

    void deleteByID(Long id);
}
