package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YelpSearchBoxRestaurants {

    public static WebElement element = null;

    public static WebElement SearchBoxRestaurantOption(WebDriver driver)

    {
        element = driver.findElement(By.cssSelector(".suggestion-detail.suggestion-title.suggestion-name"));

        return element;

    }
}