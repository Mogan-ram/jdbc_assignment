package com.revature.task;

import com.revature.task.dao.EmployeeDao;
import com.revature.task.model.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        EmployeeDao dao = new EmployeeDao();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n------Employee Management Menu-------");
            System.out.println("1. Display ALl employees");
            System.out.println("2. Display Employees by ID");
            System.out.println("3. Insert New Employees");
            System.out.println("4. Update Designation");
            System.out.println("5. Delete Employee");
            System.out.println("6. Total number of employees");
            System.out.println("7. Employees in a Department");
            System.out.println("8. Exit");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1->{
                    List<Employee> employees = dao.getAllEmployees();
                    employees.forEach(System.out::println);
                }case 2->{
                    System.out.print("Enter employee ID:");
                    int empId = sc.nextInt();
                    Employee emp = dao.getEmployeeById(empId);
                    System.out.println(emp!=null ?emp:"Employee not found");
                }case 3->{
                    System.out.print("Enter name:");
                    String name = sc.nextLine();
                    System.out.print("Enter department:");
                    String dept = sc.nextLine();
                    System.out.print("Enter designation:");
                    String desig = sc.nextLine();
                    System.out.print("Enter email:");
                    String email = sc.nextLine();
                    System.out.print("Enter salary:");
                    int salary = sc.nextInt();

                    Employee newEmp = new Employee(0,name,dept,desig,email, salary);
                    dao.insertEmployee(newEmp);

                }case 4->{
                    System.out.print("Enter emp id:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new designation:");
                    String newDesig =sc.nextLine();
                    dao.updateDesignation(id, newDesig);
                }case 5->{
                    System.out.print("Enter employee ID to delete:");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }case 6->{
                    int count = dao.getTotatlEmployees();
                    System.out.println("Total Employees: "+count);
                }case 7->{
                    System.out.print("Enter Department name: ");
                    String dept = sc.nextLine();
                    int count = dao.getTotalByDepartment(dept);
                    System.out.println(dept+" "+"Department Count: "+count);
                }case 8->{
                    System.out.println("Bye Bye bro");
                    sc.close();
                    return;
                } default->{
                    System.out.println("Invalid choice, enter valid value");
                }
            }


        }
    }
}
