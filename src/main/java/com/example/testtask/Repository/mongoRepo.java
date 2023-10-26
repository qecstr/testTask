package com.example.testtask.Repository;

import com.example.testtask.Entitty.PhoneMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mongoRepo extends MongoRepository<PhoneMongoDB,Long> {
    PhoneMongoDB save(PhoneMongoDB p);
    PhoneMongoDB findPhoneMongoDBById(Long id);
}
