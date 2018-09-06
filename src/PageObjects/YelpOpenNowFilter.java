package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Select and Click on the Restaurants Link From The HomePage

public class YelpOpenNowFilter {

	public static WebElement element = null;
     
    public static WebElement OpenNowFilter (WebDriver driver)
   
    {element = driver.findElement(By.xpath(".//div/ul/li[3]/label/span"));
    
    return element;

    }
}
