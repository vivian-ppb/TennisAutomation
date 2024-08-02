import com.tennis.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Extract;
import utils.Intercept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Intercept.sendHttpRequest;

public class Amelco3HoursEventsMapper {
    @BeforeTest
    public static void setUp() {
        AmelcoLoginPage.amelcoLogin();
    }

    @Test
    public void testAmelco3HoursEventsMapper() {
        Driver.fluentWaitForElement(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.hoursCheckbox);
        String amelcoEvents = sendHttpRequest("GET", Intercept.interceptRequestUrl(AmelcoHomePage.searchButton));
        List<String> amelcoIds = Extract.extractKey(amelcoEvents, "id");
        List<String> competitionNames = new ArrayList<>();
        for (String amelcoId : amelcoIds) {
            SoupiHomePage.upiSearch(amelcoId);
            String cn = SoupiHomePage.getSoupiValue("competitionName");
            if (!cn.isEmpty() || !cn.isBlank()) {
                competitionNames.add(cn);
            }
        }
        Set<String> set = new HashSet<>(competitionNames);
        List<String> uniqueCompetitionNames = new ArrayList<>(set);
        System.out.println("Competition Names: " +uniqueCompetitionNames);
        BmtLoginPage.bmtLogin();
        Driver.click(BmtHomePage.amelco);
        Driver.click(BmtHomePage.tennis);
        BmtHomePage.mapMatches(uniqueCompetitionNames);
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
