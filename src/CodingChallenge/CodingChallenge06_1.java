package CodingChallenge;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runners.Parameterized;
import PageObjects.YelpHomePage;
import PageObjects.YelpRestaurantsLink;
import PageObjects.YelpSearchBox;
import PageObjects.YelpSearchBoxInput;
import PageObjects.YelpSearchBoxSubmit;
import utiity.WebDriverBrowserFactory;




public class CodingChallenge06_1 extends WebDriverBrowserFactory {

		public static String Neighborhoods = "Neighborhoods";
	    public static String Distance = "Distance";
	    public static String Price = "Price";
	    public static String Features = "Features";
	    
	    @Parameterized.Parameters
		public static LinkedList<String[]> getEnvironments() throws Exception {
			LinkedList<String[]> Search = new LinkedList<String[]>();
			Search.add(new String[]{Neighborhoods.toString(), "Neighborhoods", "Neighborhoods"});
			Search.add(new String[]{Distance.toString(),"Distance","Distance"});
			Search.add(new String[]{Price.toString(),"Price","Price"});

			//add more browsers here

			return Search;
		}

		@SuppressWarnings("unused")
		private Object search;
	    
		public void JUnitParallel(String platform, String browserName, String browserVersion, Object search) {
			this.search = search;
			
}
		@Test
	    public void ParameterSearchOption() throws Exception{
	    	
	    	//Get the Yelp URL Home Page
	        driver.get(YelpHomePage.YelpHomePageURl(driver));
	        Thread.sleep(1000);
	        
	        //Verify Restaurants Link Is Displayed and Spelled Correctly
	        assertEquals("Restaurants",YelpRestaurantsLink.RestaurantsLink(driver).getText());
	       
	        //Select Restruants In Drop Down box in Find
	        
	        YelpSearchBox.SearchBox(driver).click();
			YelpSearchBoxInput.SearchBoxInput(driver).sendKeys(Distance);
	        
	        //Search Restruants

	        YelpSearchBoxSubmit.SubmitSearch(driver).click();

	    }  
	}