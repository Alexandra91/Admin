package com.tests.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.ImageManagerProductSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/adminTabLinks.csv")

public class ImageManagerProductTest {
	
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerProductSteps imageManagerProductSteps;
	
	private String productLink, baseURL, user, pass;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
			}
	
	@Test
	public void tc003ImageManagerProductTest(){
		
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerProductSteps.navigateTo(productLink);
		imageManagerProductSteps.clickImageManagerTab();
		//imageManagerProductSteps.clickBrowseButton();
		imageManagerProductSteps.uploadImage("e:\3.jpg");
		//imageManagerProductSteps.manageImageButton("rotate-image-right");
		
	}
}
