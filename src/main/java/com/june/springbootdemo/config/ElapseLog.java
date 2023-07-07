package com.june.springbootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElapseLog {

	private final Logger logger;

	private ElapseLog(final Logger l) {
		this.logger = l;
	}

	public final static ElapseLog getLog(final Class<? extends Object> clazz) {
		final Logger logger = LoggerFactory.getLogger(clazz);
		final ElapseLog returnValue = new ElapseLog(logger);
		return returnValue;
	}

	public final static ElapseLog getLog(final String clazz) {
		final Logger logger = LoggerFactory.getLogger(clazz);
		final ElapseLog returnValue = new ElapseLog(logger);
		return returnValue;
	}

	public boolean isTraceEnabled() {
		return this.logger.isTraceEnabled();
	}

	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	public final LogContext enter(final String message, final Object... params) {
		LogContext returnValue = null;

		if (this.logger.isTraceEnabled()) {
			returnValue = new LogContext();
			returnValue.setMethodEntryTime(System.currentTimeMillis());

			final String statement = format(message, params);
			this.logger.trace("[ENTER] - {}", statement);
		}

		return returnValue;
	}

	public final void exit(final LogContext traceContext, final String message, final Object... params) {

		if (this.logger.isTraceEnabled()) {
			final long difference = System.currentTimeMillis() - traceContext.getMethodEntryTime();
			final String statement = format(message, params);
			this.logger.trace("[EXIT] - [{}ms] - {}", difference, statement);
		}
	}

	public final void usage(final String message, final Object... params) {
		if (this.logger.isInfoEnabled()) {
			final String statement = format(message, params);
			this.logger.info("[USAGE] - {}", statement);
		}
	}

	public final void info(final String message, final Object... params) {
		if (this.logger.isInfoEnabled()) {
			final String statement = format(message, params);
			this.logger.info(statement);
		}
	}

	public final void debug(final String message, final Object... params) {
		if (this.logger.isDebugEnabled()) {
			final String statement = format(message, params);
			this.logger.debug(statement);
		}
	}

	public final void error(final Throwable exception, final String message, final Object... params) {
		final String statement = format(message, params);
		this.logger.error(String.format("[%s] - %s", this.logger.getName(), statement), exception);
	}

	public final void error(final String message, final Throwable exception) {
		this.logger.error(String.format("[%s] - %s", this.logger.getName(), message), exception);
	}

	public final void error(final Throwable exception) {
		this.logger.error(String.format("[%s] - %s", this.logger.getName(), exception.getMessage()), exception);
	}

	public final void error(final String message, final Object... params) {
		final String statement = format(message, params);
		this.logger.error(String.format("[%s] - %s", this.logger.getName(), statement));
	}

	private final static String format(final String message, final Object... params) {
		if ((params == null) || (params.length == 0)) {
			return message;
		}
		final String statement = String.format(message, params);
		return statement;
	}
}
