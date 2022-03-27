package br.com.tcc.wdmdominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.tcc.wdmdominio.entity.enums.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_contato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @Column(name = "contato_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tipo;
    private String contato;
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Operador operador;

    public TipoContato getTipo() {
		return TipoContato.toEnum(tipo);
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo.getCod();
	}
}
