package com.pages.Product.UnitsSold;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CheckoutPage extends AbstractPage {
	
	@FindBy(css="div.qty-wrapper input#qty")
    private WebElement qtyInput;
	
	@FindBy(css="div.add-to-cart-buttons button.btn-cart")
	private WebElement addToCartButton;
	
	public void enterQuantity(String key){
		element(qtyInput).waitUntilVisible();
		qtyInput.sendKeys(key);
	}
	
	public void clickAddToCart(){
		element(addToCartButton).waitUntilVisible();
		addToCartButton.click();
	}
}
