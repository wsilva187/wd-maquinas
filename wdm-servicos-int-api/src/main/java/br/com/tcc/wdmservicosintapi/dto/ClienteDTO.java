package br.com.tcc.wdmservicosintapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable{

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
    private List<PremiosDTO> premios = new ArrayList<>();
    private List<DividasHaverDTO> dividasHaver = new ArrayList<>();
    private List<MaquinaDTO> maquinas = new ArrayList<>();
    private List<EnderecoDTO> enderecos = new ArrayList<>();
    private List<OperadorDTO> operadores = new ArrayList<>();
    private List<ContatoDTO> contatos = new ArrayList<>();
    
}