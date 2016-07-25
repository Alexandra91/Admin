package com.tools;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{
	
	private static final long serialVersionUID = 1L;
	private AbstractPage abstractPage;
	
	@Step
	public void navigateTo(String URL){
		abstractPage.navigateToURL(URL);
	}
	
	@Step
	public String switchToNewestOpenedTab(){
		return abstractPage.switchToNewestOpenedTab();
	}

}
