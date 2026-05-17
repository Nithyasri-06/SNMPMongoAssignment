package org.example.SNMP;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMonitor {
    public static double getCPUUsage() {

        OperatingSystemMXBean osBean =
                ManagementFactory.getPlatformMXBean(
                        OperatingSystemMXBean.class);

        // First call ignored
        osBean.getCpuLoad();

        try {

            // Wait for accurate reading
            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        double cpuLoad = osBean.getCpuLoad();

        return cpuLoad * 100;
    }
    public static double getMemoryUsage() {

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();

        long freeMemory = runtime.freeMemory();

        long usedMemory = totalMemory - freeMemory;

        return ((double) usedMemory / totalMemory) * 100;
    }
}