import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Employee employee1=new Employee("Ahmed","alex" ,"Ayad" ,"1234" ,"1" );
        Employee employee2=new Employee("Akram","alex" ,"Akram99" ,"1234" ,"2" );
        Employee employee3=new Employee("Youssef","alex" ,"Jo" ,"1234" ,"3" );
        Employee employee4=new Employee("ZiadA","alex" ,"zoz" ,"1234" ,"4" );
        Employee employee5=new Employee("ZiadW","alex" ,"wael" ,"1234" ,"5" );
        Manager m1=new Manager();
        m1.adddefaultEmployee(employee1);
        m1.adddefaultEmployee(employee3);
        m1.adddefaultEmployee(employee4);
        m1.adddefaultEmployee(employee5);

        System.out.println("Welcome to our Bank Here where every deal is legendary ");

        System.out.println("1)customer \n2)Empolyee\n3)Manager");
        Scanner cs=new Scanner(System.in);
        int identity =cs.nextInt();

        switch (identity) {
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
                String phonenumber =cs.next();
                double balance =1000*(Math.random());
                Customer c1=new Customer(name, address, username, password, id,phonenumber,balance);
                boolean flag=true;
                while(flag){
                    System.out.println("What transaction you want to do "+c1.getName()+"?");
                    System.out.println("1)deposite\n2)withdraw\n3)check balance");
                    int option =cs.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the amount you want to deposit");
                            double dep=cs.nextDouble();
                            c1.deposit(dep);
                            boolean res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{ System.out.println("rate the service from 0 to 100");
                                double rate =cs.nextDouble();
                                c1.calculateInterest(rate);
                                System.out.println(  c1.getFormattedDetails());

                                flag =false;}

                            break;
                        case 2:
                            System.out.println("Enter the amount you want to withdraw");
                            double with=cs.nextDouble();
                            c1.withdraw(with);
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{   System.out.println("rate the service from 0 to 100");
                                double rate =cs.nextDouble();
                                c1.calculateInterest(rate);
                                System.out.println(  c1.getFormattedDetails());

                                flag =false;}

                            break;
                        case 3:
                            c1.checkBalance();
                            System.out.println("Do you want to make another transaction\n..yes....no");
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{System.out.println("rate the service from 0 to 100");
                                double rate =cs.nextDouble();
                                c1.calculateInterest(rate);
                                System.out.println(  c1.getFormattedDetails());
                                flag =false ;}
                            break;
                        default:{
                            System.out.println("Wrong input");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("..............................................Enter your data ...................................................");
                System.out.println("Enter your name");
                name =cs.next();
                System.out.println("Enter your address");
                address =cs.next();
                System.out.println("Enter your username");
                username =cs.next();
                System.out.println("Enter your password");
                String password1 =cs.next();
                System.out.println("Enter your id");
                id =cs.next();
                Employee e1=new Employee(name, address, username, password1, id);

                flag=true;
                while(flag){
                    System.out.println("Enter transaction you want to do");
                    System.out.println("1)Change your password\n2)View assigned customer\n3)View salary");

                    int option =cs.nextInt();

                    switch(option){
                        case 1:
                            System.out.println("Enter new password");
                            String newpass=cs.next();
                            e1.changePassword(newpass);
                            boolean res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag =false ;}
                            break;
                        case 2:
                            e1.viewAssignedCustomers();
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag=false;}
                            break;
                        case 3:
                            System.out.println("Your salary = "+e1.getSalary());
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag=false;}
                            break;
                        default:
                            System.out.println("Wrong input");
                    }

                }
                break;
            case 3:

                flag=true;
                while(flag){
                    System.out.println("Enter the transaction you want to do ");
                    System.out.println("1)change employee password\n3)Add employee\n3)Remove employee\n4)Get Empolyee record");
                    int option =cs.nextInt();
                    switch(option){
                        case 1:
                            ArrayList<Employee> employees=m1.getEmployees();

                            System.out.println("enter the employee you want to change password for");
                            for(int i=0;i<employees.size();i++){
                                System.out.println((i+1)+"-" + employees.get(i).name );



                            }
                              int emp=cs.nextInt() ;
                            m1.changeEmployeePassword(emp);
                            boolean res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag=false ;}
                            break;
                        case 2:
                            m1.addEmployee();

                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag=false ;}
                            break;
                        case 3:
                            m1.removeEmployee();
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag =false ;}
                            break;
                        case 4:
                            for(Employee e: m1.employees){
                                m1.getEmployeeRecords(e);
                            }
                            res=anothertransaction();
                            if(res){
                                continue;
                            }
                            else{flag =false ;}
                            break;
                    }
                }
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    public static boolean anothertransaction(){
        Scanner cs =new Scanner(System.in);
        System.out.println("Do you want to make another transaction");
        System.out.println("1)yes..........2)no");
        int res=cs.nextInt();
        if(res==1){
            return true;
        }
        else{
            return false;
        }
    }




}



