import com.tennis.BmtHomePage;
import com.tennis.BmtLoginPage;
import com.tennis.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BmtLoginTest {

    @BeforeTest
    static void setUp() {
        BmtLoginPage.bmtLogin();
    }

    @Test
    public void test() {
        Driver.assertIsDisplayed(BmtHomePage.mapButton, "Home page failed to load");
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
