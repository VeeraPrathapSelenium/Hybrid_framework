package com.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.SupportFiles.TesngListeners.class)
public class Tc_03 {
	
	
	@Test	
	public static void doSomething()
	{
		System.out.println("TC_03");
		
	}
	
	
	
	

}
