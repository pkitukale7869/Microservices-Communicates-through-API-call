package com.project.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.project.dao.Insert1;
public class InsertTest1 {
	@Test
    public void test1() {
        Insert1 insert1 = new Insert1();

        String[] columns = {"emp_name", "emp_age"};
        
        String outputInsertQuery = insert1.getInsertQuery("employee", columns);
        String expectedQuery = "INSERT INTO employee (emp_name, emp_age) VALUES (?, ?)";
        
        assertEquals(expectedQuery, outputInsertQuery);
    }
	@Test
	public void test2() {
		Insert1 insert2 = new Insert1();
		
		String[] columns = {"empid", "password", "data"};
		
		String outputInsertQuery = insert2.insertLoginCred("validate", columns);
		String expectedQuery = "INSERT INTO validate (empid, password, data) VALUES (?, ?, ?)";
		
		assertEquals(expectedQuery, outputInsertQuery);
	}
}
