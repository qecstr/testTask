package com.example.testtask.Repository;

import com.example.testtask.Entitty.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postgresRepo extends JpaRepository<Phone,Long> {


        Phone findPhoneByPhoneNumber(Long phoneNumber);
        Phone save(Phone p);
        void deleteById(Long id);



      /*  @Query(nativeQuery = true ,value = "SELECT p FROM Phone p LIMIT ?1 OFFSET ?2")
        List<Phone> findAll(int limit, int offset);*/
      Page<Phone> findAll(Pageable pageable);



}
