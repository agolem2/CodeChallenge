package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YelpSearchBox {

    public static WebElement element = null;

    public static WebElement SearchBox(WebDriver driver)

    {
        element = driver.findElement(By.xpath(".//*[@id='find_desc']"));

        return element;

    }
}