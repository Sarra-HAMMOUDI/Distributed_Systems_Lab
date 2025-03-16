package BAMS;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class BankServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create the remote object
            BankAccountImpl bankAccount = new BankAccountImpl();

            // Bind the remote object to the RMI registry
            Naming.rebind("rmi://localhost/BankService", bankAccount);

            System.out.println("Bank Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}