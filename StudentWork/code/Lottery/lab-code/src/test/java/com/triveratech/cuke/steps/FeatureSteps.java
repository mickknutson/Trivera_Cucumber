package com.triveratech.cuke.steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triveratech.selenium.SeleniumTestUtilities;
import static com.triveratech.selenium.SeleniumTestUtilities.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class FeatureSteps {

	public static WebDriver driver;
	private WebDriverWait wait;

	//---------------------------------------------------------------------------//
    @Before
    public void beforeScenario(){

        driver = SeleniumTestUtilities.chooseDriverBasedOnOperatingSystem();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void afterScenario(){
        SeleniumTestUtilities.closeDriver(driver);
    }


    //---------------------------------------------------------------------------//

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Exception {

		driver.get("http://localhost:8080");

        takeScreenshot(driver, "user_is_on_Home_Page");
	}

	//---------------------------------------------------------------------------//
	// LAB: Need to add respective Gherkin action annotations to the following
	//      methods...

	
	public void user_choose_lottery_numbers(String input) throws Exception {
        WebElement size = driver.findElement(By.id("size"));
        size.clear();
        size.sendKeys(input);
	}



	public void user_wants_a_maximum_range_of_for_lottery_numbers(String input) throws Exception {
        WebElement range = driver.findElement(By.id("range"));
        range.clear();
        range.sendKeys(input);
	}


    public void user_chooses_to_Pick_My_Lucky_Numbers() throws Exception {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();
    }


	public void user_is_displayed_Lottery_results() throws Exception {

        String expectedTitle = "Lottery Results";
        String actualTitle = driver.getTitle();

        takeScreenshot(driver, "user_is_displayed_Lottery_results");
        assertThat(expectedTitle, is(equalTo(actualTitle)));

        WebElement header = driver.findElement(By.cssSelector("h1"));
        assertThat(header.getText(), containsString("Your Lottery Results"));

        WebElement result0_0 = driver.findElement(By.id("0-0"));
        System.out.println("* result0_0: " + result0_0.getText());
    }


	public void user_chooses_to_be_given_more_numbers() throws Exception {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();

        takeScreenshot(driver, "user_chooses_to_be_given_more_numbers");
        WebElement result0_1 = driver.findElement(By.id("0-1"));
        System.out.println("**** result0_1: " + result0_1.getText());
	}

    
    
    public void user_enters_for_size_and_for_range(String sizeInput, String rangeInput) throws Throwable {

    	// Range
    	WebElement range = driver.findElement(By.id("range"));
    	range.clear();
    	range.sendKeys(String.valueOf(rangeInput));
    	
    	//Size
    	WebElement size = driver.findElement(By.id("size"));
    	size.clear();
    	size.sendKeys(String.valueOf(sizeInput));

    	takeScreenshot(driver, "size_and_range_entry");
    	
    }

   
    public void user_enters_a_maximum_range_of_for_lottery_numbers(String input) throws Throwable {
    	WebElement range = driver.findElement(By.id("range"));
    	range.clear();
    	range.sendKeys(String.valueOf(input));
    	takeScreenshot(driver, "range_"+input);
    }
    
    
    public void user_enters_lottery_numbers(String input) throws Throwable {
    	WebElement size = driver.findElement(By.id("size"));
    	size.clear();
    	size.sendKeys(String.valueOf(input));
    	takeScreenshot(driver, "size_"+input);
    }
    
    public void user_clicks_to_Pick_My_Lucky_Numbers() throws Throwable {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();
        
        Thread.sleep(3_000);
        
        takeScreenshot(driver, "user_clicks_to_Pick_My_Lucky_Numbers");
    }
	
    public void user_is_displayed_an_alert_for_size_entry() throws Throwable {
        takeScreenshot(driver, "user_is_displayed_an_alert_for_size_entry");
        
        String result = closeAlertAndGetItsText(driver);

        assertThat(result, containsString("Number requested must be numeric"));

        Thread.sleep(3_000);

        takeScreenshot(driver, "user_is_displayed_an_alert_for_size_entry-post");
    }

    public void user_is_displayed_an_alert_for_range_entry() throws Throwable {
        takeScreenshot(driver, "user_is_displayed_an_alert_for_range_entry");

        String result = closeAlertAndGetItsText(driver);

        assertThat(result, containsString("Max requested must be numeric"));

        Thread.sleep(3_000);

        takeScreenshot(driver, "user_is_displayed_an_alert_for_range_entry-post");
    }
	
	//---------------------------------------------------------------------------//


} // The End...
