package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

	@Test(groups = { "smoke" })
	public void verifyCheckout() {

		LoginPage loginPage = new LoginPage(getDriver());

		ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

		productsPage.addProductToCart("Sauce Labs Backpack");

		CartPage cartPage = productsPage.clickCart();

		CheckoutPage checkoutPage = cartPage.clickCheckout();

		checkoutPage.enterFirstName("Bismay");
		checkoutPage.enterLastName("Pati");
		checkoutPage.enterPostalCode("500001");

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutPage.getCheckoutOverviewTitle(), "Checkout: Overview");

		checkoutPage.clickFinish();

		Assert.assertEquals(checkoutPage.getOrderConfirmation(), "Thank you for your order!");
	}
}
