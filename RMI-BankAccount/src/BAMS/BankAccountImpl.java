package BAMS;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccount {
    private Map<String, Double> accounts;

    protected BankAccountImpl() throws RemoteException {
        super();
        accounts = new HashMap<>();
    }

    @Override
    public void createAccount(String accountId, double initialBalance) throws RemoteException {
        if (accounts.containsKey(accountId)) {
            throw new RemoteException("Account already exists: " + accountId);
        }
        accounts.put(accountId, initialBalance);
        System.out.println("Account created: " + accountId + " with balance: " + initialBalance);
    }

    @Override
    public void deposit(String accountId, double amount) throws RemoteException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        if (!accounts.containsKey(accountId)) {
            throw new RemoteException("Account not found: " + accountId);
        }
        double newBalance = accounts.get(accountId) + amount;
        accounts.put(accountId, newBalance);
        System.out.println("Deposited " + amount + " into account: " + accountId + ". New balance: " + newBalance);
    }

    @Override
    public void withdraw(String accountId, double amount) throws RemoteException, IllegalArgumentException, InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (!accounts.containsKey(accountId)) {
            throw new RemoteException("Account not found: " + accountId);
        }
        double balance = accounts.get(accountId);
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in account: " + accountId);
        }
        double newBalance = balance - amount;
        accounts.put(accountId, newBalance);
        System.out.println("Withdrew " + amount + " from account: " + accountId + ". New balance: " + newBalance);
    }

    @Override
    public double getBalance(String accountId) throws RemoteException, AccountNotFoundException {
        if (!accounts.containsKey(accountId)) {
            throw new AccountNotFoundException("Account not found: " + accountId);
        }
        return accounts.get(accountId);
    }

    @Override
    public void transfer(String fromAccountId, String toAccountId, double amount) throws RemoteException, IllegalArgumentException, InsufficientFundsException, AccountNotFoundException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }
        if (!accounts.containsKey(fromAccountId)) {
            throw new AccountNotFoundException("From account not found: " + fromAccountId);
        }
        if (!accounts.containsKey(toAccountId)) {
            throw new AccountNotFoundException("To account not found: " + toAccountId);
        }
        withdraw(fromAccountId, amount); // Withdraw from source account
        deposit(toAccountId, amount);  // Deposit into target account
        System.out.println("Transferred " + amount + " from " + fromAccountId + " to " + toAccountId);
    }
}