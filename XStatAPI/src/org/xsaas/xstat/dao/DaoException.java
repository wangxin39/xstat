package org.xsaas.xstat.dao;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 3583566093089790852L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
}
