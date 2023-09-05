package com.project.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.project.dao.Select1;

public class SelectTest1 {
	@Test
	public void test()
	{
		Select1 s1  = new Select1();
		
		String outputSelectQuery = s1.getSelectQuery("employee","emp_name", 1);
		String expectedQuery = "SELECT emp_name FROM employee WHERE empid = 1";
		
		assertEquals(expectedQuery,outputSelectQuery);
	}
	
	 @Test
	    public void test1() {
	        Select1 s2 = new Select1();
	        
	        String outputSelectSql = s2.getDataByCred("validate", 2222, "SecondPassword");
	        String expectedSql = "SELECT * FROM validate WHERE userid = 2222 AND password = 'SecondPassword'";

	        assertEquals(expectedSql, outputSelectSql);
	    }
	
	 @Test
	    public void test2() {
	        Select1 s3 = new Select1();

	        String outputQuery = s3.getSelectQueryWithOrderBy("employee", "emp_age");
	        String expectedQuery = "SELECT * FROM employee ORDER BY emp_age";

	        assertEquals(expectedQuery, outputQuery);
	    }
	 @Test
	 public void test3() {
		 Select1 s4 = new Select1();
		 String outputQuery = s4.getSelectQueryWithGroupBy("employee", "empid", "emp_age");
		 String expectedQuery = "SELECT empid, emp_age FROM employee GROUP BY empid, emp_age;";
		 assertEquals(expectedQuery,outputQuery);
	 }
	  @Test
	    public void test4() {
	        Select1 s5 = new Select1();
	        String outputQuery = s5.getSelectQueryByAgeAndId(30, 2);

	        String expectedQuery = "SELECT emp_city, empid, emp_name, emp_age, emp_salary "
	                + "FROM employee "
	                + "WHERE emp_age = 30 "
	                + "GROUP BY emp_city, empid, emp_name, emp_age, emp_salary "
	                + "HAVING empid = 2";

	        assertEquals(expectedQuery, outputQuery);
	    }
	  @Test
	  public void test5() {
		  Select1 s6 = new Select1();
		  String outputQuery = s6.getSelectQuery("employee", "empid", "emp_age");
		  String expectedQuery = "SELECT empid,emp_age FROM employee";
		  assertEquals(expectedQuery,outputQuery);
	  }
	  @Test
	  public void test6() {
		  Select1 s7 = new Select1();
		  String outputQuery = s7.getSelectQueryLimit("employee", "emp_age", 30,2);
		  String expectedQuery = "SELECT * FROM employee WHERE emp_age =30 LIMIT 2";
		  assertEquals(expectedQuery,outputQuery);
	  }
	 
}
