package org.example.SyslogParsing;

import org.example.SyslogParsing.SyslogParser;

public class SyslogMain {

    public static void main(String[] args) {

        String downLog =
                "<28>May 13 19:24:22 PUN-041-P01-AG01-J-A7100-NANDED-CITY-10.10.10.10 mib2d[10275]: SNMP_TRAP_LINK_DOWN: ifIndex 516, ifAdminStatus up(1), ifOperStatus down(2), ifName ae1";

        String upLog =
                "<28>May 13 19:24:22 PUN-041-P01-AG01-J-A7100-NANDED-CITY-10.10.10.10 mib2d[10276]: SNMP_TRAP_LINK_UP: ifIndex 516, ifAdminStatus up(1), ifOperStatus UP(1), ifName ae1";

        // Parse DOWN Message
        SyslogParser.parse(downLog);

        // Parse UP Message
        SyslogParser.parse(upLog);

        System.out.println(
                "Syslog Parsing Completed");
    }
}