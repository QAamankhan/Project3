package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class CartPage extends BaseClass {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
	
	@FindBy(id = "nav-cart")WebElement cartlogoElement;

	public String ClickOnCartLogo() {
		ElementClickable(cartlogoElement);

		String title = driver.getTitle();
		return title;
	}

	
	@FindBy(id="sc-subtotal-label-buybox") WebElement itemcountElement;
	public String ValidateAddingItemCount() {
		
		String itemcount= itemcountElement.getText();
		return itemcount;
	}
	
	@FindBy(xpath = "//button[@data-a-selector='decrement']")List<WebElement> removeproductfromcartElement;

	public void CheckCartEmpty() {

		ElementClickable(cartlogoElement);

		List<WebElement> removeBtns = driver.findElements(By.xpath("//button[@data-a-selector='decrement']"));
		if (removeBtns.isEmpty()) {
			System.out.println("Cart is already empty");
			return;
		}
		while (!removeBtns.isEmpty()) {
			removeBtns.get(0).click();
			// re-locate elements after DOM update
			removeBtns = driver.findElements(By.xpath("//button[@data-a-selector='decrement']"));
		}
		System.out.println("Cart cleaned successfully");
	}
}

