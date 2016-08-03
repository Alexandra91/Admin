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
@UseTestDataFrom(value="src/test/resources/tests/imageManagerPositiveLinks.csv")

public class PictureUploadTest {
	
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerSteps imageManagerSteps;
	
	@Steps
	public PictureUploadSteps pictureUploadSteps;
	
	private String productLink, baseURL, user, pass,expectedMessage,documentPath;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		expectedMessage="The image has been successfully added";
				}
	
	@Test
	public void tc001PictureUploadPositiveTest(){
		
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerSteps.navigateTo(productLink);
		imageManagerSteps.clickImageManagerTab();
		pictureUploadSteps.loadDocument(documentPath);
		imageManagerSteps.verifySuccessMessage(expectedMessage);
		imageManagerSteps.clickCloseButtonSuccessMessage();
		imageManagerSteps.clickClose();
		
	}
}
