package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import data.TestData;
import pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

	@Test(
			description = "Verify login with invalid credentials", 
			dataProvider = "invalidLoginData",
			dataProviderClass = TestData.class,
			groups = {"regression"}
		 )
	
	
	public void verifyInvalidLogin(String username, String password, String expectedError) {
		
		LoginPage lp = new LoginPage(getDriver());
		lp.login(username, password);
		
		String errorMessage = lp.getLoginError();
		Assert.assertEquals(errorMessage, expectedError);
	}
}
