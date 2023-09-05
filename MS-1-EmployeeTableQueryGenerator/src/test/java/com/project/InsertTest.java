package com.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.project.queryGenerator.Insert;

public class InsertTest {
    @Test
    public void testGetInsertQuery() {
        Insert insert = new Insert();
        
        String tableName = "employee";
        String[] columns = {"empid", "emp_name", "emp_salary", "emp_age", "emp_city"};

        String actualQuery = insert.getInsertQuery(tableName, columns);
        String expectedQuery = "INSERT INTO employee (empid, emp_name, emp_salary, emp_age, emp_city) VALUES (?, ?, ?, ?, ?)";

        assertEquals(expectedQuery, actualQuery);
    }
}
