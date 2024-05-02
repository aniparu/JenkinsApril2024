package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.jvm.JvmReport;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\feature",glue="org\\stepdef",monochrome=true,plugin="json:JsonReport\\JsonRepo.json")
public class RunnerClass {
	
	@AfterClass
	public static void reportJvm() {
	     JvmReport.report("C:\\Users\\HP\\eclipse-workspace\\CucumberFpProject\\JsonReport\\JsonRepo.json");

	}

}
