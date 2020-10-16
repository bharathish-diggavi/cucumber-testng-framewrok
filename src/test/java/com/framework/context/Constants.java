package com.framework.context;

/**
 * The Class is for Constants.
 *
 * @author Bharathish
 */
public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";

	/** The Constant CHROME_DRIVER_PATH. */
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
	
	/** The Constant GECKO_DRIVER_PATH. */
	public final static String GECKO_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/geckodriver.exe";
}
