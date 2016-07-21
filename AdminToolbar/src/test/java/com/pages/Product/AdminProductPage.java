package com.pages.Product;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class AdminProductPage extends AbstractPage {

	@FindBy(css=".desktop-template a[data-fragment='admin']")
	private WebElement adminTab;
	
	public void clickAdminTab(){
		element(adminTab).waitUntilVisible();
		waitABit(200);
		adminTab.click();
	}
	
	
}
