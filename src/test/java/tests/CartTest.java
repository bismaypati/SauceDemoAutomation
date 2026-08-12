package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

	@Test(groups = { "smoke" })
	public void verifyCartPage() {

		LoginPage loginPage = new LoginPage(getDriver());

		ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

		productsPage.addProductToCart("Sauce Labs Backpack");

		CartPage cartPage = productsPage.clickCart();

		Assert.assertEquals(cartPage.getCartTitle(), "Your Cart");

		Assert.assertTrue(cartPage.isProductDisplayed("Sauce Labs Backpack"));
		cartPage.removeProduct("Sauce Labs Backpack");
		Assert.assertFalse(cartPage.isProductPresent("Sauce Labs Backpack"));
	}

}
