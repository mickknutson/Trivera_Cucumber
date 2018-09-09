package com.triveratech.cuke;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(


        // 1st. Gather all potential methods
        glue = {"classpath:com/triveratech/cuke/steps" },

        // 2. find all required steps
		features = "classpath:features/Lottery.feature",

        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cuke/index.html"},

        monochrome = true
)
public class TestRunner_NewReport {

	@AfterClass
    public static void writeExtentReport() {

//        https://github.com/email2vimalraj/CucumberExtentReporter
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");

    }
	
} // The End...
