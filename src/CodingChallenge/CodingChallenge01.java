package CodingChallenge;
/**
 * @author miloonken
 *
 */
import java.sql.Timestamp;
import org.junit.Rule;
import org.junit.Test;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;
import PageObjects.CodingChallengeHomePage;

public class CodingChallenge01 extends WebDriverBrowserFactory {

    private static StringBuffer verificationErrors = new StringBuffer();

    static java.util.Date date = new java.util.Date();
    static Timestamp t = new Timestamp(date.getTime());
    static String dateNow = t.toString().replace(":", "_");
    String obj = "Screenshots";
    String className = this.getClass().getSimpleName();

    @Rule
    public ScreenShotOnFailure screenShotRule;

    @Test
    public void GetPageTitle() throws Exception {

        driver.get(CodingChallengeHomePage.YelpHomePageURl(driver));

    }

    public static void verification() {

        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {

        }


    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


}