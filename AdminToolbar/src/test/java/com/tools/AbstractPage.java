package com.tools;

import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {

	public void navigateToURL(String URL){
		getDriver().get(URL);
		getDriver().manage().window().maximize();
		
	}
}
