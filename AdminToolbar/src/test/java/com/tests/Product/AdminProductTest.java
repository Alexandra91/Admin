package com.tests.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AdminPanel.LogInSteps;
import com.steps.Product.AdminProductSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

//@RunWith(SerenityRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/tests/productLinks.csv")
//@UseTestDataFrom(value="src/test/resources/tests/magentoAdmin.csv")

public class AdminProductTest {
	 
@Managed(uniqueSession = true)
public WebDriver webdriver;

@Steps
public LogInSteps logInSteps;
@Steps
public AdminProductSteps adminProductSteps;


private String  productLink, baseURL,user,pass;
 
@Before
public void dataSetup(){
	baseURL="http://admintoolbar-qa-ce191.evozon.com/admin";
	user="admin";
	pass="admin123";
//	productLink="http://admintoolbar-qa-ce191.evozon.com/plaid-cotton-shirt.html";
	
}

@Test
public void tc001AdminProductTest(){
    logInSteps.login_magentoAdmin(user, pass,baseURL);
	adminProductSteps.navigateTo(productLink);
	adminProductSteps.clickAdminTab();
	
}
}
