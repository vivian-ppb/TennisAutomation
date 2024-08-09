package com.tennis;

import org.openqa.selenium.By;
import utils.Extract;
import utils.PropertiesReader;

public class SoupiHomePage {

    public static By upiSearchBox = By.xpath("//*[@id='upiSearchValue']");
    public static By eventStateButton = By.xpath("//*[@id='upiEventStateButton']");
    public static By upiResult = By.xpath("//pre");
    public static String resultError = "The requested resource could not be found but may be available again in the future.";

    public static void upiSearch(String id) {
        Driver.getDriver().get(PropertiesReader.getProperty("environment.properties", "upiIdUrl") + id);
    }

    public static void navigateToUpi() {
        Driver.getDriver().get(PropertiesReader.getProperty("environment.properties", "upiUrl"));
        Driver.fluentWaitForElement(upiSearchBox);
    }

    public static String getSoupiValue(String key) {
        String fullContent = Driver.getText(upiResult);
        String cn = Extract.getSoupiKey(fullContent, key).toString().replace("[", "").replace("]", "").replace(" , ", "").trim();
        if (fullContent.contains(resultError)) {
            Driver.getDriver().navigate().refresh();
        }
        return cn;
    }
}
