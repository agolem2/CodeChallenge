package DataDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.TestListener;


public class DataProvider1 
{
    public static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
    static java.util.Date date = new java.util.Date();
    static Timestamp t = new Timestamp(date.getTime());
    static String dateNow = t.toString().replace(":", "_");
    
	 @BeforeClass
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
    @Test(dataProvider="DataInput")
    public void login(String userName, String pass, String expTitle) throws InterruptedException{
    	
    	//open browser and search
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        Actions act = new Actions(driver);
        
        //Search
        act.moveToElement(driver.findElement(By.name("q"))).perform();
        driver.findElement(By.name("q")).sendKeys(userName);
        driver.findElement(By.name("btnK")).click();
        
        Thread.sleep(2000);
        String actTitle = driver.getTitle();
        
        Assert.assertEquals(actTitle, expTitle);
        System.out.println("Assert Complete");
	    driver.close();
        System.out.println("Closing Driver");

	    	driver.quit();
	        System.out.println("Quiting Driver");

        
        {
        }
    }
    
    @DataProvider(name="DataInput")
    public static Iterator<Object[]> fetchData() throws InvalidFormatException, IOException{
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        FileInputStream fis = new FileInputStream("/Users/miloonken/Downloads/InputData.xls");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");
        int numOfRows = sh.getLastRowNum();
        String userName, pass, expTitle;
        for(int i=0; i<numOfRows; i++){
            userName = sh.getRow(i).getCell(0).getStringCellValue();
            pass = sh.getRow(i).getCell(1).getStringCellValue();
            expTitle = sh.getRow(i).getCell(2).getStringCellValue();
            myData.add(new Object[]{userName,pass,expTitle});
        }
        return myData.iterator();
    }
    
    @AfterClass
	    public void tearDown() throws Exception {
	               String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	        System.out.print(verificationErrorString);
	    }
	 
	    Result result = JUnitCore.runClasses(TestListener.class);
		System.out.println("Total number of tests Run Count" + result.getRunCount());
   
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        // Save the screenshot to a file some place
	        try {
	            FileUtils.copyFile(scrFile, new File("/Users/miloonken/dev/screenshots/screenshot" + dateNow + ".png"));
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	 
	    
	    driver.close();
	    driver.quit();
	 
	    }
}
