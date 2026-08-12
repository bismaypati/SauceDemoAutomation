package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtil;

public class BasePage {
	protected WebDriver driver;
	protected WaitUtil waitUtil;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}

	public void clearAndType(By locator, String text) {
		WebElement element = waitUtil.waitForElementVisible(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void click(By locator) {
		WebElement element = waitUtil.waitForElementClickable(locator);
		element.click();
	}
	
	public String getText(By locator) {
		return waitUtil.waitForElementVisible(locator).getText();
	}
}
