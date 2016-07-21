package com.tools;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{
	
	private AbstractPage abstractPage;
	
	@Step
	public void navigateTo(String URL){
		abstractPage.navigateToURL(URL);
	}

}
