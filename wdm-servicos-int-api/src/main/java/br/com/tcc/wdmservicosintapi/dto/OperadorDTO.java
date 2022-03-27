package br.com.tcc.wdmservicosintapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperadorDTO implements Serializable {
    
    private Long id;
    private String usuario;
}
