package com.steps.Product;

import org.junit.Assert;

import com.pages.Product.ImageManagerProductPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class ImageManagerProductSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	public ImageManagerProductPage imageManagerProductPage;
	
	@Step
	public void clickImageManagerTab(){
		imageManagerProductPage.clickImageTab();
	}
	
	@Step
	public void uploadImage(String keyword){
		imageManagerProductPage.upload(keyword);
	}
	
	@Step
public void manageImage(String name){
		imageManagerProductPage.managerandomImage(name);
	}
	
	public String grabSuccessMessage(){
		return imageManagerProductPage.getSuccessMessage();
	}
	
	public void verifySuccessMessage(String expectedMessage){
		String actualMessage=grabSuccessMessage();
		Assert.assertTrue("The message is not correct",actualMessage.contains(expectedMessage));
	}
	


}
