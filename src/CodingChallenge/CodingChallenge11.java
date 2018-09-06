package CodingChallenge;
import static org.junit.Assert.*;

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

import PageObjects.FirstYelpResult;
import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxSubmit;
import utiity.ScreenShotOnFailure;
import utiity.WebDriverBrowserFactory;

public class CodingChallenge11 extends WebDriverBrowserFactory {

	 private static StringBuffer verificationErrors = new StringBuffer();

	    static java.util.Date date = new java.util.Date();
	    static Timestamp t = new Timestamp(date.getTime());
	    static String dateNow = t.toString().replace(":", "_");
	    String obj = "Screenshots";
	    String className = this.getClass().getSimpleName();

	    @Rule
	    public ScreenShotOnFailure screenShotRule;

	    @Test
	    public void GetRestruantDetails() throws Exception {

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
	        
	        //Expand The First Result 
	        FirstYelpResult.ExpandFirstResult(driver).click();
	        
	        //Verify Title Displays
	        assertTrue(isElementPresent(By.cssSelector("div.u-space-t1 > h1")));
	      
	        //List First Yelp Result Details
	        List < WebElement > links = driver.findElements(By.cssSelector(".mapbox-text > ul > li"));
	    	
	        Iterator < WebElement > iter = links.iterator();
	        for(int i = 0; i < links.size(); i += 2) {

	        while (iter.hasNext()) {
	            WebElement Details = iter.next();
	            System.out.println(Details.getText());
	            if ("links".equals(Details.getText())); {	 
		        
	        }

	            //List First Three Restruant Reviews
		        List < WebElement > Reviews = driver.findElements(By.xpath("//*[@class='snippet']"));
		    	
		        Iterator < WebElement > iter1 = Reviews.iterator();
		 
		        while (iter1.hasNext()) {
		            WebElement RestaurantReviews = iter1.next();
		            System.out.println(RestaurantReviews.getText());
		            if ("Reviews".equals(RestaurantReviews.getText())); {	 
			        
		        }
		            
	    }
	    }
	        }  
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