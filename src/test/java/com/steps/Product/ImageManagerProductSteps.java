package com.steps.Product;

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
	public void clickBrowseButton(){
		imageManagerProductPage.clickBrowse();
	}
	
	@Step
	public void uploadImage(String keyword){
		imageManagerProductPage.upload(keyword);
	}
	
//	@Step
//public void manageImageButton(String name){
//		imageManagerProductPage.manageImageButton(name);
//	}
//	
	@Step
	public void manageImageButton(String name){
		imageManagerProductPage.manageImage(name);
	}

}
