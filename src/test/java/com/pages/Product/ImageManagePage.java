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

public class ImageManagePage extends AbstractPage {
	
	@FindBy(css=".desktop-template a[data-fragment='imagemanager']")
	private WebElement imageManagerTab;
	
		
    @FindBy(css="#close-button")   
    private WebElement closeButton;
           
    @FindBy(css = "div#picture-container>div:nth-child(1) div.pictureHolder")
    private WebElementFacade imageButton;
    
    private static final String NthImage = "div#picture-container div:nth-child(randomValue) div#desktop-buttons div.buttons-holder button";
    
    @FindBy(css="div#success>ul li.successmsg>ul li span#successMessage")
    private WebElement successMessage;
    
    @FindBy(css=" #success>ul li span:nth-child(3)")
    private WebElement closeButtonMessage;
            
    
   public void clickImageTab(){
    	element(imageManagerTab).waitUntilVisible();
    	imageManagerTab.click();
    }
    
 
    public String getSuccessMessage(){
    	element(successMessage).waitUntilVisible();
    	return successMessage.getText();
    	
    }
    
	public void managerandomImage(String name) {
		if(imageButton.isVisible()){
		
		List<WebElement> picturesList= getDriver().findElements(By.cssSelector("div#desktop-buttons div.image-container img"));
		
		Random r = new Random();
		int randomValue = r.nextInt((picturesList.size()-1)+1)+1; 
				
		Actions builder = new Actions(getDriver());
		builder.moveToElement(picturesList.get(randomValue-1)).perform();
		String newValue = Integer.toString(randomValue);
		
		
		List<WebElement> buttonList = getDriver()
				.findElements(By.cssSelector(NthImage.replace("randomValue", newValue)));
		
			for (WebElement webElement : buttonList) {
						
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
	public void clickCloseMessageButton(){
		element(closeButtonMessage).waitUntilVisible();
		closeButtonMessage.click();
	}
	
	public void clickCloseLink(){
		element(closeButton).waitUntilVisible();
		closeButton.click();
	}
	}
