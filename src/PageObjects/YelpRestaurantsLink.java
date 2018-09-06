package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Select and Click on the Restaurants Link From The HomePage

public class YelpRestaurantsLink {

	public static WebElement element = null;
     
    public static WebElement PolicyNumber (WebDriver driver)
   
    {element = driver.findElement(By.linkText("Restaurants"));
    
    return element;

    }

	public static WebElement RestaurantsLink(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
}
