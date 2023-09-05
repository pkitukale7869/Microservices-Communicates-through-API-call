package com.project;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.queryGenerator.Delete;

public class DeleteTest {

	@Test
	public void testGetDeleteQuery() {
		Delete d1 = new Delete();
		String actualQuery = d1.getDeleteQuery("employee", 1);
		String expectedQuery = "DELETE FROM employee WHERE empid = 1";
		assertEquals(expectedQuery,actualQuery);
	}

}
