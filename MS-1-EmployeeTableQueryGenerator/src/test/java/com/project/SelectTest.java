
package com.project;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.queryGenerator.Select;

public class SelectTest {

	@Test
	public void test() {
			Select s1  = new Select();
			String outputSelectQuery = s1.getSelectQuery("employee","emp_name", 1);
			//testing output
			assertEquals("SELECT emp_name FROM employee WHERE empid = 1",outputSelectQuery);
	}

}
