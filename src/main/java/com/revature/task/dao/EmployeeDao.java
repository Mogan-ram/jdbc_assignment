package com.revature.task.dao;

import com.revature.task.model.Employee;
import com.revature.task.util.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "Select * from employee";
        try(Connection conn = DBconnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Employee emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("dep"),
                        rs.getString("desig"),
                        rs.getString("email"),
                        rs.getInt("salary")
                );
                employees.add(emp);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return  employees;
    }

    public Employee getEmployeeById(int empId){
        String sql = "Select * from employee where emp_id=?";
        Employee emp = null;
        try(Connection conn = DBconnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, empId);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("dep"),
                        rs.getString("desig"),
                        rs.getString("email"),
                        rs.getInt("salary")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return emp;
    }

    public  void insertEmployee(Employee emp){
        String sql = "{call insertion_emp(?,?,?,?,?)}";
        try(Connection conn = DBconnection.getConnection();
            CallableStatement cs = conn.prepareCall(sql)){
            cs.setString(1,emp.getEmpName());
            cs.setString(2,emp.getDepartment());
            cs.setString(3,emp.getDesignation());
            cs.setString(4,emp.getEmail());
            cs.setInt(5,emp.getSalary());
            cs.execute();
            System.out.println("Employee has been inserted successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateDesignation(int empId, String newDesignation){
        String sql = "update employee SET design = ? where emp_id = ?";

        try(Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, newDesignation);
            ps.setInt(2, empId);

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Designation update.");
            }else {
                System.out.println("No employee found with given id.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId){
        String sql = "delete from employee where emp_id = ?";

        try(Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,empId);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Employee has been deleted.");
            }else {
                System.out.println("No employee found with given id.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getTotatlEmployees(){
        String sql = " select count(*) from employee";
        try(Connection conn = DBconnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalByDepartment(String department){
        String sql = "select count(*) from employee where dep = ?";
        try(Connection conn = DBconnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,department);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
