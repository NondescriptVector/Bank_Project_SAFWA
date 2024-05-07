import java.util.*;

public class Manager extends Person{
    double salary = 3100;
    static Scanner scanner= new Scanner(System.in);
    //attributes
    ArrayList<Customer> customers=new ArrayList<>();
    ArrayList<Employee>employees=new ArrayList<>();

    public Manager(String name, String address, String username, String password, String id) {
        super(name, address, username, password, id);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void changeEmployeePassword(Employee e){

        System.out.println("Enter the new password for the desired employee");
        String newPassword=scanner.next();
        e.setPassword(newPassword);

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
        String id=scanner.next();

        employees.add(new Employee(name,address,username,password,id));


    }
    public void removeEmployee(){
        System.out.println("here are the Employees, please choose the one whom you'd like to remove");
        for (Employee e:employees){
            System.out.println("Employee with id number "+e.id()+" "+e.name);
        }
        int choice=scanner.nextInt();
        if(choice<0||choice>employees.size()) {
            System.out.println("enter a valid number");
            return;
        }
        System.out.println("Employee removed");
        employees.removeIf(x->x.id().equals(String.valueOf(choice)));

    }
    public void getEmployeeRecords(Employee employee){


        System.out.println("Employee "+employee.name+" has served "+employee.servedCustomers+" customers");


    }
    public void adddefaultEmployee(Employee employee){
        employees.add(employee);

    }
}
