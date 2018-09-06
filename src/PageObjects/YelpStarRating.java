package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YelpStarRating {

	public static String StarRating = null;
	@SuppressWarnings("unused")
	public static List<WebElement> StarRating (WebDriver driver) {
		
		WebElement YelpStarRating = driver.findElement(By.cssSelector("div.media-story > div.biz-rating.biz-rating-large.clearfix > div"));
		return null;
	}

	
	
	// Star Rating div.media-story > div.biz-rating.biz-rating-large.clearfix > div
}
