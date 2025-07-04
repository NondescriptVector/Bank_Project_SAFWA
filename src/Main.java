import javax.swing.*;
import java.util.*;

public class Main {
    static Manager manager = new Manager("Youssef", "alex", "Jo", "1234", "1");

    public static void main(String[] args) {
        manager.adddefaultEmployee(new Employee("Abdelrahman", "alex", "abdo", "1234", "1"));
        manager.adddefaultEmployee(new Employee("Akram", "alex", "Akram99", "1234", "2"));
        manager.adddefaultEmployee(new Employee("ZiadA", "alex", "zoz", "1234", "3"));
        manager.adddefaultEmployee(new Employee("ZiadW", "alex", "wael", "1234", "4"));
        manager.adddefaultEmployee(new Employee("Ahmed", "alex", "ayad", "1234", "5"));

        JOptionPane.showMessageDialog(null, "Welcome to our Bank, where every deal is legendary");

        int identity;

        while (true) {
            while (true) {
                try {
                    identity = tryInput("1) Customer\n2) Employee\n3) Manager");
                    if (identity != 0) break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            switch (identity) {
                case 1:
                    Customer currentCustomer = null;
                    boolean customerSession = true;

                    while (true) {
                        int newCustomer = tryInput("1) New customer\n2) Existing customer");
                        if (newCustomer == 1) {
                            String name = JOptionPane.showInputDialog("Enter your name");
                            String address = JOptionPane.showInputDialog("Enter your address");
                            String username = JOptionPane.showInputDialog("Enter your username");
                            String password = JOptionPane.showInputDialog("Enter your password");
                            String id = JOptionPane.showInputDialog("Enter your ID");
                            String phone = JOptionPane.showInputDialog("Enter your phone number");
                            double balance = 1000 * Math.random();

                            currentCustomer = new Customer(name, address, username, password, id, phone, balance);
                            manager.customers.add(currentCustomer);
                            break;
                        } else if (newCustomer == 2) {
                            currentCustomer = customerLogin();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong input");
                        }
                    }

                    while (customerSession) {
                        int option = tryInput(
                                "What transaction do you want to do " + currentCustomer.name + "?\n" +
                                        "1) Deposit or Withdraw\n2) Check Balance\n3) Calculate Interest\n0) Exit");

                        switch (option) {
                            case 0:
                                customerSession = false;
                                break;
                            case 1:
                                currentCustomer.assignedEmployee = assignEmployee();
                                currentCustomer.assignedEmployee.assignedCustomers.add(currentCustomer);
                                JOptionPane.showMessageDialog(null, "Assigned Employee:\n" +
                                        currentCustomer.assignedEmployee +
                                        "\nPlease wait for your turn.");
                                break;
                            case 2:
                                currentCustomer.checkBalance();
                                break;
                            case 3:
                                double rate = tryInput("Enter interest rate:");
                                JOptionPane.showMessageDialog(null, "Interest = " + currentCustomer.calculateInterest(rate));
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Wrong input");
                        }
                    }
                    break;

                case 2:
                    Employee currentEmployee = employeeLogin();
                    boolean employeeSession = true;

                    while (employeeSession) {
                        int option = tryInput("Enter action:\n1) Change Password\n2) View Assigned Customers\n3) View Salary\n4) Process Current Customer\n0) Exit");

                        switch (option) {
                            case 0:
                                employeeSession = false;
                                break;
                            case 1:
                                String newPassword = JOptionPane.showInputDialog("Enter new password:");
                                currentEmployee.changePassword(newPassword);
                                break;
                            case 2:
                                currentEmployee.viewAssignedCustomers();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Salary: " + currentEmployee.getSalary());
                                break;
                            case 4:
                                if (currentEmployee.currentCustomer == null) break;

                                JOptionPane.showMessageDialog(null, "Current customer: " + currentEmployee.currentCustomer());
                                int transactionType = tryInput("Choose transaction:\n1) Deposit\n2) Withdraw");

                                double amount;
                                switch (transactionType) {
                                    case 1:
                                        amount = tryInput("Enter deposit amount:");
                                        currentEmployee.currentCustomer.deposit(amount);
                                        JOptionPane.showMessageDialog(null, "Deposit successful!");
                                        break;
                                    case 2:
                                        amount = tryInput("Enter withdrawal amount:");
                                        currentEmployee.currentCustomer.withdraw(amount);
                                        JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Wrong input");
                                }
                                break;
                        }
                    }
                    break;

                case 3:
                    boolean managerSession = managerLogin();

                    while (managerSession) {
                        int option = tryInput("Choose action:\n1) Change Employee Password\n2) Add Employee\n3) Remove Employee\n4) View Employee Records\n0) Exit");

                        switch (option) {
                            case 0:
                                managerSession = false;
                                break;
                            case 1:
                                String employeeId = JOptionPane.showInputDialog("Enter Employee ID:");
                                for (Employee e : manager.getEmployees()) {
                                    if (e.id().equals(employeeId)) {
                                        manager.changeEmployeePassword(e);
                                        JOptionPane.showMessageDialog(null, "Password changed.");
                                    }
                                }
                                managerSession = askAnotherTransaction();
                                break;
                            case 2:
                                manager.addEmployee();
                                managerSession = askAnotherTransaction();
                                break;
                            case 3:
                                manager.removeEmployee();
                                managerSession = askAnotherTransaction();
                                break;
                            case 4:
                                for (Employee e : manager.employees) {
                                    manager.getEmployeeRecords(e);
                                }
                                managerSession = askAnotherTransaction();
                                break;
                        }
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }
        }
    }

    public static int tryInput(String message) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(message));
                return input;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter a valid integer.");
            }
        }
    }

    public static Customer customerLogin() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter username:");
            String password = JOptionPane.showInputDialog("Enter password:");
            for (Customer c : manager.customers) {
                if (c.username().equalsIgnoreCase(username) && c.password().equals(password)) return c;
            }
            JOptionPane.showMessageDialog(null, "Wrong username or password!");
        }
    }

    public static Employee employeeLogin() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter username:");
            String password = JOptionPane.showInputDialog("Enter password:");
            for (Employee e : manager.employees) {
                if (e.username().equalsIgnoreCase(username) && e.password().equals(password)) return e;
            }
            JOptionPane.showMessageDialog(null, "Wrong username or password!");
        }
    }

    public static boolean managerLogin() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter Manager username:");
            String password = JOptionPane.showInputDialog("Enter password:");
            if (username.equalsIgnoreCase(manager.username()) && password.equals(manager.password())) return true;
            JOptionPane.showMessageDialog(null, "Wrong username or password!");
        }
    }

    public static Employee assignEmployee() {
        int randomIndex = (int) (Math.random() * manager.employees.size());
        Employee chosen = manager.employees.get(randomIndex);

        for (Employee e : manager.employees) {
            if (e.assignedCustomers.size() < chosen.assignedCustomers.size()) {
                chosen = e;
            }
        }

        return chosen;
    }

    public static boolean askAnotherTransaction() {
        int res = tryInput("Do you want to make another transaction?\n1) Yes\n2) No");
        return res == 1;
    }
}
