package PageObjects;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import utiity.WebDriverBrowserFactory;


public class JUnitParallel extends WebDriverBrowserFactory{
	@SuppressWarnings("unused")
	private String platform;
	@SuppressWarnings("unused")
	private String browserName;
	@SuppressWarnings("unused")
	private String browserVersion;

	@Parameterized.Parameters
	public static LinkedList<String[]> getEnvironments() throws Exception {
		LinkedList<String[]> env = new LinkedList<String[]>();
		env.add(new String[]{Platform.WINDOWS.toString(), "chrome", "50"});
		env.add(new String[]{Platform.WINDOWS.toString(),"firefox","latest"});
		env.add(new String[]{Platform.WINDOWS.toString(),"ie","9"});

		//add more browsers here

		return env;
	}


	public JUnitParallel(String platform, String browserName, String browserVersion) {
		this.platform = platform;
		this.browserName = browserName;
		this.browserVersion = browserVersion;
	}
	
	@Test
	public void testSimple() throws Exception {
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("TestingBot");
		element.submit();
		driver = new Augmenter().augment(driver);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("Screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}