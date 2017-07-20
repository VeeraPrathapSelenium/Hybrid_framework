package com.GenerateXML;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Test {

	@org.testng.annotations.Test
	
	
	public static void runXML() throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(3000);
		// Create object of TestNG Class
				TestNG runner=new TestNG();

				// Create a list of String 
				List<String> suitefiles=new ArrayList<String>();

				// Add xml file which you have to execute
				suitefiles.add("TestCases.xml");

				// now set xml file for execution
				runner.setTestSuites(suitefiles);

				// finally execute the runner using run method
				runner.run();
				

	}

}
