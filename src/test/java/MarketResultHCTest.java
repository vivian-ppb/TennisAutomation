import com.tennis.AmelcoHomePage;
import com.tennis.AmelcoLoginPage;
import com.tennis.Driver;
import com.tennis.SoupiHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.*;
import utils.soupi.SoupiMarketState;

import java.util.*;

import static utils.Intercept.sendHttpRequest;

public class MarketResultHCTest {

    SoupiMarketState soupiMarketState;

    @BeforeTest
    public static void setUp() {
        //AmelcoLoginPage.amelcoLogin();
    }

    @Test
    public void marketResultHCTest() {
        /*Driver.fluentWaitForElement(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.eventSearchTab);
        Driver.click(AmelcoHomePage.hoursCheckbox);
        String response = sendHttpRequest("GET", Intercept.interceptRequestUrl(AmelcoHomePage.searchButton));
        List<String> amelcoIds = Extract.getSoupiKey(response, "id");
        List<String> names = new ArrayList<>();
        List<Integer> setScore = new ArrayList<>();
        for (String amelcoId : amelcoIds) {*/
        List<String> names = new ArrayList<>();
        List<Integer> setScore = new ArrayList<>();
        //not started 11907807
        //started 11904108
        String amelcoId = "11904108";
        SoupiHomePage.upiSearch(amelcoId);
        String competitors = Extract.getSoupiEventName();
        int maxSets = Extract.getSoupiHighestSetNumber();
        if (!competitors.isEmpty() || !competitors.isBlank() || !competitors.equals(SoupiHomePage.resultError) && maxSets >= 1) {
            names = Extract.getSoupiPlayerNames(competitors);
            soupiMarketState = new SoupiMarketState();
            soupiMarketState.setAmelcoEventId(amelcoId);
            Set<String> set = new HashSet<>(names);
            List<String> uniqueCompetitionNames = new ArrayList<>(set);

            TennisMatchObject tennisMatch = new TennisMatchObject.Builder()
                    .amelcoEventId(amelcoId)
                    .offeredInRunning(Extract.getSoupiOfferedInRunning())
                    .booked(Extract.getSoupiBookingStatus())
                    .bettingStatus(Extract.getSoupiBettingStatus())
                    .resulted(Extract.getSoupiResulted())
                    .display(Extract.getSoupiDisplay())
                    .highestSetNumber(Extract.getSoupiHighestSetNumber())
                    .setScores(Extract.getSoupiSetScore(maxSets))
                    .score(Extract.getAllSetScoresFormatted(Extract.getSoupiSetScore(maxSets), maxSets))
                    //.markets(Extract.getSoupiMarkets())
                    .build();

            System.out.println(MatchValidations.determineWinner(tennisMatch.getScore()));
        }

    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
