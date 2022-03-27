package br.com.tcc.commons.exception;

import java.util.Set;

import br.com.tcc.commons.validacao.MensagemValidacao;

public class ValidacaoException extends WdmException {

	private static final long serialVersionUID = 8864972069096125161L;
	private final Set<MensagemValidacao> mensagens;

	public ValidacaoException(String message, Throwable cause, Set<MensagemValidacao> mensagens) {
		super(message, cause);
		this.mensagens = mensagens;
	}

	public ValidacaoException(String message, Set<MensagemValidacao> mensagens) {
		this(message, null, mensagens);
	}

	public ValidacaoException(String message, Throwable cause) {
		this(message, cause, null);
	}

	public ValidacaoException(String message) {
		this(message, null, null);
	}

	public ValidacaoException(Throwable cause) {
		this(null, cause, null);
	}

	public Set<MensagemValidacao> getMensagens() {
		return mensagens;
	}

}
