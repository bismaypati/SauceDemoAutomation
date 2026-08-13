package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductsPage extends BasePage {

	private By productsTitle = By.xpath("//span[text()='Products']");
	private By cartIcon = By.className("shopping_cart_link");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public String getProductsTitle() {
		return getText(productsTitle);
	}

	public void addProductToCart(String productName) {

		By addToCartButton = By
				.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");

		click(addToCartButton);
	}

	public CartPage clickCart() {
		click(cartIcon);
		return new CartPage(driver);
	}
}
