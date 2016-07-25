package com.pages.Product;

import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class ImageManagerProductPage extends AbstractPage {
	
	@FindBy(css=".desktop-template a[data-fragment='imagemanager']")
	private WebElement imageManagerTab;
	
	@FindBy(css=".header-subtitle")
	private WebElement imageTabDescription;
	
	@FindBy(css=".browse-holder>p")
	private WebElement browseButton;
	

}
