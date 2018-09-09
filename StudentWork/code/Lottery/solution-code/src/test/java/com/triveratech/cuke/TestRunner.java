package com.triveratech.cuke;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        // Can be 1..* features
		features = "classpath:features/Lottery.feature",
//		features = "classpath:features/",

		// Should be **
		glue = {"classpath:com/triveratech/cuke/steps" },

        // Other config
        plugin = { "pretty", "html:target/cuke/" },

        monochrome = true
)
public class TestRunner {

	@BeforeClass
    public static void beforeClasss() {
        System.out.println("-----------------JUnit beforeClass()-----------------");
    }
	

	@AfterClass
    public static void writeExtentReport() {
        System.out.println("-----------------JUnit afterClass()-----------------");
    }

} // The End...
