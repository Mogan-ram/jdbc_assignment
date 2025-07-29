package com.revature.collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeMain {
    public static void main(String[] args) {
    Employee emp1 = new Employee(10,"John",40000);
    Employee emp2 = new Employee(11,"Bond",40000);
    Employee emp3 = new Employee(12,"Rambo",40000);

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(emp1);
    employeeList.add(emp2);
    employeeList.add(emp3);
//    Collections.sort(employeeList, new EmpIdComparator());
    Collections.sort(employeeList, new NameComparator());
    System.out.println(employeeList);


    }

}
