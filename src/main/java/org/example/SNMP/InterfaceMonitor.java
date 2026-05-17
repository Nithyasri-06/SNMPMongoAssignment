package org.example.SNMP;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceMonitor {

    public static void getInterfaceStatus() {

        try {

            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while(interfaces.hasMoreElements()) {

                NetworkInterface networkInterface =
                        interfaces.nextElement();

                String name =
                        networkInterface.getDisplayName();

                boolean status =
                        networkInterface.isUp();

                String state =
                        status ? "UP" : "DOWN";

                System.out.println(
                        "Interface: " + name +
                                " Status: " + state);

                // Store into MongoDB
                MongoHandler.storeInterface(
                        name,
                        state);
            }

        } catch (SocketException e) {

            e.printStackTrace();
        }
    }
}