package com.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CalendarPage extends PageObject {

	@FindBy(css = "span[class='ui-datepicker-month']")
	private WebElement calendarTitle;

	@FindBy(css = "[name='news_from_date']")
	private WebElement calendarNewFromDate;

	@FindBy(css = "[data-handler='prev']")
	private WebElement prevDate;

	@FindBy(css = "[data-handler='next']")
	private WebElement nextDate;

	@FindBy(css = "[name='news_to_date']")
	private WebElement calendarNewToDate;

	
	public void setDate(int month, int day, int year) throws ParseException {

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse(String.valueOf(day)+"/" + String.valueOf(month) + "/" + String.valueOf(year)));

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

		List<WebElement> days = getDriver().findElements(By.cssSelector("[class='ui-state-default']"));
		for (WebElement currentDay : days) {
			if (currentDay.getText().toLowerCase().equals(String.valueOf(day).toLowerCase()))currentDay.click();
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
}
