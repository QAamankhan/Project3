package TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utilities.ReadConfig;

public class BaseTest {

	static WebDriver driver;
	ReadConfig rc;

	@BeforeClass
	public void OpenBrowser() {
		rc = new ReadConfig();
		String browser = rc.GetBrowser();
		String url = rc.GetUrl();

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			driver.get(url);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			driver.get(url);

			break;

		case "Edge":
			driver = new EdgeDriver();
			driver.get(url);

			break;

		default:
			System.out.println("please select valid browser name");

		}

		driver.manage().window().maximize();
	}

	
	@AfterClass
	public void TearDown() {
		driver.close();
	}
	
	
	public static void ScreenShots(String testname,String status) {
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		String dirpath=System.getProperty("user.dir")+ "\\Screenshots\\" + status;
		
		File directory= new File(dirpath);
		
		if(!directory.exists()) {
			directory.mkdirs();
		}

		String destpath=dirpath+"\\"+testname+".png";
		File dest= new File(destpath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
