package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String fileName) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + fileName
				+ ".png";

		try {
			FileUtils.copyFile(source, new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filePath;
	}

	public static String getScreenshotAsBase64(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}
