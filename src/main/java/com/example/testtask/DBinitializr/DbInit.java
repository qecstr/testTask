package com.example.testtask.DBinitializr;

import com.example.testtask.Entitty.PhoneMongoDB;
import com.example.testtask.Repository.mongoRepo;
import com.example.testtask.Service.serviceMongoDb;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbInit {
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:52602");
    public MongoDatabase database = mongoClient.getDatabase("myMongoDb");
    @Autowired
    mongoRepo mR;
    @PostConstruct
    public void PostConstruct(){
        database.createCollection("phoneMongoDB");

        MongoCollection<Document> collection = database.getCollection("phoneMongoDB");
        List<Document> l = new ArrayList<>();

        Document test = new Document();
        test.put("ID",1);
        test.put("name","Zhassulan");
        test.put("phoneNumber",Long.valueOf("87718186663"));
        test.put("secondNumber",Long.valueOf("87755737794"));
        test.put("dateOfBirth","09.04.02");
        test.put("dateOfCreation",new Timestamp(System.currentTimeMillis()));
        Document test2 = new Document();
        test2.put("ID",2);
        test2.put("name","Chelovek");
        test2.put("phoneNumber",Long.valueOf("87052356694"));
        test2.put("secondNumber",Long.valueOf("85147291252"));
        test2.put("dateOfBirth","03.05.1999");
        test2.put("dateOfCreation",new Timestamp(System.currentTimeMillis()));
        l.add(test);
        l.add(test2);
        if(mR.findPhoneMongoDBByID(1L) == null){
            collection.insertMany(l);
        }


    }
}
