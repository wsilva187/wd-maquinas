package br.com.tcc.wdmservicosintapi.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientePageDTO implements Serializable {
    private Long id;
    private String fantasia;
    private Integer qtdEquipamento;
    private Double divida;
    private Double premio;
    private Double cheque;
    
}
