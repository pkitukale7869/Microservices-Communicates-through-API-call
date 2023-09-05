package com.project;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.queryGenerator.Update;

public class UpdateTest {
    @Test
    public void testGetUpdateQuery() {
        Update update = new Update();

        String tableName = "employee";
        int empId = 1;
        String empName = "JohnDoe";

        String actualQuery = update.getUpdateQuery(tableName, empId, empName);

        String expectedQuery = "UPDATE employee SET emp_name = 'JohnDoe' WHERE empid = 1";

        assertEquals(expectedQuery, actualQuery);
    }
}
