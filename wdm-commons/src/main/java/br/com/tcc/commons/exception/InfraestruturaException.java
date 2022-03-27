package br.com.tcc.commons.exception;

public class InfraestruturaException extends WdmException {

	private static final long serialVersionUID = 4829560945222092514L;

	public InfraestruturaException() {
		super();
	}

	public InfraestruturaException(String message,Throwable cause) {
		super(message,cause);
	}

	public InfraestruturaException(String message) {
		super(message);
	}

	public InfraestruturaException(Throwable cause) {
		super(cause);
	}

}
