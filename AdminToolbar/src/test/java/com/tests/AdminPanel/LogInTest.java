package com.tests.AdminPanel;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;

//@RunWith(SerenityRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/magentoAdmin.csv")
public class LogInTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps
	public LogInSteps loginUser;
	
	private String baseURL;
	private String username;
	private String password;
	
	@Before
	public void setUpTestData(){
		

	}
	
	@Test
	public void login_MagentoAdmin() {
		loginUser.navigateTo(baseURL);
		loginUser.login_magentoAdmin(username,password);
		loginUser.checkPageText("Dashboard");
	}
}
