package com.pages.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class EditProductPage extends PageObject {

	@FindBy(css=".desktop-template [data-fragment='editproduct']")
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

	@FindBy(css = "[class='ui-datepicker-month']")
	private WebElement calendarTitle;

	@FindBy(css = "[name='news_from_date']")
	private WebElement calendarNewFromDate;

	@FindBy(css = "[data-handler='prev']")
	private WebElement prevDate;

	@FindBy(css = "[data-handler='next']")
	private WebElement nextDate;

	@FindBy(css = "[name='news_to_date']")
	private WebElement calendarNewToDate;

	@FindBy(css = "")
	private WebElement statusDropdown;

	@FindBy(css = "")
	private WebElement visibilityDropdown;

	@FindBy(css = "[for='cache-box']")
	private WebElement refreshCacheCheckBox;

	@FindBy(css = "[class='save-btn']")
	private WebElement saveButton;

	@FindBy(css = "[class='discard-btn']")
	private WebElement resetButton;
	
	@FindBy(css = "[class='close-tab-container']")
	private WebElement closeButton;

    public void pressEditProductTab() {
    	editProduct.click();
    }
	
    public void pressSKUlink() {
    	SKUlink.click();
    }
	
	public void fillNameField(String keyword) {
		nameField.type(keyword);
    }
    
    public void fillDescriptionField(String keyword) {
    	descriptionField.type(keyword);
    }
    
	public void fillShortDescriptionField(String keyword) {
		shortDescriptionField.type(keyword);
    }
    
    public void enterURLkeyField(String keyword) {
    	URLkeyField.type(keyword);
    }
    
	@FindBy(css="")
	private WebElement successMessage;
	
	public void setDate(int month, int day, int year) throws ParseException {

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + String.valueOf(month) + "/"
				+ String.valueOf(year)));

		Calendar cal = Calendar.getInstance();
		do {
			element(calendarTitle).waitUntilVisible();
			String MandY = calendarTitle.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy dd");
			System.out.println(MandY);
			cal.setTime(sdf.parse(MandY + " 1"));

			if (cal.compareTo(calNew) == -1) {
				nextDate.click();
			}
			if (cal.compareTo(calNew) == 1) {
				prevDate.click();
			}
		} while (cal.compareTo(calNew) != 0);

		List<WebElement> days = getDriver()
				.findElements(
						By.cssSelector("[class='ui-state-default']"));
		for (WebElement currentDay : days) {
			if (currentDay.getText().toLowerCase()
					.equals(String.valueOf(day).toLowerCase()))
				currentDay.click();
		}
	}
	
	public void enterStartDate() {
		element(calendarNewFromDate).waitUntilVisible();
		calendarNewFromDate.click();
	}
	
	public void enterEndDate() {
		element(calendarNewToDate).waitUntilVisible();
		calendarNewToDate.click();
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