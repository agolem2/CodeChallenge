package YouTube;

import org.openqa.selenium.By;


/*This is a simple JUnit test script to search youtube with the a new 
 * webdriver, verify results.. Select the first search result by playing the video 
 * and then pausing the video.. Finally verify the PLAY button is available*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

public class playAndPauseYouTubeVideo {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.youtube.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void playAndPauseYouTubeVideoTest() throws Exception {
        driver.get(baseUrl + "/");
        assertEquals("YouTube", driver.getTitle());
        driver.findElement(By.name("search_query")).clear();
        driver.findElement(By.name("search_query")).sendKeys("selenium");
        driver.findElement(By.id("search-icon-legacy")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='img']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        
        try {
            driver.findElement(By.cssSelector("button.ytp-play-button.ytp-button")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            equals(driver.findElement(By.cssSelector(".ytp-play-button.ytp-button")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}