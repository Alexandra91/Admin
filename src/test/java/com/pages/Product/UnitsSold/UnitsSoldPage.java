package com.pages.Product.UnitsSold;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class UnitsSoldPage extends AbstractPage {

	@FindBy(css="div.desktop-template div.toolbar-item a[data-fragment='unitssold']")
	private WebElement unitsSoldTab;
	
	@FindBy(css="div.total-units p")
	private WebElement numberUnitsSold;
	
	@FindBy(css="button#generate-btn")
	private WebElement generateGraphButton;
	
	@FindBy(css="table.history-holder>tbody")
	private WebElement historyTable;
	
	@FindBy(css="div.canvasjs-chart-container")
	private WebElement chart;
	
	@FindBy(css="p#dropdownMenu1")
	private WebElement dropDownOptionDefault;
	
		
	public void clickUnitsSoldTab(){
		element(unitsSoldTab).waitUntilVisible();
		unitsSoldTab.click();
	}
	
	public String getNumberUnits(){
		element(numberUnitsSold).waitUntilVisible();
		return numberUnitsSold.getText();
	}
	
	public void clickGenerateButton(){
		element(generateGraphButton).waitUntilVisible();
		generateGraphButton.click();
	}
	
	public void selectOptionDropDown(){
		
		List<WebElement> dropDownList = getDriver().findElements(By.cssSelector("ul.dropdown-menu>li"));
		Random r=new Random();
		int randomValue=r.nextInt((dropDownList.size()-1)+1)+1;
		
		dropDownList.get(randomValue).click();
			
		
	}
	
	public void verifyChart(){
		if(chart.isDisplayed()){
			System.out.println("The chart was generated!");
		}
		else{
			System.out.println("The chart wasn/t displayed !");
		}
	}
	
	public void clickDefaultOption(){
		element(dropDownOptionDefault).waitUntilVisible();
		dropDownOptionDefault.click();
	}
	
//	public void getTimeValues(){
//		String time="";
//		List<WebElement>quantityList=historyTable.findElements(By.cssSelector("tr:nth-child(2) td:nth-child(2)"));
//		List<WebElement> timeList= historyTable.findElements(By.cssSelector("tr:nth-child(2) td:first-child>p"));
//		for (WebElement webElement : quantityList) {
//			time= webElement.getText();
//		}
//		
//	}
	
}
