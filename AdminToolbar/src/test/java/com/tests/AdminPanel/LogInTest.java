package com.tests.AdminPanel;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;

//@RunWith(SerenityRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="tests/magento.csv")
public class LogInTest {

//	@Managed(uniqueSession = false)
	public WebDriver webdriver;
	
	@Steps
	public LogInSteps loginUser;
	
	private String baseURL;
	private String username;
	private String password;
	
	@Before
	public void setUpTestData(){
		
//		baseURL = "http://admintoolbar-qa-ee114.evozon.com/admin";
		username = "admin";
		password = "admin123";
	}
	
	@Test
	public void login_MagentoAdmin() {
		loginUser.navigateTo(baseURL);
		loginUser.login_magentoAdmin(username,password);
		loginUser.checkPageText("Dashboard");
	}
}
