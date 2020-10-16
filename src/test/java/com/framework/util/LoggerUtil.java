package com.framework.util;

import org.apache.log4j.Logger;

/**
 * The Class has all Logging related utilities.
 *
 * @author Bharathish
 */
public class LoggerUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LoggerUtil.class);

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void log(String message) {
		logger.info(message);
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
