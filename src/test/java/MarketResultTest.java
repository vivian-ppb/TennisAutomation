import com.tennis.AmelcoHomePage;
import com.tennis.AmelcoLoginPage;
import com.tennis.Driver;
import com.tennis.SoupiHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Extract;
import utils.Intercept;
import utils.soupi.SoupiMarketState;

import java.util.*;

import static utils.Intercept.sendHttpRequest;

public class MarketResultTest {

    SoupiMarketState soupiMarketState;

    @BeforeTest
    public static void setUp() {
        AmelcoLoginPage.amelcoLogin();
    }

    @Test
    public void marketResultTest(){
        Driver.fluentWaitForElement(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.hoursCheckbox);
        String response = sendHttpRequest("GET", Intercept.interceptRequestUrl(AmelcoHomePage.searchButton));
        List<String> amelcoIds = Extract.extractKey(response, "id");
        List<String> names = new ArrayList<>();
        List<Integer> setScore = new ArrayList<>();
        for (String amelcoId : amelcoIds) {
            SoupiHomePage.upiSearch(amelcoId);
            String competitors = Extract.getEventName();
            int maxSets = Extract.getHighestSetNumber();
            System.out.println("highest set =  " + maxSets);
            if (!competitors.isEmpty() || !competitors.isBlank() || !competitors.equals(SoupiHomePage.resultError) && maxSets >=1) {
                names = Extract.extractPlayerNames(competitors);
                soupiMarketState = new SoupiMarketState();
                soupiMarketState.setAmelcoEventId(amelcoId);
                setScore = Extract.getSetScore(1);
/*                for (int i = 0; i < maxSets; i++) {
                    setScore = Extract.getSetScore(i);

                }*/
                String somescore = setScore.toString();
                System.out.println("setScoreList: " + setScore);
            }
        }
        Set<String> set = new HashSet<>(names);
        List<String> uniqueCompetitionNames = new ArrayList<>(set);
        System.out.println("names: " +uniqueCompetitionNames);    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
