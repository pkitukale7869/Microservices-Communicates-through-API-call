package com.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.queryGenerator.Delete;
import com.project.queryGenerator.Insert;
import com.project.queryGenerator.Select;
import com.project.queryGenerator.Update;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private Select select;
    public String getdetailms1(int empid) {
    	String mssql = select.getDataforMs("employee", empid);
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(mssql);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error executing SQL query: " + e.getMessage();
        }
//    	String mssql =  select.getDataforMs("employee",empid);
//    	return jdbcTemplate.toString();
    }
    @Autowired
    private Insert insert;

    public String insertEmployeeData(String tableName, String[] columns, Object[] values) {
        try {
            String sql = insert.getInsertQuery(tableName, columns);
            jdbcTemplate.update(sql, values);

            return "Employee details inserted successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to insert employee details.";
        }
    }
    //Login Logout Implementation

    public String insertLoginCred(String tableName, String[] columns, Object[] values) {
        try {
            String sql = insert.insertLoginCred(tableName, columns);
            System.out.println(sql);
            jdbcTemplate.update(sql, values);

            return "Login details inserted successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to insert Login Cred.";
        }
    }
    public List<Map<String, Object>> getDetailsByIdPass(String userid, String password) {
		try {
			String sql =  select.getDataByCred("employee",userid,password);
			System.out.println(sql);
			return jdbcTemplate.queryForList(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
    //Login Logout Implementation Done

    public List<Map<String, Object>> getDetails(String coloumnName, int empId) 
    {
        try {
            String sql = select.getSelectQuery("employee",coloumnName, empId);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    //OrderBy Coloumn
    public List<Map<String, Object>> getDetailsOrderedBy(String orderByColumn) 
    {
        try {
            String sql = select.getSelectQueryWithOrderBy("employee", orderByColumn);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    //Group By 2 Columns
    public List<Map<String, Object>> getDetailsGroupedBy(String columns, String groupByColumns) 
    {
        try {
            String sql = select.getSelectQueryWithGroupBy("employee", columns, groupByColumns);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public List<Map<String, Object>> getEmployeesByAgeAndId(int empAge, int empId) 
    {
        try {
            String sql = select.getSelectQueryByAgeAndId(empAge, empId);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    //Distinct
    public List<Map<String, Object>> getDetailsDistinct(String coloumnName1, String coloumnName2) 
    {
    	try {
            String sql = select.getSelectQuery("employee",coloumnName1, coloumnName2);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
	}
    //Limit
    public List<Map<String, Object>> getDetailsLimit(String columnName, int columnNameValue, int lit) {
    	try {
            String sql = select.getSelectQueryLimit("employee",columnName, columnNameValue, lit);
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
        	System.out.println("Error is in UserDAO");
            e.printStackTrace();
        }
        return new ArrayList<>();
	}
    
    @Autowired
    private Update update;

    public String updateEmployeeData(int empId, String empName) 
    {
        try {
            // Using the Update class to generate the dynamic SQL UPDATE query
            String sql = update.getUpdateQuery("employee", empId, empName);

            // Executing the SQL UPDATE query
            jdbcTemplate.update(sql);

            return "Employee name updated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update employee name.";
        }
    }
    
    @Autowired
    private Delete delete;

    public String deleteEmployeeData(int empId) 
    {
        try {
            // Using the Delete class to generate the dynamic SQL DELETE query
            String sql = delete.getDeleteQuery("employee", empId);

            // Executing the SQL DELETE query
            jdbcTemplate.update(sql);

            return "Employee with empid " + empId + " deleted successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete employee with empid " + empId + ".";
        }
    }


	
}
