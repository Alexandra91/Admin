package com.steps.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

import com.pages.Product.AdminProductPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class AdminProductSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	public AdminProductPage adminProductPage;


	@Step
    public void clickAdminTab(){
		adminProductPage.clickAdminTab();
	}
	
	public String grabStoreView(){
		return adminProductPage.getStoreView();
	  
	}
	
	
	public void verifyStoreView(String expectedStore){
		String actualStore=grabStoreView();
	Assert.assertTrue("The store view is not default",actualStore.contains(expectedStore));
	
	}
	
	
	}
	
	

		
	

