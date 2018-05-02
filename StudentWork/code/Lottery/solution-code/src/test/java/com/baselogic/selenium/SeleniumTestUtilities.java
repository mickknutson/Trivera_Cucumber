package com.baselogic.selenium;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public final class SeleniumTestUtilities {

    public static final String PATH_WIN = "..\\..\\..\\Tools\\DRIVERS\\";
    public static final String PATH_MAC = "../../../Tools/DRIVERS/";

    public static final String DIR = "target/screen_shots/";
    public static final String EXT = ".png";

    public static final Random random = new Random(4);


    public static String getOSXFirefoxDriverPath() {
        return PATH_MAC + "geckodriver";
    }

    public static String getOSXChromeDriverPath() {
        return PATH_MAC + "chromedriver";
    }

    /**
     * Dynamically find the driver to use.
     * @return WebDriver
     */
    public static WebDriver chooseDriverBasedOnOperatingSystem() {

        String os = System.getProperty("os.name");
        System.out.println("Operating System: " + os);

        if (os.contains("Win")) {
            // Windows:
            return getWINFirefoxDriver();
//            return getWINChromeDriver();
        } else {
            // OSX:
            return getOSXFirefoxDriver();
//            return getOSXChromeDriver();

        }
    }


    /**
     * SeleniumTestUtilities.getOSXFirefoxDriver()
     * TODO: https://github.com/mozilla/geckodriver/releases
     * FIXME: FooBar
     * NOTE: Hello
     */
    public static WebDriver getOSXFirefoxDriver() {
        String GECKO = PATH_MAC + "geckodriver";
        return getFirefoxDriver(GECKO);
    }

    /**
     * SeleniumTestUtilities.getOSXChromeDriver()
     * https://sites.google.com/a/chromium.org/chromedriver/
     * https://sites.google.com/a/chromium.org/chromedriver/capabilities
     *
     * @return
     */
    public static WebDriver getOSXChromeDriver() {
        String CHROME = PATH_MAC + "chromedriver";
        return getChromeDriver(CHROME);
    }

    public static WebDriver getWINFirefoxDriver() {
        String GECKO = PATH_WIN + "geckodriver.exe";
        return getFirefoxDriver(GECKO);
    }

    public static WebDriver getWINChromeDriver() {
        String CHROME = PATH_WIN + "chromedriver.exe";
        return getChromeDriver(CHROME);
    }

    public static WebDriver getFirefoxDriver(final String pathToExecutable) {
        System.out.println("pathToExecutable: " + pathToExecutable);
        assertThat("pathToExecutable exists", new File(pathToExecutable).exists(), is(true));

        System.setProperty("webdriver.gecko.driver", pathToExecutable);
        System.setProperty("webdriver.firefox.driver", pathToExecutable);

        FirefoxOptions options = new FirefoxOptions();
//        options.addPreference("browser.startup.page", 1);
//        options.addPreference("browser.startup.homepage", "http://localhost:8080");

        WebDriver driver = new FirefoxDriver(options);

        return driver;
    }

    public static WebDriver getChromeDriver(final String pathToExecutable) {
        System.out.println("pathToExecutable: " + pathToExecutable);
        assertThat("pathToExecutable exists", new File(pathToExecutable).exists(), is(true));

        System.setProperty("webdriver.chrome.driver", pathToExecutable);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("no-sandbox");

        WebDriver driver = new ChromeDriver(options);

//        driver = new RemoteWebDriver(service.getUrl(),
//                DesiredCapabilities.chrome());

        return driver;
    }

    public static WebDriver getHtmlUnitDriver() {

//        final DesiredCapabilities capabilities = DesiredCapabilities.htmlUnit();
//        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
//                UnexpectedAlertBehaviour.ACCEPT);
//        capabilities.setJavascriptEnabled(true);

//        HtmlUnitDriver driver = new HtmlUnitDriver(capabilities);
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);

        return driver;
    }


    public static boolean closeDriver(final WebDriver driver) {
        if (driver != null) {
            driver.close();
        }
        return true;
    }


    /**
     * SeleniumTestUtilities.takeScreenshot(driver);
     *
     * @param driver
     * @throws Exception
     */
    public static void takeScreenshot(final WebDriver driver) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd__hh_mm_ss");

        LocalDateTime now = LocalDateTime.now();
        String dateString = now.format(formatter);

        System.out.println("Date converted to String: " + dateString);
        String fileName = dateString + "__" + random.nextInt();
        takeScreenshot(driver, fileName);
    }

    /**
     * SeleniumTestUtilities.takeScreenshot(driver, "home");
     *
     * @param driver
     * @throws Exception
     */
    public static void takeScreenshot(final WebDriver driver, String filename)
            throws Exception {

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(sourceFile, new File(DIR + filename + EXT));
    }
    
    

    public static boolean isElementPresent(final WebDriver driver, final By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isAlertPresent(final WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    
    public static boolean acceptNextAlert = true;

    public static String closeAlertAndGetItsText(final WebDriver driver) {
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
    

} // The End...
