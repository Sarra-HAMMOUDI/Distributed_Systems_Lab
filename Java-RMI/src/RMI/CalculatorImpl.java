package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Implement the Remote Interface
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    
    // Constructor (must throw RemoteException)
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    // Implement the add method
  
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
