package BAMS;


import java.rmi.Naming;

public class BankClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object in the RMI registry
            BankAccount bankAccount = (BankAccount) Naming.lookup("rmi://localhost/BankService");

            // Perform operations
            bankAccount.createAccount("ACC123", 1000.0);
            bankAccount.deposit("ACC123", 500.0);
            bankAccount.withdraw("ACC123", 200.0);
            System.out.println("Balance of ACC123: " + bankAccount.getBalance("ACC123"));

            bankAccount.createAccount("ACC456", 500.0);
            bankAccount.transfer("ACC123", "ACC456", 300.0);
            System.out.println("Balance of ACC123: " + bankAccount.getBalance("ACC123"));
            System.out.println("Balance of ACC456: " + bankAccount.getBalance("ACC456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}