package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {
	private By productsTitle = By.className("title");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getProductsTitle() {
		return waitUtil.waitForElementVisible(productsTitle).getText();
	}
}
