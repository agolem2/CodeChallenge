package utiity;
/**
 * @author miloonken
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import junit.framework.TestListener;
@Ignore
public class WebDriverBrowserFactory {
    public static WebDriver dr = null;
    public static WebDriver driver;
    static java.util.Date date = new java.util.Date();
    static Timestamp t = new Timestamp(date.getTime());
    static String dateNow = t.toString().replace(":", "_");
    String obj = "Screenshots";
    String className = this.getClass().getSimpleName();
    String actualTitle;
    private static StringBuffer verificationErrors = new StringBuffer();

    @Ignore

    public static WebDriver GetDriver(String browser) {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/miloonken/dev/chromedriver");
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("IE"))
            System.setProperty("webdriver.InternetExplorer.driver", "/Users/miloonken/dev/InternetExplorer.exe");
        driver = new InternetExplorerDriver();

        if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @Before
    @Ignore
    public void openBrowser() {

        File file = new File("/Users/miloonken/dev/Config.Properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e)

        {
            e.printStackTrace();
        }

        //driver = (GetDriver(prop.getProperty("browser")));
        //System.out.print(prop.getProperty("browser"));

        System.setProperty("webdriver.chrome.driver", "/Users/miloonken/dev/chromedriver");
        driver = new ChromeDriver();
        driver.get("about:blank");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    @Ignore
    public void tearDown() throws Exception {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            System.out.print(verificationErrorString);
        }

        @SuppressWarnings("unused")
		Result result = JUnitCore.runClasses(TestListener.class);
        System.out.println("Completed Test Case " + className + " Date:  " + dateNow);

       
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Save the screenshot to a file some place
            try {
                FileUtils.copyFile(scrFile, new File("/Users/miloonken/dev/screenshots/screenshot" + dateNow + ".png"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            WebDriverBrowserFactory.driver.quit();
            driver.quit();
        }
       
    
    @Ignore
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}