package com.steps.Product;

import java.text.ParseException;
import net.thucydides.core.annotations.Step;
import com.pages.Product.EditProductPage;
import com.tools.AbstractSteps;
import com.tools.CalendarPage;

public class EditProductSteps extends AbstractSteps {

	private static final long serialVersionUID = 2225949172202746779L;
	EditProductPage editProductPage;
	CalendarPage calendarPage;
	
	@Step
	public void clickEditProduct() {
		editProductPage.pressEditProductTab();
	}
	@Step
	public void clickSKU() {
		editProductPage.pressSKUlink();
	}
	
	@Step
	public void enterNameField(String keyword) {
		editProductPage.fillNameField(keyword);
	}

	@Step
	public void enterDescription(String keyword) {
		editProductPage.fillDescriptionField(keyword);
	}

	@Step
	public void enterShortDescription(String keyword){
		editProductPage.fillShortDescriptionField(keyword);
	}
	
	@Step
	public void enterURLkeyField(String keyword){
		editProductPage.enterURLkeyField(keyword);
	}
	
	@Step
	public void startDate(int month, int day, int year) throws ParseException {
		editProductPage.enterStartDate();
		calendarPage.setDate(month, day, year);
	}
	
	@Step
	public void endDate(int month, int day, int year) throws ParseException {
		editProductPage.enterEndDate();
		calendarPage.setDate(month, day, year);
	}
	
	@Step
	public void chooseOptionVisibilityDropDown(String option) {
		editProductPage.visibilityDropdown(option);
	}
	
	@Step
	public void checkCacheChechBox() {
		editProductPage.checkCacheCheckBox();
	}
	
	@Step
	public void clickSave() {
		editProductPage.pressSaveButton();
	}
	
	@Step
	public void clickReset() {
		editProductPage.pressResetButton();
	}
	
	@Step
	public void clickClose() {
		editProductPage.pressCloseButton();
	}
	
	@Step
    public void checkSaveButton(String message){
    	editProductPage.checkSaveButton(message);
    }
	
	
}
