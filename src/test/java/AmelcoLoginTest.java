import com.tennis.AmelcoHomePage;
import com.tennis.AmelcoLoginPage;
import com.tennis.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmelcoLoginTest {

    @BeforeTest
    static void setUp() {
        AmelcoLoginPage.amelcoLogin();
    }

    @Test
    public void test() {
        Driver.assertIsDisplayed(AmelcoHomePage.logoutButton, "Home page failed to load");
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
