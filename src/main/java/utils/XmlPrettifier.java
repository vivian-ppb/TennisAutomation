package utils;

import com.tennis.Driver;
import org.openqa.selenium.JavascriptExecutor;


public class XmlPrettifier {

    public static String prettifyXml(String url) {
        Driver.getDriver().get(url);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        return (String) jsExecutor.executeScript("return document.documentElement.outerHTML;");

    }
}