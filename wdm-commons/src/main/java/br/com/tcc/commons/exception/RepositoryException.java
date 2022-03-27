package br.com.tcc.commons.exception;

public class RepositoryException extends WdmException {

	private static final long serialVersionUID = -4524596236479364201L;

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}

}
