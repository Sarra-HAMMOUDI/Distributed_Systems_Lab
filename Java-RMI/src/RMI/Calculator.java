package RMI;




import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Define a Remote Interface
public interface Calculator extends Remote {
    // A method to add two numbers
    int add(int a, int b) throws RemoteException;
}
