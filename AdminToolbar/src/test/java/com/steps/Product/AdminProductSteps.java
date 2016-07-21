package com.steps.Product;

import com.pages.Product.AdminProductPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class AdminProductSteps extends AbstractSteps {

	public AdminProductPage adminProductPage;


	@Step
    public void clickAdminTab(){
		adminProductPage.clickAdminTab();
	}
	
	
}
