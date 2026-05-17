package org.example.SNMP;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    public static MongoDatabase connect() {

        MongoClient mongoClient =
                MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database =
                mongoClient.getDatabase("network_management");

        System.out.println("MongoDB Connected");

        return database;
    }
}