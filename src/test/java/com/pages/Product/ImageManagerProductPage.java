package com.pages.Product;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tools.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ImageManagerProductPage extends AbstractPage {
	
	@FindBy(css=".desktop-template a[data-fragment='imagemanager']")
	private WebElement imageManagerTab;
	
	@FindBy(css=".header-subtitle")
	private WebElement imageTabDescription;
	
	@FindBy(css="div.browse-holder .browse-button.browse-picturesText")
	private WebElement browseButton;
	
    @FindBy(css="#close-button")   
    private WebElement closeButton;
    
    @FindBy(id="image-cache")
    private WebElement cacheCheckbox;
    
    @FindBy(css="div#picture-container>div:nth-child(1) div#desktop-buttons div.image-container>img")
    private WebElement pictureContainer;
    
    @FindBy(css = "div#picture-container>div:nth-child(1) div.pictureHolder")
    private WebElementFacade imageButton;
    
   private static final String NthImage = "div#picture-container div:nth-child(randomValue) div#desktop-buttons div.buttons-holder button";
    public void clickImageTab(){
    	element(imageManagerTab).waitUntilVisible();
    	imageManagerTab.click();
    }
    
  public void clickBrowse(){
	  element(browseButton).waitUntilVisible();
	  browseButton.click();
  }
  public void uploadImage(String keyword){
	  WebElement element= getDriver().findElement(By.name("image"));
	  element.sendKeys(keyword);
  }
    
  public void manageImage(String name){
	  if(imageButton.isVisible()){
		  Actions builder = new Actions(getDriver());
		  builder.moveToElement(pictureContainer).perform();
		  
		  List<WebElement> buttonList = getDriver()
					.findElements(By.cssSelector("div#desktop-buttons div.buttons-holder button"));
		  
		  for (WebElement webElement : buttonList) {
				System.out.println("button:" + webElement.getAttribute("class") );
				
				if (webElement.getAttribute("class").contains(name)) {

			        webElement.click();
					waitABit(3000);
					break;

				}
			}
		}else{
			Assert.assertTrue("No image is displayed", imageButton.isVisible());
		}
	   
	  
  }
  
  
  
//	public void managerandomImage(String name) {
//		if(imageButton.isVisible()){
//		
//		List<WebElement> picturesList= getDriver().findElements(By.cssSelector("div#desktop-buttons div.image-container img"));
//		Random r = new Random();
//		int randomValue = r.nextInt(picturesList.size()); 
//		System.out.println(picturesList.size());
//		System.out.println("Random value:" +randomValue);
//		
//		Actions builder = new Actions(getDriver());
//		//builder.moveToElement(pictureContainer).perform();
//		builder.moveToElement(picturesList.get(randomValue)).perform();
//		String newValue = Integer.toString(randomValue);
//		System.out.println(" Integer.toString(randomValue):" + newValue);
//		
//		List<WebElement> buttonList = getDriver()
//				.findElements(By.cssSelector(NthImage.replace("randomValue", newValue)));
//		
//		System.out.println("Buttons list:" + buttonList.size());
//		
//		for (WebElement webElement : buttonList) {
//			System.out.println("button:" + webElement.getAttribute("class") );
//			
//			if (webElement.getAttribute("class").contains(name)) {
//
//		        webElement.click();
//				waitABit(3000);
//				break;
//
//			}
//		}
//	}else{
//		Assert.assertTrue("No image is displayed", imageButton.isVisible());
//	}
//    
//}
	}
