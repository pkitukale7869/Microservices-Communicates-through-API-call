package com.project.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.project.test.DeleteTest1;
import com.project.test.InsertTest1;
import com.project.test.SelectTest1;
import com.project.test.UpdateTest1;

@RunWith(Suite.class)
@SuiteClasses({SelectTest1.class,InsertTest1.class,UpdateTest1.class,DeleteTest1.class})
public class TestAll {
	
}
