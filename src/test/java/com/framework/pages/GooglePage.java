package com.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.context.WebDriverContext;
import com.framework.util.BrowserUtil;

public class GooglePage extends BasePage {

	@FindBy(name = "q")
	private WebElement searchinput;

	@FindBy(id = "appbar")
	private WebElement appBar;

	public void searchText(String key) {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].style.border = \"thick solid #0000FF\"", searchinput);
		searchinput.sendKeys(key);
		searchinput.submit();
	}

	public void veriFySearchResultPage(String key) {
		BrowserUtil.waitUntilVisible(appBar);
		Assert.assertTrue(WebDriverContext.getDriver().getTitle().contains(key));
	}
}
