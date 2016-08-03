package com.tests.Product;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.LiveCartSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/tests/adminTabLinks.csv")
public class LiveCartTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logIn;

	@Steps
	public LiveCartSteps liveCart;

	private String baseURL, username, password,productLink,before;

	@Before
	public void testDataSetup() {
		username="admin";
		password="admin123";
	}

	//@Test
	public void liveCartHeader() {
		logIn.login_magentoAdmin(baseURL, username, password);
		liveCart.navigateTo(productLink);
		liveCart.clickLiveCart();
		liveCart.headerVerify("See how many shopping carts this product is currently added to.");
		//
	}

	//@Test
	public void liveCartLogo() {
		logIn.login_magentoAdmin(baseURL, username, password);
		liveCart.navigateTo(productLink);
		liveCart.clickLiveCart();
		liveCart.logoVerify();
	}
	
	@Test
	public void liveCartShoppingCartNumber(){
		logIn.login_magentoAdmin(baseURL, username, password);
		liveCart.navigateTo(productLink);
		liveCart.clickLiveCart();
		before = liveCart.findShoppingCartsNumber();
		liveCart.clickAddToCart();
		liveCart.navigateTo(productLink);
		liveCart.clickLiveCart();
		liveCart.verifyShoppingCartsNumber(before);
		
		
	}
	
}
