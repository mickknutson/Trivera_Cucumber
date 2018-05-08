package com.triveratech.webdriver;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright (c) 2018 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triveratech.selenium.SeleniumTestUtilities;

public class ValidDataTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = SeleniumTestUtilities.getHtmlUnitDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test
	public void noop() throws Exception {
	}
	
//	@Test
	public void testValidData() throws Exception {
		driver.get(baseUrl + "/");

		WebElement sizeField = driver.findElement(By.id("size"));
		sizeField.clear();
		sizeField.sendKeys("6");

		int sizeValue = 6;

		WebElement range = driver.findElement(By.id("range"));
		range.clear();
		range.sendKeys("44");

		int rangeValue = 44;

		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
		submitButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Lottery Results"));
		String expectedTitle = "Lottery Results";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);

		if (!isElementPresent(By.xpath("html/body/table/tbody/tr[2]/td[1]"))) {
			fail("First column is not found");
		}

		if (isElementPresent(By.xpath("html/body/table/tbody/tr[2]/td[2]"))) {
			fail("Second column is found");
		}

		List<WebElement> entries1 = driver.findElements(By.xpath("html/body/table/tbody/tr[2]/td[1]/span"));

		assertTrue(entries1.size() == sizeValue);

		String col1row1 = driver.findElement(By.id("0-0")).getText();

		String col1row2 = driver.findElement(By.id("0-1")).getText();

		WebElement moreButton = driver.findElement(By.cssSelector("input[type='submit']"));
		moreButton.click();

		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[1]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[2]")));
		assertFalse(isElementPresent(By.xpath("//table/tbody/tr[2]/td[3]")));
		assertFalse(isElementPresent(By.xpath("//table/tbody/tr[2]/td[4]")));

		assertEquals(col1row1, driver.findElement(By.id("1-0")).getText());

		assertEquals(col1row2, driver.findElement(By.id("1-1")).getText());

		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals(col1row1, driver.findElement(By.id("2-0")).getText());
		assertEquals(col1row2, driver.findElement(By.id("2-1")).getText());
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[1]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[2]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[3]")));
		assertFalse(isElementPresent(By.xpath("//table/tbody/tr[2]/td[4]")));
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals(col1row1, driver.findElement(By.id("3-0")).getText());
		assertEquals(col1row2, driver.findElement(By.id("3-1")).getText());
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[1]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[2]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[3]")));
		assertTrue(isElementPresent(By.xpath("//table/tbody/tr[2]/td[4]")));
	}

	@After
	public void tearDown() throws Exception {
        SeleniumTestUtilities.closeDriver(driver);
//		driver.quit();
        
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

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
