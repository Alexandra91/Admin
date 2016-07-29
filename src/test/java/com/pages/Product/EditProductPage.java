package com.pages.Product;


import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class EditProductPage extends PageObject {

	@FindBy(css=".desktop-template  [data-fragment='editproduct'] .toolbar-label")
	private WebElement editProduct;
	
	@FindBy(css="[class='url-target-link']")
	private WebElement SKUlink;
	
	@FindBy(css = "[id='itemDataName']")
	private WebElementFacade nameField;

	@FindBy(css = "[id='itemDataDescription']")
	private WebElementFacade descriptionField;

	@FindBy(css = "[id*='itemDataShort']")
	private WebElementFacade shortDescriptionField;

	@FindBy(css = "[id*='itemDataURL']")
	private WebElementFacade URLkeyField;

	@FindBy(css = "[name='news_from_date']")
	private WebElement productNewFromDate;
	
	@FindBy(css = "[name='news_to_date']")
	private WebElement productNewToDate;

//	public void visibilityDropdown(String option) {
//	       // Open the dropdown so the options are visible
//	        getDriver().findElement(By.cssSelector(selector)).click();
//	        // Get all of the options
//	        List<WebElement> options = getDriver().findElements(By.cssSelector(selector));
//	        // Loop through the options and select the one that matches
//	        for (WebElement opt : options) {
//	            if (opt.getText().equals(option)) {
//	                opt.click();
//	                return;
//	            }
//	        }
//	        throw new NoSuchElementException("Can't find " + option + " in dropdown");
//	}
	
	@FindBy(css = "[for='cache-box']")
	private WebElement refreshCacheCheckBox;

	@FindBy(css = "[class='save-btn']")
	private WebElement saveButton;

	@FindBy(css = "[class='discard-btn']")
	private WebElement resetButton;
	
	@FindBy(css = "[class='close-tab-container']")
	private WebElement closeButton;
	
    @FindBy(css="")
	private WebElement successMessage;

    public void pressEditProductTab() {
    	element(editProduct).waitUntilVisible();
		waitABit(2000);
    	editProduct.click();
    }
	
    public void pressSKUlink() {
    	SKUlink.click();
    }
	
	public void fillNameField(String keyword) {
		nameField.type(keyword);
    }
    
    public void fillDescriptionField(String keyword) {
    	descriptionField.sendKeys(keyword);
    }
    
	public void fillShortDescriptionField(String keyword) {
		shortDescriptionField.type(keyword);
    }
    
    public void enterURLkeyField(String keyword) {
    	URLkeyField.type(keyword);
    }

    public void enterStartDate() {
    	productNewFromDate.click();
    }
    
    public void enterEndDate() {
    	productNewToDate.click();
    }
    
    public void checkCacheCheckBox() {
    	refreshCacheCheckBox.click();
    }
    
    public void pressSaveButton() {
    	saveButton.click();
    }
    
    public void pressResetButton() {
    	resetButton.click();
    }
    
    public void pressCloseButton() {
    	closeButton.click();
    }
    
	public void visibilityDropdown(String text) {
		String selectedValue = getDriver().findElement(By.cssSelector("div[id*='itemDataVisibility  '] p>span.select-value")).getText();
		List<WebElement> options = getDriver().findElements(By.cssSelector("[id*='itemDataVisibility'] ul>li"));
		if (selectedValue.contains(text)) {
		} else {
			for (WebElement webElement : options) {
				if (webElement.getText().contains(text)) {
					webElement.click();
					break;
				}
			}
		}
	}
	
    public void checkSaveButton(String mesage){
		boolean found= false;
		if(successMessage.getText().equals(mesage)){
			found=true;
		}
		else {
			found=false;
			Assert.assertTrue("There appear an error message!", found);
		}
	}
}