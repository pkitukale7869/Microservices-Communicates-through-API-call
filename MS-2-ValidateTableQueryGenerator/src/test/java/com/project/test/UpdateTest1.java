package com.project.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.dao.Update1;

public class UpdateTest1 {
    @Test
    public void testGetUpdateQuery() {
        Update1 update = new Update1();

        String tableName = "employee";
        int empId = 1;
        String empName = "JohnDoe";

        String actualQuery = update.getUpdateQuery(tableName, empId, empName);

        String expectedQuery = "UPDATE employee SET emp_name = 'JohnDoe' WHERE empid = 1";

        assertEquals(expectedQuery, actualQuery);
    }
}
