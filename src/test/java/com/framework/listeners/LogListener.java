package com.framework.listeners;

import org.apache.log4j.pattern.LogEvent;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.util.LoggerUtil;

/**
 * The listener interface for receiving log events. The class that is interested
 * in processing a log event implements this interface, and the object created
 * with that class is registered with a component using the component's
 * <code>addLogListener<code> method. When the log event occurs, that object's
 * appropriate method is invoked.
 *
 * @see LogEvent
 */
public class LogListener implements ITestListener {

	/**
	 * Gets the test name.
	 *
	 * @param result the result
	 * @return the test name
	 */
	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	/**
	 * Gets the test description.
	 *
	 * @param result the result
	 * @return the test description
	 */
	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		LoggerUtil.getLogger().fatal(getTestName(result) + " : Test Failed : " + cause);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		LoggerUtil.log("=======================================================================");
	}

	@Override
	public void onFinish(ITestContext context) {
		LoggerUtil.log("=======================================================================");
	}

}
