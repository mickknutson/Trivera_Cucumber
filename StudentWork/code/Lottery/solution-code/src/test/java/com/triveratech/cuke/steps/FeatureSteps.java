package com.triveratech.cuke.steps;

import static com.triveratech.selenium.SeleniumTestUtilities.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triveratech.selenium.SeleniumTestUtilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * Taking input:
 * -------------
 * "([^"]*)"
 * '(\d+)'
 *
 * Used in these labs:
 * -------------------
 * "(.*)"
 * (.*)
 *
 */
public class FeatureSteps {

	public static WebDriver driver;
	private WebDriverWait wait;

	List<String> animals;

	//---------------------------------------------------------------------------//
    @Before
    public void beforeScenario(){
        System.out.println("4 -----------------Start of FEATURE Scenario-----------------");

        driver = SeleniumTestUtilities.chooseDriverBasedOnOperatingSystem();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 15);
    }

    @Before
    public void beforeScenario3(){
        System.out.println("3 -----------------Start of FEATURE Scenario-----------------");
    }


    @After
    public void afterScenario(){
        System.out.println("-----------------END of FEATURE Scenario-----------------");
        SeleniumTestUtilities.closeDriver(driver);
    }


    @Given("^Take an input: '(.*)' and '(.*)'$")
//    @Given("^Take an input: \"([^\"]*)\" and \"([^\"]*)\"$")
    //    @Given("^Take an input: (.*) and (.*)")
//    @Given("^Take an input: (.*)$")
//    @Given("^Take an input: (.*)$")
//    @Given("^Take an input: (.*) and (.*)$")
    public void foobar(String in1, String in2) throws Exception {

        // open a json file
        // open a CSV file

        // Use Jackson to marshall a Java Object to JSON
        // pull a REST URI

        // execute JDBC to pull test data

//        Execute another JUniut test class
        // execute a shell script
        // execute RestTemplate
        // RestEasy

        System.out.println("*****************************************************");
        System.out.println("Input: " + in1 +", " + in2);
        System.out.println("*****************************************************");
    }


    //---------------------------------------------------------------------------//

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Exception {

		driver.get("http://localhost:8080");

        takeScreenshot(driver, "user_is_on_Home_Page");
	}


//	@When("^User Enters Source as '(.*?)'$")
	public void user_Enters_Source_as(String source) throws Exception {

        String rangeExpected = "42";

        WebElement size = driver.findElement(By.id("size"));
        size.clear();
        size.sendKeys(source);

        WebElement range = driver.findElement(By.id("range"));
        range.clear();
        range.sendKeys(rangeExpected);

        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();

        String expectedTitle = "Lottery Results";
        String actualTitle = driver.getTitle();

        assertThat(expectedTitle, is(equalTo(actualTitle)));

        WebElement h3 = driver.findElement(By.cssSelector("h3.center"));
        //h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "///h3")));

        assertThat(h3.getText(), containsString("The value supplied for the Max Range is invalid!"));
        WebElement rowOne = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]"));
    }

	
	@When("^User chooses '(\\d+)' lottery numbers$")
	public void user_choose_lottery_numbers(String input) throws Exception {
        WebElement size = driver.findElement(By.id("size"));
//        assertElementPresent(size);
        size.clear();
        size.sendKeys(input);
	}

	@When("^User wants a maximum range of '(\\d+)' for lottery numbers$")
	public void user_wants_a_maximum_range_of_for_lottery_numbers(String input) throws Exception {
        WebElement range = driver.findElement(By.id("range"));
        range.clear();
        range.sendKeys(input);
	}

    @When("^User chooses to Pick My Lucky Numbers$")
    public void user_chooses_to_Pick_My_Lucky_Numbers() throws Exception {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();
    }

	@Then("^User is displayed Lottery results$")
	public void user_is_displayed_Lottery_results() throws Exception {

        String expectedTitle = "Lottery Results";
        String actualTitle = driver.getTitle();

//        if(log.isTraceEnabled()) {
        // base64.encode(PNG.byte[]) == base64.encode(expected.byte[])
            takeScreenshot(driver, "user_is_displayed_Lottery_results");
//        }

        assertThat(expectedTitle, is(equalTo(actualTitle)));

        WebElement header = driver.findElement(By.cssSelector("h1"));
        assertThat(header.getText(), containsString("Your Lottery Results"));

        WebElement result0_0 = driver.findElement(By.id("0-0")); // TABLE ROW
//        WebElement resultC0_0 = driver.findElement(By.cssSelector("id=0-0"));
//        WebElement resultX0_0 = driver.findElement(By.xpath("//span[@id='0-0']"));

//        System.out.println(driver.getPageSource());
        System.out.println("* result0_0: " + result0_0.getText());
    }




	@When("^User chooses to be given more numbers$")
	public void user_chooses_to_be_given_more_numbers() throws Exception {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();

        takeScreenshot(driver, "user_chooses_to_be_given_more_numbers");
        WebElement result0_1 = driver.findElement(By.id("0-1"));
        System.out.println("**** result0_1: " + result0_1.getText());
	}

	
	
    @Given("^User is on Lottery Page$")
    public void user_is_on_Lottery_Page() throws Throwable {
        driver.get("http://localhost:8080");
    }
    
    
    @Given("^User enters \"([^\"]*)\" for size and \"([^\"]*)\" for range$")
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

    @When("^User enters a maximum range of \"([^\"]*)\" for lottery numbers$")
    public void user_enters_a_maximum_range_of_for_lottery_numbers(String input) throws Throwable {
    	//System.out.println(input);
    	WebElement range = driver.findElement(By.id("range"));
    	range.clear();
    	range.sendKeys(String.valueOf(input));
    	takeScreenshot(driver, "range_"+input);
    }
    
    
    @When("^User enters \"([^\"]*)\" lottery numbers$")
    public void user_enters_lottery_numbers(String input) throws Throwable {
//    	System.out.println(input);
    	WebElement size = driver.findElement(By.id("size"));
    	size.clear();
    	size.sendKeys(String.valueOf(input));
    	takeScreenshot(driver, "size_"+input);
    }
    
    @When("^User clicks to Pick My Lucky Numbers$")
    public void user_clicks_to_Pick_My_Lucky_Numbers() throws Throwable {
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();
        
        Thread.sleep(3_000);
//        wait.withMessage("********************** waiting *******************");
        
        takeScreenshot(driver, "user_clicks_to_Pick_My_Lucky_Numbers");
    }
	
    @Then("^User is displayed an alert for size entry$")
    public void user_is_displayed_an_alert_for_size_entry() throws Throwable {
        takeScreenshot(driver, "user_is_displayed_an_alert_for_size_entry");
        
        String result = closeAlertAndGetItsText(driver);

        assertThat(result, containsString("Number requested must be numeric"));

        Thread.sleep(3_000);

        takeScreenshot(driver, "user_is_displayed_an_alert_for_size_entry-post");
    }

    @Then("^User is displayed an alert for range entry$")
    public void user_is_displayed_an_alert_for_range_entry() throws Throwable {
        takeScreenshot(driver, "user_is_displayed_an_alert_for_range_entry");

        String result = closeAlertAndGetItsText(driver);

        assertThat(result, containsString("Max requested must be numeric"));

        Thread.sleep(3_000);

        takeScreenshot(driver, "user_is_displayed_an_alert_for_range_entry-post");
    }
	
	//---------------------------------------------------------------------------//



	//---------------------------------------------------------------------------//


} // The End...
