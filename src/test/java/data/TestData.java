package data;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import utils.ExcelUtility;

public class TestData {

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		String filePath = "src/test/resources/testdata/LoginData.xlsx";
		ExcelUtility excel = new ExcelUtility(filePath, "LoginData");

		int rowCount = excel.getRowCount();
		int columnCount = excel.getColumnCount();

		Object[][] data = new Object[rowCount - 1][columnCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				data[i - 1][j] = excel.getCellData(i, j);
			}
		}

		excel.closeWorkbook();
		return data;
	}

	@DataProvider(name = "invalidLoginData", parallel = true)
	public Object[][] invalidLoginData() {
		return new Object[][] {
				{ "standard_user", "wrong_password",
						"Epic sadface: Username and password do not match any user in this service" },
				{ "wrong_user", "wrong_password",
						"Epic sadface: Username and password do not match any user in this service" },
				{ "", "secret_sauce", "Epic sadface: Username is required" },
				{ "standard_user", "", "Epic sadface: Password is required" } };
	}
}
