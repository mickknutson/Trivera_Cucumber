package com.baselogic.cuke.steps;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baselogic.cuke.FlightDetails;
import com.baselogic.selenium.SeleniumTestUtilities;

import cucumber.api.java.en.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureSteps {

	public static WebDriver driver;
//	public static WebDriver driver = SeleniumTestUtilities.getFirefoxDriver();

	public List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

	//---------------------------------------------------------------------------//
    @Before
    public void beforeScenario(){

        // OSX:
        driver = SeleniumTestUtilities.getOSXFirefoxDriver();
//        driver = SeleniumTestUtilities.getOSXChromeDriver();

        // Windows:
//        driver = SeleniumTestUtilities.getWINFirefoxDriver();
//        driver = SeleniumTestUtilities.getWINhromeDriver();
    }

    @After
    public void afterScenario(){
//        SeleniumTestUtilities.closeDriver(driver);
        driver.close();
    }

/*
 * driver.findElement(By.id("resultStats"))
 */
    //---------------------------------------------------------------------------//

	
	// NEW STUFF::
    @Given("^User is on google\\.com$")
	public void user_on_home_page() throws Throwable {
		driver.get("https://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@When("^User searches for (\\d+)$")
//	@When("^User searches for \"([^\"]*)\"$")

//	@When("^User searches for \"([^\"]*)\"$")
	@When("^User searches for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_searches_for(String searchString, String searchDigit) throws Throwable {
		System.out.println("*** Input 1: [" + searchString + "]");
		System.out.println("*** Input 2: [" + searchDigit + "]");
		
	    WebElement search = driver.findElement(By.id("lst-ib"));
	    search.sendKeys(searchString + " " + searchDigit);
	    
	    WebElement button = driver.findElement(By.name("btnK"));
	    button.click();
	    Thread.sleep(5000);
	}

	@When("^The result should be \"([^\"]*)\"$")
	public void result(String total) throws Throwable {
		
		System.out.println("*** total is: [" + total + "]");
			    
	}

    //---------------------------------------------------------------------------//


} // The End...
