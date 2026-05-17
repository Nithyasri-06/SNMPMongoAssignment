# CYGNET SERVICE ASSURANCE 
## Network Monitoring and Syslog Management System (Java + MongoDB)

---

# Project Overview

This project is developed as part of the Cygnet Service Assurance assignment. It simulates a basic Network Management System (NMS) using Java and MongoDB.

The system performs system monitoring and syslog parsing, and stores all collected data into MongoDB collections.

---

# Objectives

- Monitor CPU utilization
- Monitor memory utilization
- Monitor network interface status
- Store monitoring data in MongoDB
- Parse syslog messages
- Generate Inventory, Event, Alarm, and FSM records
- Demonstrate basic Network Management System concepts

---

# Technologies Used

- Java 17
- MongoDB
- MongoDB Compass
- Maven
- SNMP4J
- MongoDB Java Driver
- IntelliJ IDEA

---

# Project Structure

src/main/java  
└── org.example  
&nbsp;&nbsp;&nbsp;&nbsp;├── SNMP 
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;├── Main.java  
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;├── SystemMonitor.java  
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;├── InterfaceMonitor.java  
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;├── SNMPDataStore.java  
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;├── MongoDBConnection.java  
&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;└── MongoHandler.java  
&nbsp;&nbsp;&nbsp;&nbsp;└── syslogParsing 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── SyslogMain.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── SyslogParser.java  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── MongoSyslogHandler.java  

---

# Features

## Task 1: System Monitoring

The system monitors:
- CPU usage
- Memory usage
- Network interface status

All data is stored in MongoDB collections.

### Flow

System Monitoring → Console Output → MongoDB Storage → Collections

### Output Example

CPU Usage: 12.5  
Memory Usage: 5.1  
Interface: Wi-Fi Status: UP  
MongoDB Connected  
Monitoring Completed  

---

## Task 2: Syslog Parsing

The system parses syslog messages and detects:
- LINK_DOWN events
- LINK_UP events

It generates:
- Inventory
- Event
- Alarm
- FSM

### Flow

Syslog Input → Parser → Console Output → MongoDB Storage

### Output Example

IP: 10.10.10.10  
Port: ae1  
LINK DOWN Detected  
Event Stored  
Alarm Stored  
FSM Stored  

IP: 10.10.10.10  
Port: ae1  
LINK UP Detected  
Event Stored  
Alarm Stored  
FSM Stored  

---

# MongoDB Collections

## Monitoring Module
- cpu
- memory
- interface_status

## Syslog Module
- inventory
- event
- alarm
- fsm

---

# Conclusion

This project successfully implements a simplified Network Management System using Java and MongoDB.

It demonstrates:
- System monitoring
- Syslog parsing
- Alarm management
- FSM state tracking
- MongoDB integration
