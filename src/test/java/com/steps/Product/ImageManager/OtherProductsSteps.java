package com.steps.Product.ImageManager;

import org.junit.Assert;

import com.pages.Product.ImageManager.OtherProductsPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class OtherProductsSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	public OtherProductsPage otherProductsPage;

	@Step
	public int getSizeOtherProducts(){
		return otherProductsPage.getSizeOtherProducts();
	}
	
	public void verifyNumberOtherProductsLinks(){
		int actualNumberOfLinks= getSizeOtherProducts();
		System.out.println("The number of other products without images:"+ actualNumberOfLinks);
		Assert.assertTrue("The number of links is wrong", actualNumberOfLinks <=5);
	}
	
	@Step
	public String manageRandomLink(){
		  return otherProductsPage.manageRandomLink();
	}
	
	@Step
	public String getProductLinkName(){
		return otherProductsPage.getUrlLink();
	}
	
	public void verifyUrl(String actual, String expectedLink){
	Assert.assertTrue("The other product link is not equal with the link from the product page", actual.contains(expectedLink));
	}
}
