package com.revature.task.service;

import com.revature.task.dao.EmployeeDao;
import com.revature.task.model.Employee;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao = new EmployeeDao();

    @Override
    public boolean insertEmployee(Employee emp) {
        if (isValid(emp)) {
            dao.insertEmployee(emp);
            return true;
        } else {
            System.out.println("❌ Invalid employee data.");
            return false;
        }
    }

    @Override
    public boolean updateDesignation(int empId, String newDesignation) {
        return dao.updateDesignation(empId, newDesignation);
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return dao.deleteEmployee(empId);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return dao.getEmployeeById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public int getTotalEmployees() {
        return dao.getTotatlEmployees();
    }

    @Override
    public int getTotalByDepartment(String department) {
        return dao.getTotalByDepartment(department);
    }

    private boolean isValid(Employee emp) {
        return emp.getSalary() > 0 &&
                emp.getEmail().contains("@") &&
                !emp.getDepartment().isEmpty();
    }
}