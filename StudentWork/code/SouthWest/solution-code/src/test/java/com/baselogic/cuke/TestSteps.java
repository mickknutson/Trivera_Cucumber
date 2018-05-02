package com.baselogic.cuke;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	public static String				driverPath				= "C:\\StudentWork\\jars\\ChromeDriver\\";
	public static WebDriver			driver						= null;

	public List<FlightDetails>	flightDetailsList	= new ArrayList<FlightDetails>();

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.southwest.com");
		driver.manage().window().maximize();

	}

	@When("^User Look For Flights$")
	public void user_Look_For_Flights() throws Throwable {

		driver.findElement(By.id("booking-form--flight-tab")).click();

	}

	@When("^User Enters Source as \"(.*?)\"$")
	public void user_Enters_Source_as(String arg1) throws Throwable {

		driver.findElement(By.id("air-city-departure")).clear();
		driver.findElement(By.id("air-city-departure")).sendKeys(arg1);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("b")).click();

	}

	@When("^User Enters Destination as \"(.*?)\"$")
	public void user_Enters_Destination_as(String arg1) throws Throwable {

		driver.findElement(By.id("air-city-arrival")).clear();
		driver.findElement(By.id("air-city-arrival")).sendKeys(arg1);
		Thread.sleep(3000);
		driver.findElement(By.id("air-city-arrival-menu-item1")).click();
		Thread.sleep(2000);
	}

	@Then("^Click On Adults$")
	public void click_On_Adults() throws Throwable {

		driver.findElement(By.id("air-pax-count-adults")).click();
		Thread.sleep(2000);

	}

	@Then("^Add (\\d+) Adults$")
	public void add_Adults(int arg1) throws Throwable {

		for (int i = 0; i < arg1; i++) {
			driver.findElement(By.id("jb-number-selector-more")).click();
		}

	}

	@Then("^Click On Seniors$")
	public void click_On_Seniors() throws Throwable {

		driver.findElement(By.id("air-pax-count-seniors")).click();
		Thread.sleep(2000);

	}

	@Then("^Add (\\d+) Seniors$")
	public void add_Seniors(int arg1) throws Throwable {

		for (int i = 0; i < arg1; i++) {
			driver.findElement(By.id("jb-number-selector-more")).click();
		}

	}

	@Then("^User Click On Search Button$")
	public void user_Click_On_Search_Button() throws Throwable {

		driver.findElement(By.id("jb-booking-form-submit-button")).click();

	}

	@Then("^User Displayed Successfully Search$")
	public void user_Displayed_Successfully_Search() throws Throwable {

		System.out.println("Search successfully Done.");

	}

	@When("^User read Searched Detail$")
	public void user_read_Searched_Detail() throws Throwable {

		Thread.sleep(5000);
		List<WebElement> trlist = driver.findElements(By.className("bugTableRow"));
		for (WebElement e : trlist) {
			FlightDetails f = new FlightDetails();
			f.setDepartTime(e.findElement(By.className("depart_column")).getText());
			f.setArrivalTime(e.findElement(By.className("arrive_column")).getText());
			f.setTravelTime(e.findElement(By.cssSelector("span.bugText.duration")).getText());
			flightDetailsList.add(f);
		}

	}

	@Then("^Display Searched Detail one bye one\\.$")
	public void display_Searched_Detail_one_bye_one() throws Throwable {

		for (FlightDetails f : flightDetailsList) {
			System.out.println("Depart Time : " + f.getDepartTime() + "   Arrival Time : " + f.getArrivalTime()
					+ "   Travel Time : " + f.getTravelTime());
		}
	}

}
