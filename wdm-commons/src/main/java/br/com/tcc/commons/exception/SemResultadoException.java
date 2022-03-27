package br.com.tcc.commons.exception;

public class SemResultadoException extends WdmException {

	private static final long serialVersionUID = 7573776262756782934L;

	public SemResultadoException() {
		super();
	}

	public SemResultadoException(String message,Throwable cause) {
		super(message,cause);
	}

	public SemResultadoException(String message) {
		super(message);
	}

	public SemResultadoException(Throwable cause) {
		super(cause);
	}

}
