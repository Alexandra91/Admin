package com.tests.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.UnitsSoldSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/unitsSoldLinks.csv")

public class UnitsSoldTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public  UnitsSoldSteps unistSoldSteps;
	
	
	private String productLink, baseURL, user, pass, days;

	@Before
	public void dataSetup() {
		user = "admin";
		pass = "admin123";
		
		}
	
	@Test
	public void tc005UnitsSoldTest() {
		logInSteps.login_magentoAdmin(baseURL, user, pass);
		unistSoldSteps.navigateTo(productLink);
		unistSoldSteps.clickUnitsSoldTab();
		unistSoldSteps.getNumberOfUnits();
		unistSoldSteps.clickDropDownDefaultOption();
		unistSoldSteps.selectAnOption();
		unistSoldSteps.clickGenerateGraph();
		unistSoldSteps.verifyChart();
	   
	}

}
