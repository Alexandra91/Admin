package com.steps.Product;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.Product.EditProductPage;

public class EditProductSteps extends ScenarioSteps {

	private static final long serialVersionUID = 2225949172202746779L;
	EditProductPage editProductSteps;
	
	@Step
	public void clickEditProduct() {
		editProductSteps.pressEditProductTab();
	}
	@Step
	public void clickSKU() {
		editProductSteps.pressSKUlink();
	}
	
	@Step
	public void enterNameField(String keyword) {
		editProductSteps.fillNameField(keyword);
	}

	@Step
	public void enterDescription(String keyword) {
		editProductSteps.fillDescriptionField(keyword);
	}

	@Step
	public void enterShortDescription(String keyword){
		editProductSteps.fillShortDescriptionField(keyword);
	}
	
	@Step
	public void enterURLkeyField(String keyword){
		editProductSteps.enterURLkeyField(keyword);
	}
	
	@Step
	public void startDate(int month, int day, int year) throws ParseException {
		editProductSteps.enterStartDate();
		editProductSteps.setDate(month, day, year);
	}
	
	@Step
	public void endDate(int month, int day, int year) throws ParseException {
		editProductSteps.enterEndDate();
		editProductSteps.setDate(month, day, year);
	}
	
	@Step
	public void checkCacheChechBox() {
		editProductSteps.checkCacheCheckBox();
	}
	
	@Step
	public void clickSave() {
		editProductSteps.pressSaveButton();
	}
	
	@Step
	public void clickReset() {
		editProductSteps.pressResetButton();
	}
	
	@Step
	public void clickClose() {
		editProductSteps.pressCloseButton();
	}
	
	@Step
    public void checkSaveButton(String message){
    	editProductSteps.checkSaveButton(message);
    }
	
	
}
