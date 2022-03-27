package br.com.tcc.commons.validacao;


import java.text.MessageFormat;

import org.apache.commons.lang3.builder.Builder;

public class MensagemValidacaoBuilder implements Builder<MensagemValidacao> {

	private String campo;
	private String mensagem;
	private boolean codigo;
	private final NivelMensagem nivel;
	private Object[] valores;

	private MensagemValidacaoBuilder(NivelMensagem nivel) {
		super();

		this.nivel = nivel;
	}

	public MensagemValidacaoBuilder campo(String campo) {
		this.campo = campo;
		return this;
	}

	public MensagemValidacaoBuilder mensagem(String mensagem, Object... valores) {
		this.mensagem = mensagem;
		this.valores = valores;
		return this;
	}

	public static MensagemValidacaoBuilder error() {
		return new MensagemValidacaoBuilder(NivelMensagem.ERROR);
	}

	public static MensagemValidacaoBuilder warning() {
		return new MensagemValidacaoBuilder(NivelMensagem.WARNING);
	}

	public static MensagemValidacaoBuilder info() {
		return new MensagemValidacaoBuilder(NivelMensagem.INFO);
	}

	public static MensagemValidacaoBuilder nivel(NivelMensagem nivel) {
		return new MensagemValidacaoBuilder(nivel);
	}

	public MensagemValidacaoBuilder isCodigo() {
		codigo = true;
		return this;
	}

	public MensagemValidacaoBuilder isNotCodigo() {
		codigo = false;
		return this;
	}

	@Override
	public MensagemValidacao build() {

		if (codigo) {
			return new MensagemValidacao(campo, mensagem, valores, codigo, nivel);
		} else {
			return new MensagemValidacao(campo, MessageFormat.format(mensagem, valores), codigo, nivel);
		}

	}

}
