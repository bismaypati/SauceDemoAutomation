package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class CheckoutPage extends BasePage {

	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");

	private By continueButton = By.id("continue");
	private By finishButton = By.id("finish");

	private By checkoutOverviewTitle = By.xpath("//span[text()='Checkout: Overview']");
	private By orderConfirmation = By.xpath("//h2[text()='Thank you for your order!']");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void enterFirstName(String value) {
		clearAndType(firstName, value);
	}

	public void enterLastName(String value) {
		clearAndType(lastName, value);
	}

	public void enterPostalCode(String value) {
		clearAndType(postalCode, value);
	}

	public void clickContinue() {
		click(continueButton);
	}

	public String getCheckoutOverviewTitle() {
		return getText(checkoutOverviewTitle);
	}

	public void clickFinish() {
		click(finishButton);
	}

	public String getOrderConfirmation() {
		return getText(orderConfirmation);
	}

}
