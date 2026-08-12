package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	public static WebDriver createDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
		    options.addArguments("--disable-features=PasswordLeakDetection");
		    options.addArguments("--disable-features=PasswordManagerOnboarding");
		    options.addArguments("--disable-save-password-bubble");


		    options.setExperimentalOption("prefs",
		            java.util.Map.of(
		                    "credentials_enable_service", false,
		                    "profile.password_manager_enabled", false,
		                    "profile.password_manager_leak_detection", false
		            ));

			return new ChromeDriver(options);
		}

		if (browser.equalsIgnoreCase("edge")) {
			return new EdgeDriver();
		}

		throw new IllegalArgumentException("Browser not supported: " + browser);
	}

}
