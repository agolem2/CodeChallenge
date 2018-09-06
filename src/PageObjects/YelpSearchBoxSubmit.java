package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YelpSearchBoxSubmit {

	public static WebElement element = null;
    
    public static WebElement SubmitSearch (WebDriver driver)
   
    {element = driver.findElement(By.xpath("//*[@id='header-search-submit']/span/span[1]"));
    
    return element;

    }
}
