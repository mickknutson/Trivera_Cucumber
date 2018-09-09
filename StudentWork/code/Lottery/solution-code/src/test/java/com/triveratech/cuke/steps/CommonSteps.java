package com.triveratech.cuke.steps;

import com.triveratech.cuke.domain.Point;
import com.triveratech.selenium.SeleniumTestUtilities;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_tx.Givenyall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.triveratech.selenium.SeleniumTestUtilities.closeAlertAndGetItsText;
import static com.triveratech.selenium.SeleniumTestUtilities.takeScreenshot;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 *
 * Taking input:
 *
 * "([^"]*)"
 * "(.*)"
 * (.*)
 * '(\d+)'
 *
 */
public class CommonSteps {

    List<Point> coordinates;

    @Given("^I have coordinates:$")
    //                         DataTable<Map<String, List<String>>>
    public void coordinates(   List<Point> coordinates   )
            throws Throwable {
        this.coordinates = coordinates;
    }

    @When("^insert these coordinates$")
    public void insert_these_coordinates() throws Throwable {
        System.out.println("*****************************************************");
        System.out.println("coordinates: " + coordinates);
        System.out.println("*****************************************************");
    }

    @Given("^I have JSON:$")
    public void i_have_json(   List<String> jsonObjects  )
            throws Throwable {
        System.out.println("*****************************************************");
        // Convert String to JSONObject
        System.out.println("JSON: " + jsonObjects);
        System.out.println("*****************************************************");
    }

    @Then("^Common step$")
    public void common_step() throws Throwable {
        System.out.println("hello");
    }

    @Givenyall("all my backgound stuf")
    public void yall(){
        System.out.println("*****************************************************");
    }
	
	//---------------------------------------------------------------------------//


} // The End...
