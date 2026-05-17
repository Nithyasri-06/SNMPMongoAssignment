package org.example.SyslogParsing;

import org.example.SyslogParsing.MongoSyslogHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyslogParser {

    public static void parse(String log) {

        // Extract IP Address
        Pattern ipPattern =
                Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)");

        Matcher ipMatcher =
                ipPattern.matcher(log);

        String ip = "";

        if(ipMatcher.find()) {

            ip = ipMatcher.group(1);
        }

        // Extract Interface Name
        Pattern interfacePattern =
                Pattern.compile("ifName\\s+(\\w+)");

        Matcher interfaceMatcher =
                interfacePattern.matcher(log);

        String port = "";

        if(interfaceMatcher.find()) {

            port = interfaceMatcher.group(1);
        }

        // Check DOWN Event
        boolean isDown =
                log.contains("SNMP_TRAP_LINK_DOWN");

        // Check UP Event
        boolean isUp =
                log.contains("SNMP_TRAP_LINK_UP");

        // Print Values
        System.out.println("IP: " + ip);

        System.out.println("Port: " + port);

        // LINK DOWN
        if(isDown) {

            System.out.println(
                    "LINK DOWN Detected");
            MongoSyslogHandler.createInventory(
                    ip,
                    "Juniper",
                    "A7100",
                    "AG01",
                    "NE");

            MongoSyslogHandler.createEvent(
                    ip,
                    port,
                    "LINK_DOWN");

            MongoSyslogHandler.createAlarm(
                    ip,
                    port,
                    "OPEN");

            MongoSyslogHandler.createFSM(
                    ip,
                    port,
                    "DOWN");
        }

        // LINK UP
        if(isUp) {

            System.out.println(
                    "LINK UP Detected");
            MongoSyslogHandler.createInventory(
                    ip,
                    "Juniper",
                    "A7100",
                    "AG01",
                    "NE");

            MongoSyslogHandler.createEvent(
                    ip,
                    port,
                    "LINK_UP");

            MongoSyslogHandler.createAlarm(
                    ip,
                    port,
                    "CLEAR");

            MongoSyslogHandler.createFSM(
                    ip,
                    port,
                    "UP");
        }
    }
}