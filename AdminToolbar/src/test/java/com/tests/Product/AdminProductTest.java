package com.tests.Product;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.Product.AdminProductSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityParameterizedRunner.class)

public class AdminProductTest {
	 
@Managed(uniqueSession = true)
public WebDriver webdriver;

@Steps
public AdminProductSteps adminProductSteps;

public String baseURL;

public void tc001AdminProductTest(){
	adminProductSteps.navigateTo(baseURL);
	adminProductSteps.clickAdminTab();
}
}
