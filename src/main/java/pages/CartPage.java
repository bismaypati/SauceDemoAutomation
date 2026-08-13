package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {

	private By cartTitle = By.xpath("//span[text()='Your Cart']");
	private By checkoutButton = By.id("checkout");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getCartTitle() {
		return getText(cartTitle);
	}

	public boolean isProductDisplayed(String productName) {
		By product = By.xpath("//div[text()='" + productName + "']");
		return isDisplayed(product);
	}

	public void removeProduct(String productName) {
		By removeButton = By.xpath("//div[@class='inventory_item_name' and text()='" + productName
				+ "']/ancestor::div[@class='cart_item']//button[contains(text(),'Remove')]");
		click(removeButton);
	}

	public boolean isProductPresent(String productName) {
		By product = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
		return !driver.findElements(product).isEmpty();
	}
	
    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}
