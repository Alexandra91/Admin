package com.steps.AdminPanel;

import com.pages.AdminPanel.LogInPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class LogInSteps extends ScenarioSteps {

	
	private static final long serialVersionUID = 5812673539494620585L;
	LogInPage adminLogIn;

	@Step
	public void navigateTo(String URL) {
		adminLogIn.navigateTo(URL);
	}

	@Step
	public void user(String keyword) {
		adminLogIn.enter_user(keyword);
	}

	@Step
	public void password(String keyword) {
		adminLogIn.enter_pass(keyword);
	}

	@Step
	public void connect() {
		adminLogIn.press_login();
	}
	
	@Step
	public void checkPageText(String text) {
		adminLogIn.checkPageText(text);
	}

	@StepGroup
	public void login_magentoAdmin(String user, String pass) {
		user(user);
		password(pass);
		connect();
	}


}
