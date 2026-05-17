package org.example.SyslogParsing;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.SNMP.MongoDBConnection;

public class MongoSyslogHandler {

    // EVENT COLLECTION
    public static void createEvent(
            String ip,
            String port,
            String eventType) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("event");

        Document document = new Document();

        document.append("ip", ip);

        document.append("port_name", port);

        document.append("event_type", eventType);

        collection.insertOne(document);

        System.out.println("Event Stored");
    }

    // ALARM COLLECTION
    public static void createAlarm(
            String ip,
            String port,
            String state) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("alarm");

        Document document = new Document();

        document.append("ip", ip);

        document.append("port_name", port);

        document.append("state", state);

        collection.insertOne(document);

        System.out.println("Alarm Stored");
    }

    // FSM COLLECTION
    public static void createFSM(
            String ip,
            String port,
            String state) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("fsm");

        Document document = new Document();

        document.append("ip", ip);

        document.append("port_name", port);

        document.append("state", state);

        collection.insertOne(document);

        System.out.println("FSM Stored");
    }
    public static void createInventory(
            String ip,
            String vendor,
            String model,
            String role,
            String type) {

        MongoDatabase db =
                MongoDBConnection.connect();

        MongoCollection<Document> collection =
                db.getCollection("inventory");

        Document document = new Document();

        document.append("ip", ip);

        document.append("vendor", vendor);

        document.append("model", model);

        document.append("role", role);

        document.append("type", type);

        collection.insertOne(document);

        System.out.println("Inventory Stored");
    }
}