package com.example.testtask.DBinitializr;

import com.example.testtask.Entitty.PhoneMongoDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DbInit {
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:52602");
    public MongoDatabase database = mongoClient.getDatabase("myMongoDb");

    @PostConstruct
    public void PostConstruct(){
        database.createCollection("phoneMongo");

        MongoCollection<Document> collection = database.getCollection("phoneMongo");
        Document test = new Document();
        test.put("id",1);
        test.put("name","Zhassulan");
        test.put("phoneNumber",Long.valueOf("87718186663"));
        test.put("secondNumber",Long.valueOf("87755737794"));
        test.put("dateOfBirth","09.04.02");
        test.put("dateOfCreation",new Timestamp(System.currentTimeMillis()));
        collection.insertOne(test);


    }
}
