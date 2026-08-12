package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	public static WebDriver createDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("edge")) {
			return new EdgeDriver();
		}

		throw new IllegalArgumentException("Browser not supported: " + browser);
	}

}
