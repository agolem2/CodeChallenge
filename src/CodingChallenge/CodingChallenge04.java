package CodingChallenge;
import static org.junit.Assert.assertEquals;

/**
 * @author miloonken
 *
 */
import java.sql.Timestamp;

import org.junit.Rule;
import org.junit.Test;

import PageObjects.NumberOfSearchResultsShown;
import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantTitlePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxSubmit;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;

public class CodingChallenge04 extends WebDriverBrowserFactory {

	
	 private static StringBuffer verificationErrors = new StringBuffer();

	    static java.util.Date date = new java.util.Date();
	    static Timestamp t = new Timestamp(date.getTime());
	    static String dateNow = t.toString().replace(":", "_");
	    String obj = "Screenshots";
	    String className = this.getClass().getSimpleName();

	    @Rule
	    public ScreenShotOnFailure screenShotRule;

	    @Test
	    public void SearchRestaurantsListResults() throws Exception {

	    	//Get the Yelp URL Home Page
	        driver.get(YelpHomePage.YelpHomePageURl(driver));
	        Thread.sleep(1000);
	        
	        //Verify Restaurants Link Is Displayed and Spelled Correctly
	        assertEquals("Restaurants",YelpRestaurantsLink.RestaurantsLink(driver).getText());
	       
	        //Select Restruants In Drop Down box in Find
	        
	        YelpSearchBox.SearchBox(driver).click();
	        YelpSearchBoxInput.SearchBoxInput(driver).sendKeys("Restaurants");
	        
	        //Search Restruants

	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        
	        String RestruantsSearchResults = NumberOfSearchResultsShown.ShowingTotalRestaurantResults(driver);
	        
	        //Verify Search Restruants Pizza Returned

	        assertEquals("Best Restaurants in Berkeley, CA", YelpRestaurantTitlePage.RestaurantTitlePage(driver));
	        Thread.sleep(2000);
	        
	        //Append Pizza To Search Restruants And Verify Results

	        YelpSearchBox.SearchBox(driver).click();
	        YelpSearchBox.SearchBox(driver).clear();
	        YelpSearchBox.SearchBox(driver).sendKeys("Restaurants - Pizza");
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(3000);
	        
	        String RestruantsPizzaSearchResults = NumberOfSearchResultsShown.ShowingTotalRestaurantResults(driver);

	        assertEquals("Best Restaurants - Pizza in Berkeley, CA", YelpRestaurantTitlePage.RestaurantTitlePage(driver));

	        System.out.println(RestruantsSearchResults);
	        System.out.println(RestruantsPizzaSearchResults);

	        
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