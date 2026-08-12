package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.BrowserFactory;
import utils.ConfigReader;

public class BaseTest {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		
		String browser = ConfigReader.getProperty("browser");
		
		WebDriver webDriver = BrowserFactory.createDriver(browser);
		driver.set(webDriver);
		getDriver().manage().window().maximize();
		getDriver().get(ConfigReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}
