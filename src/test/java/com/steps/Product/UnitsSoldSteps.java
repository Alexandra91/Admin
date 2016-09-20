package com.steps.Product;

import com.pages.Product.UnitsSold.UnitsSoldPage;
import com.tools.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class UnitsSoldSteps extends AbstractSteps  {

	private static final long serialVersionUID = 1L;
	public UnitsSoldPage unitsSoldPage;
	
	@Step
	public void clickUnitsSoldTab(){
		unitsSoldPage.clickUnitsSoldTab();
	}
	
	public String getNumberOfUnits(){
		System.out.println(unitsSoldPage.getNumberUnits());
		return unitsSoldPage.getNumberUnits();
	}
	
	@Step
	public void selectAnOption()
	{ unitsSoldPage.selectOptionDropDown();
			}
	
	@Step
	public void clickGenerateGraph(){
		unitsSoldPage.clickGenerateButton();
	}
	
	@Step
	public void verifyChart(){
		unitsSoldPage.verifyChart();
	}
	
	@Step
	public void clickDropDownDefaultOption(){
		unitsSoldPage.clickDefaultOption();
	}
	
//	@Step
//	public String getTimeValues(){
//		System.out.println(unitsSoldPage.getTimeValues());
//		return unitsSoldPage.getTimeValues();
//	}
}
