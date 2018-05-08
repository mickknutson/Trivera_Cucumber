package com.triveratech.webdriver;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static org.hamcrest.CoreMatchers.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.triveratech.selenium.SeleniumTestUtilities;

public class NonNumericRangeTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = SeleniumTestUtilities.getHtmlUnitDriver();
		baseUrl = "http://localhost:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void lotteryPick_Rang_Field__Error_NonNumeric() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("range")).clear();
		driver.findElement(By.id("range")).sendKeys("ABC");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        String expected = "Please tell me the number of Lottery picks you need[\\s\\S]*";
        String expected2 = "tell me the number of Lottery picks";
		String actual = closeAlertAndGetItsText();

		// JUnit Matchers
		assertTrue(actual.matches(expected));
		// Hamcrest:
		assertThat(actual, containsString(expected2));

	}


    //---------------------------------------------------------------------------//


    @After
	public void tearDown() throws Exception {
        SeleniumTestUtilities.closeDriver(driver);
//		driver.quit();

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}



    //---------------------------------------------------------------------------//
    //---------------------------------------------------------------------------//

    private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
