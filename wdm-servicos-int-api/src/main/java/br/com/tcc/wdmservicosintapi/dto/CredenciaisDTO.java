package br.com.tcc.wdmservicosintapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
}
