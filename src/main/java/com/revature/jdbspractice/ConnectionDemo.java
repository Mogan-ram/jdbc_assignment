package com.revature.jdbspractice;

import java.sql.*;

public class ConnectionDemo {
    public static void main(String[] args) {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
//        step:1 load the class of the jdbc driver but it has been deprecated from java 5
//        class.forName("com.cj.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Jason02statham@10");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String sql = "Select * from employee";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2) +" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6));

            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        try{
            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
