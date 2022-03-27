package br.com.tcc.wdmdominio.entity.enums;

public enum TipoContato {
    EMAIL(1, "E-mail"),
	TELEFONE(2, "Telefone"),
	CELULAR(3, "Celular");
	
	private int cod;
	private String descricao;
	
	private TipoContato(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoContato toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoContato x : TipoContato.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

    public boolean isEmail() {
        return this.equals(TipoContato.EMAIL);
    }
}
