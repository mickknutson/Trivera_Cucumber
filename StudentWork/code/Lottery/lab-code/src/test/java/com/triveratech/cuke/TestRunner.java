package com.triveratech.cuke;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:features/Lottery.feature",
		glue = {"classpath:com/triveratech/cuke/steps" },

        plugin = { "pretty", "html:target/cuke/" },
        monochrome = true
)
public class TestRunner {

	@AfterClass
    public static void writeExtentReport() {
    }
	
} // The End...
