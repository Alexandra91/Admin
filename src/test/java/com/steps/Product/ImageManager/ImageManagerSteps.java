package com.steps.Product.ImageManager;

import org.junit.Assert;

import com.pages.Product.ImageManager.ImageManagerPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class ImageManagerSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	public ImageManagerPage imageManagerPage;
	
	@Step
	public void clickImageManagerTab(){
		imageManagerPage.clickImageTab();
	}
	
	@Step
	public void clickCloseButtonSuccessMessage(){
		imageManagerPage.clickCloseSuccessMessageButton();
		
		
	}
	
	
	@Step
	public void clickCloseButtonErrorMessage(){
		imageManagerPage.clickCloseErrorMessageButton();
		
		
	}
	@Step
	public void clickClose(){
		imageManagerPage.clickCloseLink();
	}
	
	@Step
    public void manageImage(String name){
		imageManagerPage.managerandomImage(name);
	}
	
	public String grabSuccessMessage(){
		return imageManagerPage.getSuccessMessage();
	}
	
	public String grabErrorMessage(){
		return imageManagerPage.getErrorMessage();
	
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
