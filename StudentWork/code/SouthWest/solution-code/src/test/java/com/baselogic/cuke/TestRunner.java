package com.baselogic.cuke;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:features"

//		, glue = {"classpath:com/jpmc/cuke/steps" }
		, glue = {"classpath:com/baselogic/cuke/steps" }

//        , plugin = { "pretty", "html:target/cuke/htmlreports" }
        , plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cuke/index.html"}

        , monochrome = true
)
public class TestRunner {
	
	@AfterClass
    public static void writeExtentReport() {
//        Reporter.loadXMLConfig(new File("./src/test/resources/report.xml"));

//        https://github.com/email2vimalraj/CucumberExtentReporter

        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");

    }
}
