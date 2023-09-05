package com.project.queryGenerator;

import org.springframework.stereotype.Component;

@Component
public class Update {
    public String getUpdateQuery(String tableName, int empId, String empName) {
        // Generating SQL Query
        String sql = "UPDATE " + tableName + " SET emp_name = '" + empName + "' WHERE empid = " + empId;
        return sql;
    }
}
