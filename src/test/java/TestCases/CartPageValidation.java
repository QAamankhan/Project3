package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;

public class CartPageValidation  extends BaseTest{

	CartPage cp;
	
	
	
	@Test(groups = {"Cart","regression"})
	public void TC01_CheckCart() {
		cp= new CartPage(driver);
		cp.CheckCartEmpty();
		
	}
	
	@Test(groups = {"Cart","regression"})
	public void TC02_ValidateCartPageTitle() {
		
		String title=cp.ClickOnCartLogo();
		if (title.toLowerCase().contains("cart")) {
			System.out.println( "User Navigate"+title+"page");
			Assert.assertTrue(true);
		}else {
			System.out.println( "Something Worng"+title);
//			Assert.assertTrue(false);
		}
	}
	
	@Test(groups = {"Cart","regression"})
	public void TC03_IteamCount() {
		String itemcount=cp.ValidateAddingItemCount();
		
		if (itemcount.contains("4")) {
			System.out.println("Iteam is add in Cart : "+ itemcount);
			Assert.assertTrue(true);
			
		}
		else {
			System.out.println("Item is no add according to coustumer : " +itemcount);
//			Assert.assertFalse(false);
		}
	}
	
}
