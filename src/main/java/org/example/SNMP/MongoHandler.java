package org.example.SNMP;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoHandler {

    public static void storeInterface(
            String interfaceName,
            String status) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("interface_status");

        Document document = new Document();

        document.append(
                "interface_name",
                interfaceName);

        document.append(
                "status",
                status);

        collection.insertOne(document);

        System.out.println(
                "Interface Stored");
    }
}