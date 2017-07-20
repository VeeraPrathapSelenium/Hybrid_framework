package com.SupportFiles;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.GenerateXML.WritingXMLForTestCases;
import com.ReadExcel.ReadExcel;

public class ControllerScript extends ReadExcel {
	
	
	public static void executeKeywords() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		
		Class classname=Class.forName("com.CommonBusinessFunctions.CommonBusinessFunctions");
		
		Object obj=classname.newInstance();
			
		ControllerScript c=new ControllerScript();
		
		int colcnt=c.colCount("BusinessFlow", ReadExcel.tcfoundrow);
		
		for(int cl=3;cl<=colcnt;cl++)
		{
			int val=c.sht.getRow(c.tcfoundrow).getCell(cl).getCellType();
						
			if((val==1))
			{
				String keyword=c.sht.getRow(c.tcfoundrow).getCell(cl).getStringCellValue();
				
				
				Method method=classname.getDeclaredMethod(keyword, null);

				method.invoke(obj, null);
				
				
			}
			else
			{
				
				break;
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	

}
