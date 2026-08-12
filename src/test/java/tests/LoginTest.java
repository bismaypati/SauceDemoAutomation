package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import data.TestData;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", 
			dataProviderClass = TestData.class,
			groups = {"smoke"})
	
	public void verifyLogin(String username, String password) {
		
		LoginPage lp = new LoginPage(getDriver());

		ProductsPage productsPage = lp.login(username, password);

		Assert.assertEquals(productsPage.getProductsTitle(), "Products");
	}
}
