package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YelpRestaurantTitlePage {

	public static String RestaurantTitlePage (WebDriver driver) {
		
		String YelpRestaurantTitlePage = driver.findElement(By.cssSelector(".search-header-title-container>h1")).getText();
		return YelpRestaurantTitlePage;
	}
	
	//("The Best 10 Restaurants in Berkeley, CA - Last Updated October 2017 - Yelp", driver.getTitle());

}
