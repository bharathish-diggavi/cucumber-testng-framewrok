package com.framework.hooks;

import com.framework.context.WebDriverContext;
import com.framework.util.BrowserUtil;
import com.framework.util.LoggerUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class BrowserHook {

	@Before
	public void before(Scenario scenario) {
		System.out.println("Inside before");
		WebDriverContext.createBrowser();
		LoggerUtil.log(scenario.getName() + " : Started");
	}

	@After
	public void closeBrowser(Scenario scenario) {
		Status status = scenario.getStatus();
		if (status.equals(Status.PASSED)) {
			LoggerUtil.log(scenario.getName() + " : Passed");
			scenario.attach(BrowserUtil.takeBase64ScreenShot(), "image/png", "screenshot");
		} else if (status.equals(Status.FAILED)) {
			scenario.attach(BrowserUtil.takeBase64ScreenShot(), "image/png", "screenshot");
			LoggerUtil.log(scenario.getName() + " : Failed");

		} else if (status.equals(Status.SKIPPED))
			LoggerUtil.log(scenario.getName() + " : Skipped");
		else if (status.equals(Status.AMBIGUOUS))
			LoggerUtil.log(scenario.getName() + " : Something went erong");

		WebDriverContext.removeDriver();
	}

}
