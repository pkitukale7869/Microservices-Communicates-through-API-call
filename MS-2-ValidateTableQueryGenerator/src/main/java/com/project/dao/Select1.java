package com.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Select1 {
    //Full Dynamic Implementation trial
	public List<Map<String, Object>> getFinalSelectQuery(String key, Object Values)
	{
		return null;
		
	}
	
	
	
	
	
	
	//////Existing Logic
	//Order By Implementation
	public String getSelectQueryWithOrderBy(String tableName, String orderByColumn) 
	{
		// Generate SQL Query with SELECT *
		String obsql = "SELECT * FROM " + tableName + " ORDER BY " + orderByColumn;
		return obsql;
	}    
	 /****************************************************************/
	//Half Dynamic Implementation
	public String getDataByCred(String tableName, int userid, String password) {
		String sql = "SELECT * FROM " + tableName +" WHERE userid = " + userid +" AND password = "+"'"+password+"'";
	    return sql;
	}
	public String getSelectQuery(String tableName,String coloumnName, int empId) 
    {
    	String sql = "SELECT "+coloumnName +" FROM " + tableName +" WHERE empid = " + empId;
        return sql;
    }
    //Group By Implementation
    public String getSelectQueryWithGroupBy(String tableName, String column1, String column2) 
    {
        // Generate SQL Query with GROUP BY
        String sql = "SELECT " + column1 + ", " + column2 + " FROM " + tableName + " GROUP BY " + column1 + ", " + column2 + ";";
        return sql;
    }
    //HAVING implementation with GROUP BY
    public String getSelectQueryByAgeAndId(int empAge, int empId) 
    {
        // Generating SQL Query
        String sql = "SELECT emp_city, empid, emp_name, emp_age, emp_salary "
                   + "FROM employee "
                   + "WHERE emp_age = " + empAge
                   + " GROUP BY emp_city, empid, emp_name, emp_age, emp_salary "
                   + "HAVING empid = " + empId;

        return sql;
    }
    //DISTINCT implementation using 2 coloumns ID
    public String getSelectQuery(String tableName, String coloumnName1, String coloumnName2) {
    	String sql = "SELECT "+coloumnName1 +","+coloumnName2+" FROM " + tableName;
        return sql;
	}
    //LIMIT implementation using using one condition and limit value
    public String getSelectQueryLimit(String tableName, String columnName, int columnNameValue, int lit) {
		
    	//SELECT * FROM employee WHERE emp_age=30 LIMIT 2;
    	String sql = "SELECT * FROM "+tableName+" WHERE "+columnName+" ="+columnNameValue+" LIMIT "+lit;
    	return sql;
	}
    /*public String getSelectQueryWithGroupBy(String tableName, String groupByColumn1, String groupByColumn2) {
        // Generate SQL Query with GROUP BY
        String sql = "SELECT * FROM " + tableName + " GROUP BY " + groupByColumn1 + ", " + groupByColumn2;
        return sql;
    }
    public String getSelectQueryWithGroupBy(String tableName, String[] columns, String[] groupByColumns) {
        // Generate SQL Query with GROUP BY
        StringBuilder sql = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]);
            if (i < columns.length - 1) {
                sql.append(", ");
            }
        }

        sql.append(" FROM ").append(tableName).append(" GROUP BY ");
        
        for (int i = 0; i < groupByColumns.length; i++) {
            sql.append(groupByColumns[i]);
            if (i < groupByColumns.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(";");
        return sql.toString();
        */






	public String getDataforMs(String tableName, int userid) {
		String sql = "SELECT password FROM " + tableName +" WHERE userid = " + userid;
		return sql;
	}
}
