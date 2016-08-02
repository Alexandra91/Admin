package com.tests.Product.ImageManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.ImageManagerProductSteps;
import com.steps.Product.PictureUploadSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/imageManagerNegativeLinks.csv")


public class DisallowedPictureTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerProductSteps imageManagerProductSteps;
	
	@Steps
	public PictureUploadSteps pictureUploadSteps;
	
	private String productLink, baseURL, user, pass,expectedMessage,documentPath1;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		expectedMessage="Disallowed file type.";}
	
	@Test
	public void tc002PictureUploadNegativeTest(){
		
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerProductSteps.navigateTo(productLink);
		imageManagerProductSteps.clickImageManagerTab();
		pictureUploadSteps.loadDocument(documentPath1);
		imageManagerProductSteps.verifyErrorMessage(expectedMessage);
		imageManagerProductSteps.clickCloseButtonErrorMessage();
		imageManagerProductSteps.clickClose();
		
	}
	
	
	
}
