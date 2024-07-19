package com.tennis;

import org.openqa.selenium.By;
import utils.PropertiesReader;

public class BmtLoginPage {

    public static By bmtUsername = By.xpath("//*[@id='username']");
    public static By bmtPassword = By.xpath("//*[@id='password']");
    public static By bmtLoginButton = By.xpath("//*[@class='teste']");

    public static void bmtLogin() {
        Driver.getDriver().get(PropertiesReader.getProperty("environment.properties", "bmtUrl"));
        Driver.fluentWaitForElement(bmtLoginButton);
        Driver.typeText(bmtUsername, PropertiesReader.getProperty("environment.properties", "bmtUsername"));
        Driver.typeText(bmtPassword, PropertiesReader.getProperty("environment.properties", "bmtPassword"));
        Driver.click(bmtLoginButton);
        Driver.fluentWaitForElement(BmtHomePage.mapButton);
    }
}
