package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Start RMI Registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create remote object
            CalculatorImpl calculator = new CalculatorImpl();

            // Bind the object to the RMI Registry
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
