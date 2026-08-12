package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import base.BasePage;
import utils.LogUtil;

public class LoginPage extends BasePage {

	private static final Logger logger = LogUtil.getLogger(LoginPage.class);

	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By loginError = By.cssSelector("[data-test='error']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public ProductsPage login(String user, String pwd) {
		logger.info("Entering username");
		clearAndType(username, user);

		logger.info("Entering password");
		clearAndType(password, pwd);

		logger.info("Clicking login button");
		click(loginBtn);

		logger.info("Login successful");
		return new ProductsPage(driver);
	}

	public String getLoginError() {
		return getText(loginError);
	}
}
