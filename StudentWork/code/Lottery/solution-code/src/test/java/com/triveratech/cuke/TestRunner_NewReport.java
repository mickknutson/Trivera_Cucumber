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
		features = "classpath:features/Demo.feature"
)
public class TestRunner_NewReport {
	
} // The End...
