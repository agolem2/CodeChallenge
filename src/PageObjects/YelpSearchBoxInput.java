package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YelpSearchBoxInput {

    public static WebElement element = null;

    public static WebElement SearchBoxInput(WebDriver driver)

    {
        element = driver.findElement(By.xpath("//*[@id='header_find_form']/div/div[1]/div/label/div/span/input[2]"));

        return element;

    }
}