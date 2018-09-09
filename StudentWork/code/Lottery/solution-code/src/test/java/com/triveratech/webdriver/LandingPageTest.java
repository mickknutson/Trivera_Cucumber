package com.triveratech.webdriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterContext;
import com.triveratech.selenium.SeleniumTestUtilities;

import org.openqa.selenium.chrome.ChromeDriverService;

@RunWith(Parameterized.class)
public class LandingPageTest {

//    private static ChromeDriverService service;
	private WebDriver driver;

	private String baseUrl = "http://localhost:8080/";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();


    @Parameters(name = "Browser testing against:: {0}")
    public static Iterable<Object[]> params() {
        if (ParameterContext.isParameterSet()) {
            return Collections.singletonList(ParameterContext.getParameter(Object[].class));
        }
        return Arrays.asList(new Object[][] {{
                SeleniumTestUtilities.getHtmlUnitDriver()
        }});
    }


    public LandingPageTest(WebDriver driver) {
        super();
        this.driver = driver;
    }

    /*@BeforeClass
    public static void createAndStartService() throws Exception{
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("path/to/my/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
    }*/

    /*@AfterClass
    public static void createAndStopService() {
        service.stop();
    }*/

	@Before
	public void beforeEachTest() throws Exception {
//		driver = SeleniumTestUtilities.getHtmlUnitDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void landingPage_Success() throws Exception {

		driver.get(baseUrl + "/");
		try {
			assertEquals("Lottery", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		assertEquals("Welcome to our Lottery System", driver.findElement(By.cssSelector("h1")).getText());
		assertTrue(isElementPresent(By.id("size")));
		assertTrue(isElementPresent(By.id("range")));
		try {
			assertEquals("Pick My Lucky Numbers",
					driver.findElement(By.cssSelector("input[type=\"submit\"]")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("yes", driver.findElement(By.xpath("html/body/div[2]/form/input[3]")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void afterEachTest() throws Exception {
        SeleniumTestUtilities.closeDriver(driver);
//		driver.quit();

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}


    //---------------------------------------------------------------------------//
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
