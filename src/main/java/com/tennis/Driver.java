package com.tennis;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    public static DevTools devTools;

    private Driver() {
    }

    public static WebDriver getDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        if (driver == null) {
            if (os.contains("win")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/windriver/chromedriver.exe");
            } else
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions().addArguments("ignore-certificate-errors");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
        }
        return driver;
    }

    /**
     * Clicks on a given element
     *
     * @param element A By type object defining the locator
     */
    public static void click(By element) {
        fluentWaitForElement(element);
        getDriver().findElement(element).click();
    }

    /**
     * Clicks on an element if it is displayed while ignoring NoSuchElementException & StaleElementReferenceException
     *
     * @param element the element to click
     */
    public static void clickIfDisplayed(By element) {
        try {
            WebElement webElement = getDriver().findElement(element);
            fluentWaitForElement(element);
            if (webElement.isDisplayed()) {
                webElement.click();
            }
            // Ignoring the exceptions
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Element not found or not in DOM: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Types a string to a given element locator
     *
     * @param element
     * @param text
     */
    public static void typeText(By element, String text) {
        fluentWaitForElement(element);
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(text);
    }

    /**
     * Asserts an element is displayed
     *
     * @param element      The element to be displayed
     * @param errorMessage The error message if the assertion fails
     */
    public static void assertIsDisplayed(By element, String errorMessage) {
        Assert.isTrue(getDriver().findElement(element).isDisplayed(), errorMessage);
    }

    /**
     * Asserts an element is not displayed
     *
     * @param element      The element not to be displayed
     * @param errorMessage The error message if the assertion fails
     */
    public static void assertIsNotDisplayed(By element, String errorMessage) {
        Assert.isTrue(!getDriver().findElement(element).isDisplayed(), errorMessage);
    }

    /**
     * Checks if an element is displayed
     * @param element the element to check for
     * @return true if displayed / false if not
     */
    public static boolean isElementPresent(By element) {
        return getDriver().findElement(element).isDisplayed();
    }

    /**
     * Selects an option/value from a dropdown form by visible text
     *
     * @param dropdownElement The dropdown element
     * @param optionText      The visible text value of the option
     */
    public static void select(By dropdownElement, String optionText) {
        click(dropdownElement);
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByVisibleText(optionText);
    }

    /**
     * Waits for an element to be present on page while checking every second for 30 seconds
     *
     * @param element The element to wait for
     */
    public static void fluentWaitForElement(By element) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    /**
     * Checks if the page has finished loading
     *
     * @return boolean
     */
    public static boolean isPageLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        return js.executeScript("return document.readyState").toString().equals("complete");
    }

    /**
     * Clicks on an element by an offset in pixels
     *
     * @param element The element from which we measure the offset from
     * @param xOffset The vertical pixel offset count
     * @param xOffset The horizontal pixel offset count
     */
    public static void clickByOffset(By element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDriver().findElement(element));
        actions.moveByOffset(xOffset, yOffset);
        actions.click().build().perform();
    }

    /**
     * Gets the text from a web element
     *
     * @param element the element to get the text from
     * @return the text obtained from the element
     */
    public static String getText(By element) {
        return Driver.getDriver().findElement(element).getText();
    }

    /**
     * Quits the current session of webDriver and closes the browser
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
