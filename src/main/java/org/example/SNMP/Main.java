package org.example.SNMP;

public class Main {

    public static void main(String[] args) {

        double cpu =
                SystemMonitor.getCPUUsage();

        double memory =
                SystemMonitor.getMemoryUsage();

        System.out.println(
                "CPU Usage: " + cpu);

        System.out.println(
                "Memory Usage: " + memory);

        SNMPDataStore.storeCPU(cpu);

        SNMPDataStore.storeMemory(memory);

        InterfaceMonitor.getInterfaceStatus();

        System.out.println(
                "Monitoring Completed");
    }
}