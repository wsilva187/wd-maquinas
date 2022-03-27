package br.com.tcc.commons.exception;

public class TokenUtilizadoException extends WdmException {

	private static final long serialVersionUID = -2168136340237897913L;

	public TokenUtilizadoException() {
		super();
	}

	public TokenUtilizadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TokenUtilizadoException(String message) {
		super(message);
	}

	public TokenUtilizadoException(Throwable cause) {
		super(cause);
	}
}
