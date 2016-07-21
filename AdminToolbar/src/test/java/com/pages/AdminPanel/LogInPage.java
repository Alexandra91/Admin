package com.pages.AdminPanel;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LogInPage extends PageObject {
		
	    @FindBy(css ="[id='username']")
	    private WebElementFacade loginUser;
	    
	    @FindBy(css="[id='login']")
	    private WebElementFacade loginPass;

	    @FindBy(css="input[title='Login']")
	    private WebElement loginButton;
	    
	    @FindBy(css="div.middle [class='head-dashboard']")
	    private WebElement pageText;
	        
	    @FindBy(css ="img[class='logo']")
	    private WebElement accountLogo;
    
	    public void enter_user(String keyword) {
	        loginUser.type(keyword);
	    }
	    public void enter_pass(String keyword) {
	        loginPass.type(keyword);
	    }

	    public void press_login() {
	        loginButton.click();
	    }
	    
		public void navigateTo(String URL) {
			getDriver().get(URL);
		}
		
	    public void checkPageText(String text){
	    	waitABit(2000);
	    	boolean found= false;
	    	element(pageText).waitUntilVisible();
	    	if(pageText.getText().contains(text)){
	    		found=true;
	    		System.out.println(pageText.getText());
	    	}
	    	Assert.assertTrue("Text doesn't match", found);
	    }
	    
}
