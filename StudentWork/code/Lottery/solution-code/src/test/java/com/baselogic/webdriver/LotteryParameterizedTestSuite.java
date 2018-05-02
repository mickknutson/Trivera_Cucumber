package com.baselogic.webdriver;

import com.baselogic.cuke.TestRunner;
import com.baselogic.selenium.SeleniumTestUtilities;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import org.junit.runners.Parameterized.Parameter;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import org.openqa.selenium.WebDriver;

@RunWith(ParameterizedSuite.class)
@Suite.SuiteClasses({ TestRunner.class })
public class LotteryParameterizedTestSuite {

    /**
     * Set the list of browsers to test against.
     * @return
     */
    @Parameterized.Parameters(name = "Browser testing against {0}")
    public static Object[] params() {
        return new Object[][] {
                  {SeleniumTestUtilities.getHtmlUnitDriver()}
                , {SeleniumTestUtilities.getOSXChromeDriver()}
                , {SeleniumTestUtilities.getOSXFirefoxDriver()}
        };
    }

    /**
     * Always provide a target for the defined parameters -
     * even if you only want to access them in the suite's child classes.
     */
    @Parameter(0)
    public WebDriver driver;

} // The End...
