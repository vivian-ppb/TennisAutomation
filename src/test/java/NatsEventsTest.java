import com.tennis.Driver;
import com.tennis.NatsHomePage;
import com.tennis.NatsLoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Intercept;
import utils.JsonPrettifier;

import static utils.Intercept.sendHttpRequest;

public class NatsEventsTest {

    @BeforeTest
    public static void setUp() {
        NatsLoginPage.natsLogin();
    }

    @Test
    public void testAtsEvents(){
        Driver.click(NatsHomePage.eventTree);
        String response = sendHttpRequest("POST", Intercept.interceptRequestUrl(null));
        Driver.clickByOffset(NatsHomePage.tennisEventTree, 0, -10);
        System.out.println(JsonPrettifier.prettifyJson(response));
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
