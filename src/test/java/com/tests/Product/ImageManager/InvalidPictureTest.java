package com.tests.Product.ImageManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.ImageManager.ImageManagerSteps;
import com.steps.Product.ImageManager.PictureUploadSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/imageManagerNegativeLinks.csv")

public class InvalidPictureTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerSteps imageManagerSteps;
	
	@Steps
	public PictureUploadSteps pictureUploadSteps;
	
	private String productLink, baseURL, user, pass,expectedMessage,documentPath2;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		expectedMessage="Invalid file selected for upload";}
	
	@Test
	public void tc004PictureUploadNegativeTest(){
		
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerSteps.navigateTo(productLink);
		imageManagerSteps.clickImageManagerTab();
		pictureUploadSteps.loadDocument(documentPath2);
		imageManagerSteps.verifyErrorMessage(expectedMessage);
		imageManagerSteps.clickCloseButtonErrorMessage();
		imageManagerSteps.clickClose();
		
	}
	
}
