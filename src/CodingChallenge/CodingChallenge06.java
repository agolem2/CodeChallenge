package CodingChallenge;
import static org.junit.Assert.assertEquals;

/**
 * @author miloonken
 *
 */
import java.sql.Timestamp;

import org.junit.Rule;
import org.junit.Test;

import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxSubmit;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;

public class CodingChallenge06 extends WebDriverBrowserFactory {

	 private static StringBuffer verificationErrors = new StringBuffer();

	    static java.util.Date date = new java.util.Date();
	    static Timestamp t = new Timestamp(date.getTime());
	    static String dateNow = t.toString().replace(":", "_");
	    String obj = "Screenshots";
	    String className = this.getClass().getSimpleName();

	    public static String Neighborhoods = "Neighborhoods";
	    public static String Distance = "Distance";
	    public static String Price = "Price";
	    public static String Features = "Features";

	    public static CharSequence[] SearchArguments (String sNeighborhoods, String sDistance, String sPrice, String sFeatures){
			return SearchArguments(null, null, null, null);
		
	    }
	    
	    @Rule
	    public ScreenShotOnFailure screenShotRule;

	    @Test
	    public void FilterRestaurantsParameterize() throws Exception {

	    	//Get the Yelp URL Home Page
	        driver.get(YelpHomePage.YelpHomePageURl(driver));
	        Thread.sleep(1000);
	        
	        //Verify Restaurants Link Is Displayed and Spelled Correctly
	        assertEquals("Restaurants",YelpRestaurantsLink.RestaurantsLink(driver).getText());
	       
	        //Select Restruants In Drop Down box in Find
	        
	        YelpSearchBox.SearchBox(driver).click();
			//YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(SearchArguments(null, null, null, null));
	        
	        
	        YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(Neighborhoods);
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(5000);
	        
	        YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(Distance);
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(5000);

	        YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(Price);
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(5000);

	        YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(Features);
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(5000);

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
