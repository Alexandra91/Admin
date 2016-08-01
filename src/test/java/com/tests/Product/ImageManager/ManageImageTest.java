package com.tests.Product.ImageManager;

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
@UseTestDataFrom(value="src/test/resources/tests/imageManagerLinks.csv")

public class ManageImageTest {

	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerProductSteps imageManagerProductSteps;
	
private String productLink, baseURL, user, pass,expectedMessage;
	
	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		expectedMessage="The image has been successfully removed";
				}
	
	@Test
	public void tc002ManageImageTest(){
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		imageManagerProductSteps.navigateTo(productLink);
		imageManagerProductSteps.clickImageManagerTab();
		imageManagerProductSteps.manageImage("delete-image");
		imageManagerProductSteps.verifySuccessMessage(expectedMessage);
}
	
//	@Before
//	public void dataSetup() {
//		user = "admin";
//		pass = "admin123";
//		expectedMessage="The image has been rotated to the left and the cache was flushed";
//				}
//	
//	@Test
//	public void tc002ManageImageTest(){
//		logInSteps.login_magentoAdmin(baseURL, user, pass);
//		imageManagerProductSteps.navigateTo(productLink);
//		imageManagerProductSteps.clickImageManagerTab();
//		imageManagerProductSteps.manageImage("rotate-image-left");
//		imageManagerProductSteps.verifySuccessMessage(expectedMessage);
//}
	
	
//	@Before
//	public void dataSetup() {
//		user = "admin";
//		pass = "admin123";
//		expectedMessage="The image has been rotated to the right and the cache was flushed";
//				}
//	
//	@Test
//	public void tc002ManageImageTest(){
//		logInSteps.login_magentoAdmin(baseURL, user, pass);
//		imageManagerProductSteps.navigateTo(productLink);
//		imageManagerProductSteps.clickImageManagerTab();
//		imageManagerProductSteps.manageImage("rotate-image-right");
//		imageManagerProductSteps.verifySuccessMessage(expectedMessage);
//}
	
//	@Before
//	public void dataSetup() {
//		user = "admin";
//		pass = "admin123";
//		expectedMessage="The image has been updated and the cache was flushed";
//				}
//	
//	@Test
//	public void tc002ManageImageTest(){
//		logInSteps.login_magentoAdmin(baseURL, user, pass);
//		imageManagerProductSteps.navigateTo(productLink);
//		imageManagerProductSteps.clickImageManagerTab();
//		imageManagerProductSteps.manageImage("update-image");
//		imageManagerProductSteps.verifySuccessMessage(expectedMessage);
//}
	


}
