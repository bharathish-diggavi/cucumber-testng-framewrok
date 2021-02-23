package com.framework.util;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.framework.context.WebDriverContext;

public class BrowserUtil {

	private static FluentWait<WebDriver> waiter;

	public static FluentWait<WebDriver> getWaiter() {
		waiter = new FluentWait<WebDriver>(WebDriverContext.getDriver())
				.ignoring(NoSuchElementException.class, WebDriverException.class).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2));

		return waiter;

	}

	public static byte[] takeBase64ScreenShot() {
		return ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public static void waitUntilVisible(WebElement element) {
		getWaiter().until(ExpectedConditions.visibilityOf(element));
	}
}
