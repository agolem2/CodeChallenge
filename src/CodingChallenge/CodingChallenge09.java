package CodingChallenge;
import static org.junit.Assert.assertEquals;

/**
 * @author miloonken
 *
 */
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxSubmit;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;

public class CodingChallenge09 extends WebDriverBrowserFactory {

	 private static StringBuffer verificationErrors = new StringBuffer();

	    static java.util.Date date = new java.util.Date();
	    static Timestamp t = new Timestamp(date.getTime());
	    static String dateNow = t.toString().replace(":", "_");
	    String obj = "Screenshots";
	    String className = this.getClass().getSimpleName();

	    @Rule
	    public ScreenShotOnFailure screenShotRule;

	    @Test
	    public void ReportStarRating() throws Exception {

	    	//Get the Yelp URL Home Page
	        driver.get(YelpHomePage.YelpHomePageURl(driver));
	        Thread.sleep(1000);
	        
	        //Verify Restaurants Link Is Displayed and Spelled Correctly
	        assertEquals("Restaurants",YelpRestaurantsLink.RestaurantsLink(driver).getText());
	       
	        //Select Restruants In Drop Down box in Find
	        
	        YelpSearchBox.SearchBox(driver).click();
			YelpSearchBoxInput.SearchBoxInput(driver).sendKeys("Distance");
	        Thread.sleep(1000);
	        
	        //Search Restruants
	        YelpSearchBoxSubmit.SubmitSearch(driver).click();
	        Thread.sleep(3000);
	       
	        //Print The Review
			String YelpStarRating = driver.findElement(By.cssSelector(".i-stars.i-stars--regular-5.rating-large")).getText();
	    	System.out.println(YelpStarRating);

	    	//Cycle Through Star Ratings
	        List < WebElement > links = driver.findElements(By.cssSelector("#super-container > div > div.clearfix.layout-block.layout-a.scroll-map-container.search-results-block > div.column.column-alpha > div > div.search-results-content > ul:nth-child(2) > li:nth-child(2) > div > div.biz-listing-large > div.main-attributes > div > div.media-story > div.biz-rating.biz-rating-large.clearfix"));
	    	
	        Iterator < WebElement > iter = links.iterator();
	 
	        while (iter.hasNext()) {
	            WebElement StarRatings = iter.next();
	            System.out.println(StarRatings.getText());
	            if ("links".equals(StarRatings.getText())) {	 
		        
	        }

	    }
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
