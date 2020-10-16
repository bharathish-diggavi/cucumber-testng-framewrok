# cucumber-testng-framewrok

A simple framework based on Cucumber, Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. Cucumber

Steps to create test cases:
----
Let's say we want to automate Google search test.  

1.Create googlesearch.feature in **src/test/resources/features** folder.  
  Feature file is reference for which part of the application we'll be testing. It contains **Scenario**s and **Scenario Outline**s. For more details [Click here](https://cucumber.io/docs/gherkin/reference/)
  
```
	Feature: Google Search
	
	Scenario Outline: Google Text Search Test
		Given I go to google page
		When I search for "<key>"
		Then I should get results for "<key>"
		Examples:
		|key|
		|key1|
		|key2|
```
2. Create step definition for the feature file in **GoogleStepDefs.java**

```
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
```
3. Execute scripts by running command

```
	mvn clean test
```

4. You can see logs in **logfile.log** file
5. You can see reports in **reports** folder

Framework Features
---
By default framework executes scenarios in parallel.If it is not required, change following in **ApplicationTest.java**

```
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
```