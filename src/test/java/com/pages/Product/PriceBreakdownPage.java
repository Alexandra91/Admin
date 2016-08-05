package com.pages.Product;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class PriceBreakdownPage extends AbstractPage {

	@FindBy(css=".desktop-template a[data-fragment='pricebreakdown']")
	private WebElement priceBreakdownTab;
	
	
	
	
	
	public void clickPriceBreakdownTab(){
		element(priceBreakdownTab).waitUntilVisible();
		priceBreakdownTab.click();
	}
}
