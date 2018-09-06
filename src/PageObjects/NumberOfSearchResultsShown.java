package PageObjects;
/**
 * @author miloonken
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NumberOfSearchResultsShown {

    public static String ShowingResults = null;
    public static String ShowingTotalRestaurantResults(WebDriver driver) {

        String ShowingTotalRestaurantResults = driver.findElement(By.xpath("//*[@id='wrap']/div[2]/div[1]/div/div[2]/div/div[1]/div/span")).getText();
        return ShowingTotalRestaurantResults;
    }

}