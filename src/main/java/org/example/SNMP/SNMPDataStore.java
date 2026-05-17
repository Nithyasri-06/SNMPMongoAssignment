package org.example.SNMP;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SNMPDataStore {

    public static void storeCPU(double cpu) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("cpu");

        Document document = new Document();

        document.append("cpu_utilization", cpu);

        collection.insertOne(document);

        System.out.println("CPU Stored");
    }
    public static void storeMemory(double memory) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("memory");

        Document document = new Document();

        document.append("memory_utilization", memory);

        collection.insertOne(document);

        System.out.println("Memory Stored");
    }
}