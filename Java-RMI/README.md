# README: How to Execute Java RMI (Remote Method Invocation)

## **1. Overview**
Java RMI (Remote Method Invocation) allows an object to invoke methods on an object located on a remote machine. This guide provides step-by-step instructions to set up and execute a basic Java RMI application for performing calculations on two numbers.

---
## **2. Components of Java RMI**
A typical Java RMI application consists of:
1. **Remote Interface**: Defines the methods that can be invoked remotely (e.g., addition, subtraction, multiplication, division).
2. **Remote Implementation (Server)**: Implements the remote interface and binds it to the RMI registry.
3. **Client**: Looks up the remote object from the RMI registry and invokes its methods.

---
## **3. Steps to Execute Java RMI**

### **Step 1: Create the Remote Interface**
Define an interface that extends `java.rmi.Remote` and declares methods for performing calculations.

### **Step 2: Implement the Remote Interface**
Create a class that implements the remote interface and extends `UnicastRemoteObject`.

### **Step 3: Create the Server**
The server registers the remote object with the RMI registry and provides calculation services.

### **Step 4: Create the Client**
The client looks up the remote object from the registry and invokes its methods to perform calculations.

---
## **4. Compilation and Execution**

### **Step 1: Compile the Java Files**
```sh
javac *.java
```

### **Step 2: Generate Stubs (Not needed for Java 8 and later)**
If using an older version of Java, run:
```sh
rmic CalculatorImpl
```

### **Step 3: Start the RMI Registry**
```sh
rmiregistry &
```
This command runs the RMI registry in the background.

### **Step 4: Start the Server**
```sh
java Server
```

### **Step 5: Run the Client**
```sh
java Client
```

---
## **5. Expected Output**
1. **On the Server Console:**
   ```
   Server is ready.
   ```
2. **On the Client Console:**
   ```
   Addition Result: 15

   ```

---
## **6. Notes**
- Ensure the server and client are running on the same network.
- Use `rmiregistry` before starting the server.
- If running on different machines, replace `localhost` in `Naming.lookup("//localhost/Calculator")` with the server’s IP.

This completes the setup and execution of a Java RMI application for performing calculations!

