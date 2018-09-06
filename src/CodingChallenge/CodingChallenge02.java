package CodingChallenge;
import static org.junit.Assert.*;

/**
 * @author miloonken
 *
 */
import java.sql.Timestamp;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxRestaurants;
import PageObjects.YelpSearchBoxSubmit;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;

public class CodingChallenge02 extends WebDriverBrowserFactory {

    private static StringBuffer verificationErrors = new StringBuffer();

    static java.util.Date date = new java.util.Date();
    static Timestamp t = new Timestamp(date.getTime());
    static String dateNow = t.toString().replace(":", "_");
    String obj = "Screenshots";
    String className = this.getClass().getSimpleName();

    @Rule
    public ScreenShotOnFailure screenShotRule;

    @Test
    public void SelectRestaurantsLinkVerify() throws Exception {

        //Get the Yelp URL Home Page
        driver.get(YelpHomePage.YelpHomePageURl(driver));
        Thread.sleep(1000);

        //Verify Restaurants Link Is Displayed and Spelled Correctly
        assertEquals("Restaurants", YelpRestaurantsLink.RestaurantsLink(driver).getText());

        //Select Restruants In Drop Down box in Find
        YelpSearchBox.SearchBox(driver).click();
        YelpSearchBoxInput.SearchBoxInput(driver).click();
        YelpSearchBoxRestaurants.SearchBoxRestaurantOption(driver).click();
        YelpSearchBoxSubmit.SubmitSearch(driver).click();
        assertTrue(isElementPresent(By.cssSelector("h1")));

        Thread.sleep(2000);
    }


    private void assertTrue(Object elementPresent) {
		// TODO Auto-generated method stub
		
	}


	private Object isElementPresent(By cssSelector) {
		// TODO Auto-generated method stub
		return null;
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