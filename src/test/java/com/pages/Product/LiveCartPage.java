package com.pages.Product;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LiveCartPage extends PageObject {

	@FindBy(css = ".desktop-template [data-fragment='livecart']")
	private WebElement liveCart;

	@FindBy(css = ".header-subtitle")
	private WebElement pageHeader;

	@FindBy(css = "p.live-info.large")
	private WebElement shoppingCarts;

	@FindBy(css = ".btn-cart")
	private WebElement addToCartButton;

	public void pressLiveCartTab() {
		element(liveCart).waitUntilVisible();
		waitABit(2000);
		liveCart.click();
	}

	public void pressAddToCart() {
		addToCartButton.click();
	}

	public String findNumber() {
		String text = element(shoppingCarts).getText();
		int length = text.length();
		String number = "";
		for (int i = 0; i < length; i++) {
			Character character = text.charAt(i);
			if (Character.isDigit(character)) {
				number += character;
			}
		}
		System.out.println("Number of shopping carts where the product is currently added to: "+ number);
		return number;
	}

	public void checkShoppingCartsNumber(String before) {

		Integer nr = Integer.parseInt(findNumber());
		Integer result = Integer.parseInt(before) + 1;
		boolean isEqual = false;
		if (result.equals(nr)) {
			isEqual = true;
		}
		Assert.assertTrue("Number doesn't match", isEqual);
	}

	public void checkPageHeader(String text) {
		boolean found = false;
		element(pageHeader).waitUntilVisible();
		if (pageHeader.getText().contains(text)) {
			found = true;
			System.out.println(pageHeader.getText());
		}
		Assert.assertTrue("Text doesn't match", found);
	}

	public void checkPageLogo() {
		Assert.assertTrue("Tab logo doesn't match",
				getDriver().findElement(By.cssSelector(".logo-holder")).isDisplayed());
		System.out.println("Logo is displayed");
	}

}
