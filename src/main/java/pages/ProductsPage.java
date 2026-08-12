package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductsPage extends BasePage {

	private By productsTitle = By.xpath("//span[text()='Products']");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public String getProductsTitle() {
		return waitUtil.waitForElementVisible(productsTitle).getText();
	}
}
