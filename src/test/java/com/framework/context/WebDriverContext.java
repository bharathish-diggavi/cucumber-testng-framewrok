package com.framework.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Class is responsible in maintaining single instance of webdriver in any
 * given thread.
 *
 * @author Bharathish
 */
public class WebDriverContext {

	/** The driverinstance. */
	private static InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		if (driverinstance.get() == null)
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverContext.setDriver...");
		else
			return driverinstance.get();
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public static void setDriver(WebDriver driver) {
		driverinstance.set(driver);
	}

	/**
	 * Removes the driver.
	 */
	public static void removeDriver() {
		try {
			getDriver().quit();
		} catch (Exception e) {
		}
		driverinstance.remove();
	}

	public static void createBrowser() {
		WebDriver driver = null;
		String browser = TestProperties.getOrDefault("browser", "firefox");
		if ("Chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("disable-infobars");
			driver = new ChromeDriver(ops);
		} else {
			driver = new FirefoxDriver();
		}
		WebDriverContext.setDriver(driver);
	}
}
