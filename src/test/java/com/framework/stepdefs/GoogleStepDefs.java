package com.framework.stepdefs;

import com.framework.context.WebDriverContext;
import com.framework.pages.GooglePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDefs {

	@Given("I go to google page")
	public void i_go_to_google_page() {
		WebDriverContext.getDriver().get("https://www.google.co.in/");
		System.out.println("Inside i_go_to_google_page");
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		new GooglePage().searchText(string);
		System.out.println("Inside i_search_for");
	}

	@Then("I should get results for {string}")
	public void i_should_get_results_for(String string) {
		System.out.println("Inside i_should_get_results_for");
		new GooglePage().veriFySearchResultPage(string);
	}
}
