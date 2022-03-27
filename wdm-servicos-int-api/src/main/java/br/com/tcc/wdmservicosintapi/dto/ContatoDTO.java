package br.com.tcc.wdmservicosintapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO implements Serializable {

    private Long id;
    private TipoContatoDTO tipo;
    @Builder.Default
    private List<ClienteDTO> clientes = new ArrayList<>();
}
