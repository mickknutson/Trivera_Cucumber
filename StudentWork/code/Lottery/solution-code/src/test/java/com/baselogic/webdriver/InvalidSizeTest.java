package com.baselogic.webdriver;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.baselogic.selenium.SeleniumTestUtilities;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidSizeTest {

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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 15);
    }


    @Test
  public void testInvalidSize() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("size")).clear();
    driver.findElement(By.id("size")).sendKeys("12");
    driver.findElement(By.id("range")).clear();
    driver.findElement(By.id("range")).sendKeys("12");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Lottery Error", driver.getTitle());
    
    assertTrue(driver.findElement(By.cssSelector("h3.center"))
    		.getText()
    		.matches("^The value supplied for the Number to pick is invalid!$"));
    
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