package com.framework.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.framework.listeners.LogListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.framework" }, monochrome = true, plugin = {
		"json:reports/cucumber.json", "html:reports/cucumber-report.html" })
@Listeners(LogListener.class)
public class ApplicationTest extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
