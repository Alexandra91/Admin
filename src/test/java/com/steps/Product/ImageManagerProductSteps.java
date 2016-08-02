package com.steps.Product;

import org.junit.Assert;

import com.pages.Product.ImageManagePage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class ImageManagerProductSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	public ImageManagePage imageManagerProductPage;
	
	@Step
	public void clickImageManagerTab(){
		imageManagerProductPage.clickImageTab();
	}
	
	@Step
	public void clickCloseButtonSuccessMessage(){
		imageManagerProductPage.clickCloseSuccessMessageButton();
		
		
	}
	
	@Step
	public void clickCloseButtonErrorMessage(){
		imageManagerProductPage.clickCloseErrorMessageButton();
		
		
	}
	@Step
	public void clickClose(){
		imageManagerProductPage.clickCloseLink();
	}
	
	@Step
    public void manageImage(String name){
		imageManagerProductPage.managerandomImage(name);
	}
	
	public String grabSuccessMessage(){
		return imageManagerProductPage.getSuccessMessage();
	}
	
	public String grabErrorMessage(){
		return imageManagerProductPage.getErrorMessage();
	
	}
	
	public void verifySuccessMessage(String expectedMessage){
		String actualMessage=grabSuccessMessage();
		Assert.assertTrue("The message is not correct",actualMessage.contains(expectedMessage));
	}
	
	public void verifyErrorMessage(String expectedMessage){
		String actualMessage=grabErrorMessage();
		Assert.assertTrue("The message is not correct",actualMessage.contains(expectedMessage));
        
	}
	

}
