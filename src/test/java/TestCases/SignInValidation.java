package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SignInPage;

import utilities.*;

public class SignInValidation extends BaseTest {

	SignInPage sp;

	@Test(groups = {"SignIn","regression"})
	public void TC01_SignIn() {
		sp = new SignInPage(driver);
		String text = sp.ClickOnSignIn();
		if (text.toLowerCase().contains("sign in or create account")) {
			Assert.assertTrue(true, text);
		}
	}

	@Test(dataProvider = "ExcelData", dataProviderClass = BaseTest.class,groups = {"SignIn","regression"})
	public void TC02_FillCreds(String email, String password) {
		sp.FillCredentials(email, password);
		String nametext = sp.ValidateLoginSucessfull();
		if (nametext.toLowerCase().contains("aman")) {
			System.out.println("Login successful: " + nametext);
			Assert.assertTrue(true);
		} else {
			System.out.println("Login failed. Actual text: " + nametext);
		}

	}

}
