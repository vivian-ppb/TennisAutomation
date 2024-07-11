import com.tennis.AmelcoHomePage;
import com.tennis.AmelcoLoginPage;
import com.tennis.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Intercept;
import utils.JsonPrettifier;

import static utils.Intercept.sendHttpRequest;

public class Amelco3HoursEventsTest {

    @BeforeTest
    public static void setUp() {
        AmelcoLoginPage.amelcoLogin();
    }

    @Test
    public void testAmelco3HoursEvents(){
        Driver.fluentWaitForElement(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.hoursCheckbox);
        String response = sendHttpRequest("GET", Intercept.interceptAndPrintResponseBody(AmelcoHomePage.searchButton));
        System.out.println(JsonPrettifier.prettifyJson(response));
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
