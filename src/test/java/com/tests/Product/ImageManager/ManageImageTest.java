package com.tests.Product.ImageManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.ImageManager.ImageManagerSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/imageManagerPositiveLinks.csv")

public class ManageImageTest {

	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerSteps imageManagerSteps;
	
private String productLink, baseURL, user, pass,expectedMessage1,expectedMessage2,expectedMessage3,expectedMessage4;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		expectedMessage1="The image has been successfully removed";
		expectedMessage2="The image has been rotated to the left and the cache was flushed";
		expectedMessage3="The image has been rotated to the right and the cache was flushed";
		expectedMessage4="The image has been updated and the cache was flushed";
				}
	
	@Test
    public void tc003ManageImageDeleteTest(){
    logInSteps.login_magentoAdmin(baseURL, user, pass);
	imageManagerSteps.navigateTo(productLink);
	imageManagerSteps.clickImageManagerTab();
	imageManagerSteps.manageImage("delete-image");
	imageManagerSteps.verifySuccessMessage(expectedMessage1);
}
	
//	@Test
	public void tc003ManageImageRotateLeftTest(){
	logInSteps.login_magentoAdmin(baseURL, user, pass);
	imageManagerSteps.navigateTo(productLink);
	imageManagerSteps.clickImageManagerTab();
	imageManagerSteps.manageImage("rotate-image-left");
	imageManagerSteps.verifySuccessMessage(expectedMessage2);
}
	

//	@Test
	public void tc003ManageImageRotateRightTest(){
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerSteps.navigateTo(productLink);
		imageManagerSteps.clickImageManagerTab();
		imageManagerSteps.manageImage("rotate-image-right");
		imageManagerSteps.verifySuccessMessage(expectedMessage3);
}
	

//	@Test
	public void tc003ManageImageUpdateTest(){
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerSteps.navigateTo(productLink);
		imageManagerSteps.clickImageManagerTab();
		imageManagerSteps.manageImage("update-image");
		imageManagerSteps.verifySuccessMessage(expectedMessage4);
}
	


}
