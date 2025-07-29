package com.revature.task.service;

import com.revature.task.model.Employee;
import java.util.List;

public interface EmployeeService {
    boolean insertEmployee(Employee emp);
    boolean updateDesignation(int empId, String newDesignation);
    boolean deleteEmployee(int empId);
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
    int getTotalEmployees();
    int getTotalByDepartment(String department);
}