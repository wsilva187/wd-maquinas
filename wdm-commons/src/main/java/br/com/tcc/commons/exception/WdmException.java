package br.com.tcc.commons.exception;

public abstract class WdmException extends Exception {

	private static final long serialVersionUID = -4720712973391487026L;

	public WdmException() {
		super();
	}

	public WdmException(String message, Throwable cause) {
		super(message, cause);
	}

	public WdmException(String message) {
		super(message);
	}

	public WdmException(Throwable cause) {
		super(cause);
	}

}
