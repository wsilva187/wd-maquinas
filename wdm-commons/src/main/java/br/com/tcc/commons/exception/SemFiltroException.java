package br.com.tcc.commons.exception;

public class SemFiltroException extends WdmException {

	private static final long serialVersionUID = -327090499245753188L;

	public SemFiltroException() {
		super();
	}

	public SemFiltroException(String message,Throwable cause) {
		super(message,cause);
	}

	public SemFiltroException(String message) {
		super(message);
	}

	public SemFiltroException(Throwable cause) {
		super(cause);
	}

}
