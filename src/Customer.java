import java.lang.*;

public class Customer extends Person {
    // Attributes
    private String customerId;
    private String phoneNumber;
    private double balance;

    // Constructor
    public Customer(String customerId, String name, String address, String phoneNumber, double balance) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    // Getters and setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return Math.abs(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
    public String getFormattedDetails() {
        return "Customer ID: " + customerId + "\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "Phone Number: " + phoneNumber + "\n" +
               "Balance: $" + balance;
    }
}
