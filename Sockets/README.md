# Java Socket Programming - Chat Application

## Introduction
This repository contains two implementations of a Java-based chat application using **sockets**:
1. **Single-Client Chat** - A basic client-server chat system.
2. **Multi-Client Chat** - A chat server that supports multiple clients simultaneously.

---

## **1. Single-Client Chat Application**

### **How to Run**

### **Step 1: Compile the Java Files**
Open a terminal or command prompt, navigate to the project directory, and compile the files:
```sh
javac ChatServer.java ChatClient.java
```

### **Step 2: Start the Server**
Run the server first so it can accept incoming connections:
```sh
java ChatServer
```
You should see the output:
```
Chat Server started. Waiting for a client...
```

### **Step 3: Start the Client**
Open another terminal window and run the client:
```sh
java ChatClient
```
The client should connect, and you can start sending messages.

### **Step 4: Sending Messages**
- Type messages in the client terminal and press Enter.
- The server will receive and display them.
- The server can also send responses back to the client.

### **Step 5: Stopping the Chat**
To stop the server, press `Ctrl + C` in the server terminal.

---

## **2. Multi-Client Chat Application**
This version allows multiple clients to connect to a single server and communicate with each other.

### **How to Run**

### **Step 1: Compile the Java Files**
```sh
javac ChatServer.java ClientHandler.java ChatClient.java
```

### **Step 2: Start the Server**
```sh
java ChatServer
```
Expected output:
```
Chat Server started. Waiting for clients...
```

### **Step 3: Start Multiple Clients**
Open **multiple terminal windows** and run:
```sh
java ChatClient
```
Each client will connect and can send messages to all other connected clients.

### **Step 4: Sending Messages**
- Clients can type messages and send them.
- The server will broadcast messages to all connected clients.

### **Step 5: Stopping the Server**
To stop the server, press `Ctrl + C` in the server terminal.

---

## **Troubleshooting**
- If `javac` or `java` commands are not recognized, ensure Java is installed and added to your system's PATH.
- If the server does not receive client messages, check if your firewall is blocking connections.

---
