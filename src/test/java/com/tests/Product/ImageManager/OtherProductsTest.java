package com.tests.Product.ImageManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.ImageManager.ImageManagerSteps;
import com.steps.Product.ImageManager.OtherProductsSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/imageManagerPositiveLinks.csv")

public class OtherProductsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ImageManagerSteps imageManagerSteps;
	
	@Steps
	public OtherProductsSteps otherProductsSteps;
	
private String productLink, baseURL, user, pass;

@Before
public void dataSetup() {
	user = "admin";
	pass = "admin123";}

@Test
public void tc004OtherProductsTest(){
logInSteps.login_magentoAdmin(baseURL, user, pass);
imageManagerSteps.navigateTo(productLink);
imageManagerSteps.clickImageManagerTab();
otherProductsSteps.getSizeOtherProducts();
otherProductsSteps.verifyNumberOtherProductsLinks();
String actualLink = otherProductsSteps.manageRandomLink();
otherProductsSteps.switchToNewestOpenedTab();
String expectedLink=otherProductsSteps.getProductLinkName();
System.out.println("Expected link:"+expectedLink);
otherProductsSteps.verifyUrl(actualLink,expectedLink);

}


}
