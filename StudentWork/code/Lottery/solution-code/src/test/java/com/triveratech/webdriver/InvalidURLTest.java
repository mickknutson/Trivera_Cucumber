package com.triveratech.webdriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.triveratech.selenium.SeleniumTestUtilities;

public class InvalidURLTest {

    public static WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //---------------------------------------------------------------------------//
    @Before
    public void beforeScenario() {

        baseUrl = "http://localhost:8080";

        driver = SeleniumTestUtilities.getHtmlUnitDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 15);
    }


    @Test
    public void testInvalidURL() throws Exception {
        driver.get(baseUrl + "/x");
        String result1 = driver.findElement(By.cssSelector("strong")).getText();
        assertEquals("Error - You have spent too much time on the net!", result1);
        
        String resultBack = driver.findElement(By.linkText("Back")).getText();
        assertEquals("Back", resultBack);
        assertEquals("Error 404 - You have spent too much time on the net.", driver.getTitle());
        
        driver.findElement(By.linkText("Back")).click();
        assertEquals("Lottery", driver.getTitle());
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
