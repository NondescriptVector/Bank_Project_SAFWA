import java.util.*;

public class Manager {
    static Scanner scanner= new Scanner(System.in);
    //attributes
    ArrayList<Customer> customers=new ArrayList<Customer>();
    ArrayList<Employee>employees=new ArrayList<Employee>();
    public void changeEmployeePassword(Employee employee){
        int count =1;
        System.out.println("here are the Employees, please choose the one whom you'd like to change his password");
        for (Employee employee1:employees){
            System.out.println("Employee number "+count+" "+employee1);
            count+=1;
        }
        int choice=scanner.nextInt();
        System.out.println("Enter the new password for the desired employee");
        String newPassword=scanner.next();
        employee.changePassword(newPassword);

    }

    public void addEmployee(){
        System.out.println("enter the employee's name");
        String name= scanner.next();
        System.out.println("Enter their address");
        String address=scanner.next();
        System.out.println("Create a username for them");
        String username=scanner.next();
        System.out.println("Create their password");
        String password= scanner.next();
        System.out.println("Enter their id ");
        int id=scanner.nextInt();
        Employee employee= new Employee(name,address,username,password,id);
        employees.add(employee);


        }
    public void removeEmployee(){
        int id =1;
        System.out.println("here are the Employees, please choose the one whom you'd like to remove");
        for (Employee employee1:employees){
            System.out.println("Employee with id number "+id+" "+employee1);
            id+=1;
        }
        int choice=scanner.nextInt();
        if (choice<=employees.size()&&choice>=0){
            employees.remove(choice-1);
            System.out.println("Employee has been removed successfully");
        }else System.out.println("Please enter a valid id ");
    }
    public void getEmployeeRecords(Employee employee){
      

        System.out.println("Employee "+employee.name+" has served "+employee.servedCustomers.size()+" customers");


    }


}
