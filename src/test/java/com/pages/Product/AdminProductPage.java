package com.pages.Product;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class AdminProductPage extends AbstractPage {

	@FindBy(css=".desktop-template a[data-fragment='admin']")
	private WebElement adminTab;
	
	@FindBy(css="#store_switcher>option")
	private WebElement adminStoreView;
	
		
	public void clickAdminTab(){
		element(adminTab).waitUntilVisible();
		waitABit(2000);
		adminTab.click();
	}
	
	public String getStoreView(){
		element(adminStoreView).waitUntilVisible();
	    return adminStoreView.getText();
			
	}
	
	
	
}
