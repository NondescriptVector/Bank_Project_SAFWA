import java.util.*;

public class Manager {
    double salary;
    static Scanner scanner= new Scanner(System.in);
    //attributes
    ArrayList<Customer> customers=new ArrayList<Customer>();
    ArrayList<Employee>employees=new ArrayList<Employee>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void changeEmployeePassword(int e){

        System.out.println("Enter the new password for the desired employee");
        String newPassword=scanner.next();
        employees.get(e).changePassword(newPassword);

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
        String id=scanner.nextLine();
        Employee employee= new Employee(name,address,username,password,id);
        employees.add(employee);


    }
    public void removeEmployee(){
        int id =1;
        System.out.println("here are the Employees, please choose the one whom you'd like to remove");
        for (Employee employee1:employees){
            System.out.println("Employee with id number "+id+" "+employee1.name);
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
    public void adddefaultEmployee(Employee employee){
        employees.add(employee);

    }


}
