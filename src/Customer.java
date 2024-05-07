import java.lang.*;

public class Customer extends Person {
    // Attributes
    private String phoneNumber;
    private double balance;
    String wantedTransaction;
    Employee assignedEmployee;

    // Constructor
    public Customer(String name,String address, String username, String password,String id,String phoneNumber, double balance) {
        super(name, address, username,password,id);
        setPhoneNumber(phoneNumber);
        setBalance(balance);
    }

    // Getters and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = Math.abs(balance);
    }

    // Method to deposit funds
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Method to calculate interest (sample method)
    public double calculateInterest(double rate) {
        return balance * (rate / 100);
    }

    // Override toString method for easy printing
    public String toString() {
        return super.toString() +
               "\nPhone Number: " + getPhoneNumber() + "\n" +
               "Balance: $" + getBalance();
    }
}