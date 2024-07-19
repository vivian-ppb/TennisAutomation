package com.tennis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Sleeper;

import java.util.List;

public class BmtHomePage {

    public static By mapButton = By.xpath("//*[@class='unmapped-competitions__map-action btn btn-primary btn-sm']");
    public static By searchBox = By.xpath("//*[@class='competitions-search-filter']");
    public static By confirmButton = By.xpath("//*[text()='Confirm']");
    public static By confirmationToast = By.xpath("//*[text()='Competitions mapped successfully']");
    public static By unmappedCompetitionsTab = By.xpath("//*[text()='Unmapped Competitions']");
    public static By amelco = By.xpath("//*[text()='AMELCO']");
    public static By tennis = By.xpath("//*[text()='Tennis']");
    public static String unmappedCompetitionContainer = "//*[@class='ttui-tree__wrapper']";
    public static String rampResultContainer = "//*[@class='unmapped-competitions__ramp-list-container']";
    public static String itfKofu = "|ITF Kofu|";

    /**
     * Maps ramp matches
     *
     * @param textList the list of competition names to find and match
     */
    public static void mapMatches(List<String> textList) {
        for (String text : textList) {
            try {
                Sleeper.sleep(2000);
                List<WebElement> elements = Driver.getDriver().findElements(By.xpath(unmappedCompetitionContainer + "//*[contains(text(), '" + text + "')]"));
                for (WebElement element : elements) {
                    String actualName = element.getText().trim();
                    String dif = "";
                    if (actualName.contains("|Doubles|")) {
                        dif = " |Doubles|";
                    } else if (actualName.contains("|Qualifiers|")) {
                        dif = " |Qualifiers|";
                    }
                    By unmappedCompetition = By.xpath(unmappedCompetitionContainer + "//*[text()='" + text + "']");
                    if (Driver.isElementPresent(unmappedCompetition)) {
                        Driver.clickIfDisplayed(unmappedCompetition);
                        Driver.typeText(searchBox, itfKofu + dif);
                        Driver.clickIfDisplayed(By.xpath(rampResultContainer + "//*[text()='" + itfKofu + dif + "']"));
                        Driver.click(mapButton);
                        Driver.click(confirmButton);
                        Driver.fluentWaitForElement(confirmationToast);
                        Driver.click(amelco);
                        Driver.click(tennis);
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred while clicking elements containing text: " + text + " " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
