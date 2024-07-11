package com.tennis;

import org.openqa.selenium.By;
import utils.PropertiesReader;

public class AmelcoLoginPage {

    public static By amelcoUsername = By.xpath("//*[@label='Username']");
    public static By amelcoPassword = By.xpath("//*[@label='Password']");
    public static By amelcoLoginButton = By.xpath("//*[text()='Submit']");

    public static void amelcoLogin() {
        Driver.getDriver().get(PropertiesReader.getProperty("environment.properties", "amelcoUrl"));
        Driver.typeText(AmelcoLoginPage.amelcoUsername, PropertiesReader.getProperty("environment.properties", "username"));
        Driver.typeText(AmelcoLoginPage.amelcoPassword, PropertiesReader.getProperty("environment.properties", "password"));
        Driver.click(AmelcoLoginPage.amelcoLoginButton);
    }
}
