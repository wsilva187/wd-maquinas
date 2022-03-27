package br.com.tcc.commons.validacao;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class MensagemValidacao {

	private final String campo;
	private final String mensagem;
	private final boolean codigo;
	private final NivelMensagem nivel;
	private final Object[] valores;

	public MensagemValidacao(String campo,String mensagem,Object[] valores,boolean codigo,NivelMensagem nivel) {
		super();

		this.campo = campo;
		this.valores = valores;
		this.mensagem = mensagem;
		this.codigo = codigo;
		this.nivel = nivel;
	}

	public MensagemValidacao(String campo,String mensagem,boolean codigo,NivelMensagem nivel) {
		this(campo,mensagem,new Object[]{},codigo,nivel);
	}

	public MensagemValidacao(String mensagem,boolean codigo,NivelMensagem nivel) {
		this(null,mensagem,codigo,nivel);
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public boolean isCodigo() {
		return codigo;
	}

	public NivelMensagem getNivel() {
		return nivel;
	}

	public boolean hasCampo() {
		return StringUtils.isNotEmpty(campo);
	}

	@Override
	public String toString() {
		return "MensagemValidacao [campo=" + campo + ", mensagem=" + mensagem + ", codigo=" + codigo + ", nivel=" + nivel + ", valores=" + Arrays.toString(valores) + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		MensagemValidacao t = (MensagemValidacao) obj;

		return new EqualsBuilder().append(campo,t.campo).append(mensagem,t.mensagem).append(codigo,t.codigo).append(nivel,t.nivel).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(campo).append(mensagem).append(codigo).append(nivel).toHashCode();
	}

	public MensagemValidacao addPrefixo(String prefixo) {
		return new MensagemValidacao(prefixo + "." + campo,mensagem,codigo,nivel);
	}

	public Object[] getValores() {
		return valores;
	}

}
