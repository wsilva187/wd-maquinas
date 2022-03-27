package br.com.tcc.commons.exception;

public class TokenInvalidoException extends WdmException {

	private static final long serialVersionUID = -2058808980840943630L;

	public TokenInvalidoException() {
		super();
	}

	public TokenInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TokenInvalidoException(String message) {
		super(message);
	}

	public TokenInvalidoException(Throwable cause) {
		super(cause);
	}
}
