//package com.project.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//			
//import com.project.queryGenerator.Select;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private Select select;
//
//    public List<Map<String, Object>> getEmployees(String tableName, int empId) {
//        try {
//        	System.out.println("Now in Employee Service Class");
//            String sql = select.getSelectQuery(tableName, empId);
//            // Execute the SQL query and get the result using JdbcTemplate
//            // For demonstration purposes, we are returning an empty list
//            // You should implement the actual JDBC query execution here
//            return new ArrayList<>();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }
//
//    // Other methods (insertEmployeeData, updateEmployeeData, deleteEmployeeData) remain unchanged
//}
