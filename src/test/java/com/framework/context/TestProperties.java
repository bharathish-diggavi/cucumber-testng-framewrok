package com.framework.context;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.framework.util.LoggerUtil;

/**
 * The Class has all TestProperties (All properties mentioned in
 * <strong>test.properties</strong> file).
 *
 * @author Bharathish
 */
public class TestProperties {

	/** The Constant props. */
	private static final Properties props = new Properties();

	/**
	 * Load all propertie.
	 */
	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
			props.load(Locator);
		} catch (IOException e) {
			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @param defaultValue is the default value
	 * @return the property
	 */
	public static String getOrDefault(String key, String defaultValue) {
		return (String) props.getOrDefault(key, defaultValue);
	}

	/**
	 * Put property.
	 *
	 * @param key   the key
	 * @param value the value
	 */
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
}
