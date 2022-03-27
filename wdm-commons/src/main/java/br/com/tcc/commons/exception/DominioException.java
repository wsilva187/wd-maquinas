package br.com.tcc.commons.exception;

public class DominioException extends WdmException {

	private static final long serialVersionUID = 401472172988916357L;

	public DominioException() {
		super();
	}

	public DominioException(String message,Throwable cause) {
		super(message,cause);
	}

	public DominioException(String message) {
		super(message);
	}

	public DominioException(Throwable cause) {
		super(cause);
	}

}
