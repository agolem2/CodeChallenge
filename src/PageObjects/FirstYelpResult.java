package PageObjects;
/**
 * @author miloonken
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstYelpResult {

    public static WebElement element = null;

    public static WebElement ExpandFirstResult(WebDriver driver)

    {
        element = driver.findElement(By.cssSelector(".biz-name.js-analytics-click>span"));

        return element;

    }
}