package com.tests.Product;

import java.text.ParseException;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.EditProductSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/tests/magentoAdmin.csv")
//@RunWith(SerenityRunner.class)
public class EditProductTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps
	public LogInSteps logIn;
	
	@Steps
	public EditProductSteps editProduct;
	
	private String baseURL, username, password, productURL;
	
	@Before
	public void testDataSetup() {
		//baseURL = "http://admintoolbar-qa-ce181.evozon.com/admin";
		//user = "admin";
		//pass = "admin123";
		productURL="http://admintoolbar-qa-ce181.evozon.com/asics-mengel-kayano.html";
	}
	

	@Test
	public void editProductTest() throws ParseException{
		logIn.login_magentoAdmin(baseURL, username, password);
		editProduct.navigateTo(productURL);
		editProduct.clickEditProduct();
		editProduct.enterNameField("#$^GG^Y%&&$%");
		editProduct.enterShortDescription("Vreau sa vad daca merge");
		editProduct.startDate(8, 12, 2015);
		editProduct.chooseOptionVisibilityDropDown("Not Visible Individually");
	}
	

}
