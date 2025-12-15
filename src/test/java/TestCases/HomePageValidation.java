package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageValidation extends BaseTest {

	HomePage hp;
	
	@Test
	public void TC01_SignIn() {
		hp = new HomePage(driver);
		hp.ClickOnSignIn();
	}
	
	@Test
	public void TC02_CheckUserNavigateSignInPage() {
		Assert.assertEquals(hp.CheckNavigateSignInPage(),false);
		System.out.println("pass");

	}
}
