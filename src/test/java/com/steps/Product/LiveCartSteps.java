package com.steps.Product;

import net.thucydides.core.annotations.Step;

import com.pages.Product.LiveCartPage;
import com.tools.AbstractSteps;

public class LiveCartSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	LiveCartPage liveCartPage;

	@Step
	public void clickLiveCart() {
		liveCartPage.pressLiveCartTab();
	}

	@Step
	public String findShoppingCartsNumber(){
		return liveCartPage.findNumber();
	}
	
	@Step
	public void verifyShoppingCartsNumber(String before){
		liveCartPage.checkShoppingCartsNumber(before);
	}
	
	@Step
	public void clickAddToCart() {
		liveCartPage.pressAddToCart();
	}

	@Step
	public void headerVerify(String text) {
		liveCartPage.checkPageHeader(text);
	}

	@Step
	public void logoVerify() {
		liveCartPage.checkPageLogo();
	}

}
