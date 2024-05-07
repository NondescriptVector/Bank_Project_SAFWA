import java.util.*;
public class Employee extends Person {
    Scanner scan = new Scanner(System.in);
    
    private double salary=3000.0;
    
    ArrayList <Customer> assignedCustomers = new ArrayList<>();
    int servedCustomers = 0;
    
    Customer currentCustomer;
    public Employee(String name, String address, String user_name, String password, String id) {
        super(name, address, user_name, password, id);
    }

    public void changePassword(String pass){
        boolean flag = true;
        
        while(flag){
           
        System.out.println("To change your password , please enter your old password: ");
        String oldPass = scan.next();
        if(this.password()==oldPass) {
        this.setPassword(pass);
            System.out.println("Password changed successfully , your new password is: "+pass);
            flag = false;
        }
        else {
            System.out.println("Wrong password");
        }
            
        }
        
    }
    public String currentCustomer(){
        return currentCustomer+"\nTransaction: "+currentCustomer.wantedTransaction;
    }
    
    public void viewAssignedCustomers() {
        String ans;
        

        if(currentCustomer != null){
            System.out.println("Do you want any other transactions?");
            ans = scan.next();
            if(ans.equalsIgnoreCase("no")) {
                servedCustomers++;
                currentCustomer = null;
            }
            else return;
        }

        if (assignedCustomers.isEmpty()) {
            System.out.println("No assigned Customers yet");
            return;
        }
        for (Customer customer : assignedCustomers) {
            System.out.println(customer);
        }

        System.out.println("Do you want to proceed to the next customer?");
        ans = scan.next();
        if(ans .equalsIgnoreCase("yes"))  {
            currentCustomer = assignedCustomers.getFirst();

            assignedCustomers.removeFirst();
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
