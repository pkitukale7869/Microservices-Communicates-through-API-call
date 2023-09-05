package com.project.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.dao.Delete1;

public class DeleteTest1 {

	@Test
	public void testGetDeleteQuery() {
		Delete1 d1 = new Delete1();
		String actualQuery = d1.getDeleteQuery("employee", 1);
		String expectedQuery = "DELETE FROM employee WHERE empid = 1";
		assertEquals(expectedQuery,actualQuery);
	}

}
