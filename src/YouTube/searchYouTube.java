package YouTube;

import org.openqa.selenium.By;


/*This is a simple JUnit test script to search youtube with the a new 
 * webdriver and verify results are returned*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

public class searchYouTube {
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
    public void searchYouTubeTest() throws Exception {
        driver.get(baseUrl + "/");
        assertEquals("YouTube", driver.getTitle());
        driver.findElement(By.name("search_query")).clear();
        driver.findElement(By.name("search_query")).sendKeys("selenium");
        driver.findElement(By.id("search-icon-legacy")).click();
        String results = driver.findElement(By.id("result-count")).getText();
        System.out.println(results);
        
        try {
            equals(results.contains("results"));
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