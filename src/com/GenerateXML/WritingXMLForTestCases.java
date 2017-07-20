package com.GenerateXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ReadExcel.ReadExcel;

public class WritingXMLForTestCases {
	public static String Homepath=System.getProperty("user.dir");
	public static String testdatasheet=Homepath+"\\Testdata\\Testdata.xlsx";
	public static List alltestcases;
	
	
	
	
	
	@Test(priority=1)
	
	
	public static void getTestcases()
	{
		
		
	ReadExcel exl=new ReadExcel(testdatasheet);	
		
	alltestcases=ReadExcel.storeTestcaseNeedToExecute("BusinessFlow");
		
	}
	
	
	
	@Test(priority=2)
	public static void startWriting() throws ParserConfigurationException, TransformerException
	{
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("suite");
				doc.appendChild(rootElement);
		
		// set attribute to root element
				Attr attr = doc.createAttribute("name");
				attr.setValue("Suite of Suits");
				rootElement .setAttributeNode(attr);
				
				
	   // Test
				Element test = doc.createElement("test");
				rootElement.appendChild(test);		
				
		// set attribute to Test element
				Attr testattr = doc.createAttribute("name");
				testattr.setValue("Test");
				test .setAttributeNode(testattr);
				
				
		// Classes
				Element classes= doc.createElement("classes");
				test.appendChild(classes);	
				
				//Class
				
				for(int i=0;i<=alltestcases.size()-1;i++)
				{
					
					//Class
					Element classinsideclasses= doc.createElement("class");
					classes.appendChild(classinsideclasses);
					
					// set attribute to Class element
					Attr classattr = doc.createAttribute("name");	
					
				classattr.setValue("com.TestCases."+alltestcases.get(i).toString());
				classinsideclasses .setAttributeNode(classattr);	
				}
				
				
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(Homepath+"\\TestCases.xml"));

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);

				System.out.println("File saved!");	
				
			
		
	}
	
	@AfterClass
	public static void runXML() throws InterruptedException
	{
		
		Thread.sleep(2000);
		
		
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
		
		
		System.out.println("hello");
		
	}

}
