import java.util.*;
public class Main {
    static Scanner cs=new Scanner(System.in);
    static Manager m1=new Manager("Youssef","alex" ,"Jo" ,"1234" ,"3" );
    public static void main(String[] args) {
        Employee employee1=new Employee("Ahmed","alex" ,"Ayad" ,"1234" ,"1" );
        Employee employee2=new Employee("Akram","alex" ,"Akram99" ,"1234" ,"2" );
        Employee employee3=new Employee("ZiadA","alex" ,"zoz" ,"1234" ,"3" );
        Employee employee4=new Employee("ZiadW","alex" ,"wael" ,"1234" ,"4" );

        m1.adddefaultEmployee(employee1);
        m1.adddefaultEmployee(employee2);
        m1.adddefaultEmployee(employee3);
        m1.adddefaultEmployee(employee4);

        System.out.println("Welcome to our Bank Here where every deal is legendary ");
        int identity;
        while (true) {
            try {
                System.out.println("1)customer \n2)Employee\n3)Manager");
                identity = cs.nextInt();

                if (identity != 0)
                    break;
            } catch (InputMismatchException e) {
                System.out.println("enter a valid input");
            }
        }
        cs.nextLine();
        boolean flag=true;
        switch (identity) {
            case 1:
                Customer currentCustomer=null;
                flag = false;
                System.out.println("1)new customer\n2)existing customer");
                int newnigga = cs.nextInt();
                cs.nextLine();
                switch(newnigga){
                    case 1:
                        System.out.println("..............................................Enter your data ...................................................");
                        System.out.println("Enter your name");
                        String name =cs.next();
                        System.out.println("Enter your address");
                        String address =cs.next();
                        System.out.println("Enter your username");
                        String username =cs.next();
                        System.out.println("Enter your password");
                        String password =cs.next();
                        System.out.println("Enter your id");
                        String id =cs.next();
                        System.out.println("Enter your phone number");
                        String phoneNumber =cs.next();
                        double balance =1000*(Math.random());
                        Customer c1 = new Customer(name, address, username, password, id,phoneNumber,balance);
                        m1.customers.add(c1);
                        currentCustomer = c1;
                        flag = true;
                        break;
                    case 2:
                        currentCustomer = customerlogin();
                        flag = true;
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }

                while(flag){
                    System.out.println("What transaction you want to do "+currentCustomer.name+"?");
                    System.out.println("1)deposit\n2)withdraw\n3)check balance\n4)calculate interest\n0)Exit");
                    int option =cs.nextInt();
                    cs.nextLine();
                    switch (option) {
                        case 0:
                            flag = false;
                        case 1:
                            currentCustomer.wantedTransaction = "deposit";
                            currentCustomer.assignedEmployee = assignEmployee();
                            System.out.println("Your assigned Employee:\n"+currentCustomer.assignedEmployee+"\nPlease take a seat and wait for your turn");
                            break;
                        case 2:
                            currentCustomer.wantedTransaction = "withdrawal";
                            currentCustomer.assignedEmployee = assignEmployee();
                            System.out.println("Your assigned Employee:\n"+currentCustomer.assignedEmployee+"\n Please take a seat and wait for your turn");
                            break;
                        case 3:
                            currentCustomer.checkBalance();
                            break;
                        case 4:
                            double interestRate;
                            System.out.print("Enter interest: ");
                            interestRate = cs.nextDouble();
                            cs.next();
                            System.out.println("Interest on balance with "+ interestRate+" interest rate = "+currentCustomer.calculateInterest(interestRate));
                            break;
                        default:{
                            System.out.println("Wrong input");
                        }
                    }
                }
                break;
            case 2:
                Employee currentEmployee = emplogin();

                while(flag){
                    System.out.println("Enter transaction you want to do");
                    System.out.println("1)Change your password\n2)View assigned customer\n3)View salary\n4)Current customer\n0)Exit");

                    int option =cs.nextInt();
                    cs.nextLine();

                    switch(option){
                        case 0:
                            flag = false;
                            break;
                        case 1:
                            System.out.println("Enter new password");
                            String newpass=cs.next();
                            currentEmployee.changePassword(newpass);
                            break;
                        case 2:
                            currentEmployee.viewAssignedCustomers();
                            break;
                        case 3:
                            System.out.println("Your salary = "+currentEmployee.getSalary());
                            break;
                        case 4:
                            int trans;
                            double moni;
                            System.out.println("Current customer: "+currentEmployee.currentCustomer);
                            System.out.println("Choose transaction:\n1)Deposit\n2)Withdraw");
                            trans = cs.nextInt();
                            cs.nextLine();
                            switch(trans){
                                case 1:
                                    System.out.println("Enter the amount that the customer wants to deposit: ");
                                    moni = cs.nextDouble();
                                    cs.next();
                                    currentEmployee.currentCustomer.deposit(moni);
                                    break;
                                case 2:
                                    System.out.println("Enter the amount that the customer wants to withdraw: ");
                                    moni = cs.nextDouble();
                                    cs.next();
                                    currentEmployee.currentCustomer.withdraw(moni);
                                    break;
                                default:
                                    System.out.println("Wrong input");
                            }
                            break;
                        default:
                            System.out.println("Wrong input");
                    }

                }
                break;
            case 3:
                flag = managerLogin();
                while(flag){
                    System.out.println("Enter the transaction you want to do ");
                    System.out.println("1)change employee password\n2)Add employee\n3)Remove employee\n4)Get Employee record\n0)Exit");
                    int option =cs.nextInt();
                    cs.nextLine();
                    switch(option){
                        case 0:
                            flag = false;
                            break;
                        case 1:
                            ArrayList<Employee> employees=m1.getEmployees();

                            System.out.println("enter the employee you want to change password for");
                            for (Employee e:employees){
                                System.out.println("Employee with id number "+e.id()+" "+e.name);
                            }
                            String choice=cs.next();
                            for(Employee e: employees) {
                                if(e.id().equals(choice))
                                    m1.changeEmployeePassword(e);
                                System.out.println("Password changed");
                            }
                            ;
                            break;
                        case 2:
                            m1.addEmployee();

                            break;
                        case 3:
                            m1.removeEmployee();
                            break;
                        case 4:
                            for(Employee e: m1.employees){
                                m1.getEmployeeRecords(e);
                            }
                            break;
                    }
                }
                break;
            default:
                System.out.println("Wrong input");
        }
    }
    public static Employee emplogin(){
        String username,password;
        while(true){
            System.out.print("Enter your username: ");
            username = cs.next();
            for(Employee e: m1.employees){
                if(username.equalsIgnoreCase(e.username())) {
                    System.out.print("Enter password: ");
                    password = cs.next();
                    if(e.password().equals(password))
                        return e;
                }
            }
            System.out.println("Wrong username or password!");
        }
    }
    public static Customer customerlogin(){
        String username,password;
        while(true){
            System.out.print("Enter your username: ");
            username = cs.next();
            for(Customer c : m1.customers){
                if(username.equalsIgnoreCase(c.username())) {
                    System.out.print("Enter password: ");
                    password = cs.next();
                    if(c.password().equals(password))
                        return c;
                }
            }
            System.out.println("Wrong username or password!");
        }
    }
    public static boolean managerLogin(){
        String username,password;
        while(true) {
            System.out.print("Enter your username: ");
            username = cs.next();
            if (username.equalsIgnoreCase(m1.username())) {
                System.out.print("Enter password: ");
                password = cs.next();
                if (password.equals(m1.password()))
                    return true;
            }
            System.out.println("Wrong username or password");
        }
    }
    public static Employee assignEmployee(){
        Employee that_guy = m1.employees.getFirst();
        for(int i = 1;i<m1.employees.size();i++)
            if(m1.employees.get(i).assignedCustomers.size()<that_guy.assignedCustomers.size())
                that_guy  = m1.employees.get(i);
        return that_guy;
    }
}