package com.TestCases;

import java.lang.reflect.InvocationTargetException;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenerateXML.WritingXMLForTestCases;
import com.ReadExcel.ReadExcel;
import com.SupportFiles.ControllerScript;

import bsh.This;

@Listeners(com.SupportFiles.TesngListeners.class)


public class Tc_01 extends ControllerScript {


	
	@Test()
	public  void doSomething() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		ReadExcel exl=new ReadExcel(WritingXMLForTestCases.testdatasheet);
		
		String className = this.getClass().getSimpleName();
	
		int testfoundrow=exl.searchTestCase(className, "BusinessFlow");
		
		if(!(testfoundrow==0))
		{
			
			ControllerScript.executeKeywords();
			
		}
		
	}
	
	
	
	

}
