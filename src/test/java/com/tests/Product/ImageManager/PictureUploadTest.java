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
@UseTestDataFrom(value="src/test/resources/tests/imageManagerPositiveLinks.csv")

public class PictureUploadTest {
	
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerProductSteps imageManagerProductSteps;
	
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
		imageManagerProductSteps.navigateTo(productLink);
		imageManagerProductSteps.clickImageManagerTab();
		pictureUploadSteps.loadDocument(documentPath);
		imageManagerProductSteps.verifySuccessMessage(expectedMessage);
		imageManagerProductSteps.clickCloseButtonSuccessMessage();
		imageManagerProductSteps.clickClose();
		
	}
}
