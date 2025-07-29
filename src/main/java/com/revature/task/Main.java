package com.revature.task;

import com.revature.task.model.Employee;
import com.revature.task.service.EmployeeService;
import com.revature.task.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImpl(); // Use the interface
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------Employee Management Menu-------");
            System.out.println("1. Display All employees");
            System.out.println("2. Display Employee by ID");
            System.out.println("3. Insert New Employee");
            System.out.println("4. Update Designation");
            System.out.println("5. Delete Employee");
            System.out.println("6. Total number of employees");
            System.out.println("7. Employees in a Department");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    List<Employee> employees = service.getAllEmployees();
                    employees.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter employee ID: ");
                    int empId = sc.nextInt();
                    Employee emp = service.getEmployeeById(empId);
                    System.out.println(emp != null ? emp : "Employee not found");
                }
                case 3 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter salary: ");
                    int salary = sc.nextInt();

                    Employee newEmp = new Employee(0, name, dept, desig, email, salary);
                    boolean success = service.insertEmployee(newEmp);
                    System.out.println(success ? "✅ Inserted Successfully" : "❌ Insertion failed: Invalid data");
                }
                case 4 -> {
                    System.out.print("Enter emp ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new designation: ");
                    String newDesig = sc.nextLine();
                    boolean updated = service.updateDesignation(id, newDesig);
                    System.out.println(updated ? "✅ Updated successfully" : "❌ Update failed");
                }
                case 5 -> {
                    System.out.print("Enter employee ID to delete: ");
                    int id = sc.nextInt();
                    boolean deleted = service.deleteEmployee(id);
                    System.out.println(deleted ? "✅ Deleted successfully" : "❌ Delete failed");
                }
                case 6 -> {
                    int count = service.getTotalEmployees();
                    System.out.println("Total Employees: " + count);
                }
                case 7 -> {
                    System.out.print("Enter Department name: ");
                    String dept = sc.nextLine();
                    int count = service.getTotalByDepartment(dept);
                    System.out.println(dept + " Department Count: " + count);
                }
                case 8 -> {
                    System.out.println("👋 Bye Bye bro!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again");
            }
        }
    }
}