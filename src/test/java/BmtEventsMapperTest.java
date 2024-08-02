import com.tennis.BmtHomePage;
import com.tennis.BmtLoginPage;
import com.tennis.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BmtEventsMapperTest {
    @BeforeTest
    static void setUp() {
        BmtLoginPage.bmtLogin();
    }

    @Test
    public void test() {
        Driver.click(BmtHomePage.amelco);
        Driver.click(BmtHomePage.tennis);
    }

    @AfterTest
    public static void tearDown() {
        Driver.quitDriver();
    }
}
