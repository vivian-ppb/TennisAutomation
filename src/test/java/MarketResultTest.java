import com.tennis.AmelcoHomePage;
import com.tennis.AmelcoLoginPage;
import com.tennis.Driver;
import com.tennis.SoupiHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Extract;
import utils.Intercept;
import utils.TennisMatchObject;
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
    public void marketResultTest() {
        Driver.fluentWaitForElement(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.hoursCheckbox);
        String response = sendHttpRequest("GET", Intercept.interceptRequestUrl(AmelcoHomePage.searchButton));
        List<String> amelcoIds = Extract.getSoupiKey(response, "id");
        List<String> names = new ArrayList<>();
        List<Integer> setScore = new ArrayList<>();
        for (String amelcoId : amelcoIds) {
            SoupiHomePage.upiSearch(amelcoId);
            String competitors = Extract.getSoupiEventName();
            int maxSets = Extract.getSoupiHighestSetNumber();
            if (!competitors.isEmpty() || !competitors.isBlank() || !competitors.equals(SoupiHomePage.resultError) && maxSets >= 1) {
                names = Extract.getSoupiPlayerNames(competitors);
                soupiMarketState = new SoupiMarketState();
                soupiMarketState.setAmelcoEventId(amelcoId);
                Extract.getAllSetScoresFormatted(Extract.getSoupiSetScore(maxSets), maxSets);
                Set<String> set = new HashSet<>(names);
                List<String> uniqueCompetitionNames = new ArrayList<>(set);
                TennisMatchObject tennisMatch = new TennisMatchObject.Builder()
                        .amelcoEventId(amelcoId)
                        .offeredInRunning(Extract.getSoupiOfferedInRunning())
                        .booked(Extract.getSoupiBookingStatus())
                        .bettingStatus(Extract.getSoupiBettingStatus())
                        .resulted(Extract.getSoupiResulted())
                        .display(Extract.getSoupiDisplay())
                        .score(Extract.getAllSetScoresFormatted(Extract.getSoupiSetScore(maxSets), maxSets))
                        .build();
                System.out.println("amelcoID = " + tennisMatch.getAmelcoEventId());
                System.out.println("offeredInRunning = " + tennisMatch.getOfferedInRunning());
                System.out.println("booked = " + tennisMatch.getBooked());
                System.out.println("bettingStatus = " + tennisMatch.getBettingStatus());
                System.out.println("resulted = " + tennisMatch.getResulted());
                System.out.println("display = " + tennisMatch.getDisplay());
                System.out.println("score = " + tennisMatch.getScore());
            }
        }

    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
