package org.jvm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	
public static void report(String JsonPath) {
		
		
		
		//1.Mention the target folder location
		
		File   f = new File("C:\\Users\\HP\\eclipse-workspace\\CucumberFpProject\\JvmReport");

		
		//2.Add details to the report using Configuration class,
         
		Configuration   c = new Configuration(f, "Facebook");
		
		c.addClassifications("Platform Name:","Windows");
		c.addClassifications("Platform Version", "11");
		c.addClassifications("Browser Name", "Edge");
		c.addClassifications("Browser Version", "124");
		c.addClassifications("Sprint No", "3");
		
		
		//3.Add json file paths into List<String>
		List<String>   li = new ArrayList<String>();
		li.add(JsonPath);
		
		
		//4.Create object for ReportBuilder class
		ReportBuilder   r = new ReportBuilder(li,c );
		
		//created object call generateReports() method.
		r.generateReports();
 
		
		
		
	}
	

}
