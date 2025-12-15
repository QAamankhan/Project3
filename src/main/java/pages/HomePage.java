package pages;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	
	
	
}

//	public boolean CheckNavigateSignInPage() {
//		ElementVisible(textsigninElement);
//		String text = textsigninElement.getText();
//		if (text.toLowerCase().contains("sign in or create account")) {
//			System.out.println(text);
//			return true;
//		}
//		else {
//			return false;
//	
//		}
		
//		String pageSource = driver.getPageSource();
//		if (pageSource.toLowerCase().contains("sign in or create account")) {
//			System.out.println(pageSource);
//			return true;
//		}
//		return false;
