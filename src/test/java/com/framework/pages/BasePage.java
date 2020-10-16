package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.framework.context.WebDriverContext;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @author Bharathish
 */
public class BasePage {

	/** The driver. */
	protected WebDriver driver;

	/** The waiter. */
	protected FluentWait<WebDriver> waiter;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	public BasePage() {
		super();
		this.driver = WebDriverContext.getDriver();
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}

}
