package com.tennis;

import org.openqa.selenium.By;
import utils.PropertiesReader;

public class NatsLoginPage {

    public static By natsUsername = By.xpath("//*[@id='userName']");
    public static By natsPassword = By.xpath("//*[@id='password']");
    public static By natsLoginButton = By.xpath("//*[@type='submit']");

    public static void natsLogin() {
        Driver.getDriver().get(PropertiesReader.getProperty("environment.properties", "natsUrl"));
        Driver.fluentWaitForElement(natsLoginButton);
        Driver.typeText(natsUsername, PropertiesReader.getProperty("environment.properties", "username"));
        Driver.typeText(natsPassword, PropertiesReader.getProperty("environment.properties", "password"));
        Driver.click(natsLoginButton);
    }
}
