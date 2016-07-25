package com.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {

	public void navigateToURL(String URL){
		getDriver().get(URL);
		getDriver().manage().window().maximize();	
	}
	
	  public String switchToNewestOpenedTab() {
	        Set<String> winSet = getDriver().getWindowHandles();
	        List<String> winList = new ArrayList<String>(winSet);
	        Assert.assertTrue("There is only one tab!", winList.size() > 1);
	        String previousTab = winList.get(winList.size() - 2);
	        String newTab = winList.get(winList.size() - 1);
	        getDriver().switchTo().window(newTab);
	        getDriver().manage().window().maximize();
	        return previousTab;
	    }
}
