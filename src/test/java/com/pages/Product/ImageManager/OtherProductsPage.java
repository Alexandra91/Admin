package com.pages.Product.ImageManager;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OtherProductsPage extends AbstractPage {

	@FindBy(css = "div.no-picture-products")
	private WebElementFacade otherProductLink;
	
	@FindBy(css="div.product-shop div.product-name>span")
	private WebElement productName;

	public int getSizeOtherProducts() {
		List<WebElement> otherProductsList = getDriver().findElements(By.cssSelector("div.no-picture-products"));
		return otherProductsList.size();
	}

	public String manageRandomLink() {
		String link = "";
		if (otherProductLink.isVisible()) {
			List<WebElement> otherProductsList = getDriver().findElements(By.cssSelector("div.no-picture-products>a"));
			Random r = new Random();
			int randomValue = r.nextInt((otherProductsList.size() - 1) + 1) ;
			System.out.println("Random value:"+randomValue);

			otherProductsList.get(randomValue).click();
			link = otherProductsList.get(randomValue).getAttribute("href");
			 System.out.println("Actual link:"+link);
		} else {
			Assert.assertTrue("No link is displayed", otherProductLink.isVisible());
		}
		return link;
       	}
	
	public String getUrlLink(){
		return getDriver().getCurrentUrl();
		
		}
	
	

}
