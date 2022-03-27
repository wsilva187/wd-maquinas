package br.com.tcc.wdmdominio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fantasia;
    private String razaoSocial;
    private String documento;
    private String inscEstadual;
    private String obs;
    private Long cadastradoPor;
    private Long atualizadoPor;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private Integer comissao;
    
    @OneToMany(mappedBy = "cliente")
    private List<Premios> premios;
    
    @OneToMany(mappedBy = "cliente")
    private List<DividasHaver> dividasHaver;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Equipamento> equipamentos;

    @OneToMany(mappedBy = "cliente")
    private List<Contato> contatos;
    
    @ManyToMany
    @JoinTable(name = "tbl_cliente_endereco", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;
    
    @ManyToMany
    @JoinTable(name = "tbl_cliente_operador", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "operador_id"))
    private List<Operador> operadores;

    public String getEmail() {
        return this.contatos.stream().filter(contato -> contato.getTipo().isEmail() && contato.isPrincipal()).findFirst().get().getContato();
    }
    
    //TODO VERIFICAR
    //private List<Comissao> comissao;
}
