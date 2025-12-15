package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@data-nav-role='signin']")
	WebElement signElement;

	public void ClickOnSignIn() {
		ElementClickable(signElement);

		
	}
	
	
	@FindBy(xpath="//div[@id='claim-collection-container']/h1") WebElement textsigninElement;
	
	public boolean CheckNavigateSignInPage() {
		ElementVisible(textsigninElement);
		String text = textsigninElement.getText();
		if (text.toLowerCase().contains("sign in or create account")) {
			System.out.println(text);
			return true;
		}
		else {
			return false;
	
		}
		
//		String pageSource = driver.getPageSource();
//		if (pageSource.toLowerCase().contains("sign in or create account")) {
//			System.out.println(pageSource);
//			return true;
//		}
//		return false;
	}

}
