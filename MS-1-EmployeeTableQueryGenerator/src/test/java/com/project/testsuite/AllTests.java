package com.project.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.project.DeleteTest;
import com.project.InsertTest;
import com.project.SelectTest;
import com.project.UpdateTest;

@RunWith(Suite.class)
@SuiteClasses({SelectTest.class,InsertTest.class,UpdateTest.class,DeleteTest.class})
public class AllTests {
	
}
