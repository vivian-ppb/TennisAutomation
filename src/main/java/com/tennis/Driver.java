package com.tennis;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
        }
        return driver;
    }

    /**
     * Clicks on a given element
     * @param element A By type object defining the locator
     */
    public static void click(By element) {
        getDriver().findElement(element).click();
    }

    /**
     * Types a string to a given element locator
     * @param element
     * @param text
     */
    public static void typeText(By element, String text) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(text);
    }

    /**
     * Asserts an element is displayed
     * @param element The element to be displayed
     * @param errorMessage The error message if the assertion fails
     */
    public static void assertIsDisplayed(By element, String errorMessage) {
        Assert.isTrue(getDriver().findElement(element).isDisplayed(), errorMessage);
    }

    /**
     * Asserts an element is not displayed
     * @param element The element not to be displayed
     * @param errorMessage The error message if the assertion fails
     */
    public static void assertIsNotDisplayed(By element, String errorMessage) {
        Assert.isTrue(!getDriver().findElement(element).isDisplayed(), errorMessage);
    }

    /**
     * Selects an option/value from a dropdown form by visible text
     * @param dropdownElement The dropdown element
     * @param optionText The visible text value of the option
     */
    public static void select(By dropdownElement, String optionText) {
        click(dropdownElement);
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByVisibleText(optionText);
    }

    /**
     * Waits for an element to be present on page while checking every second for 30 seconds
     * @param element The element to wait for
     */
    public static WebElement fluentWaitForElement(By element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    /**
     * Clicks to the right of an element by an offset in pixels
     * @param element The element from which we measure the offset from
     * @param offsetPixels The pixel offset count
     */
    public static void clickToRightByOffset(By element, int offsetPixels) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDriver().findElement(element));
        actions.moveByOffset(offsetPixels, 20);
        actions.click().build().perform();
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
