package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private WebDriverWait wait;

	public WaitUtil(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
