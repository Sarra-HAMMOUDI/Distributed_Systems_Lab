package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup remote object from RMI Registry
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            // Invoke remote method
            int result = calculator.add(5, 10);
            System.out.println("Result of 5 + 10: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
