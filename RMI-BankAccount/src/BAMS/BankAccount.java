package BAMS;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
    // Create a new account
    void createAccount(String accountId, double initialBalance) throws RemoteException;

    // Deposit money into an account
    void deposit(String accountId, double amount) throws RemoteException, IllegalArgumentException;

    // Withdraw money from an account
    void withdraw(String accountId, double amount) throws RemoteException, IllegalArgumentException, InsufficientFundsException;

    // Check the balance of an account
    double getBalance(String accountId) throws RemoteException, AccountNotFoundException;

    // Transfer money between accounts
    void transfer(String fromAccountId, String toAccountId, double amount) throws RemoteException, IllegalArgumentException, InsufficientFundsException, AccountNotFoundException;
}