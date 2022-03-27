package br.com.tcc.wdmdominio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.wdmdominio.entity.Cliente;
import br.com.tcc.wdmservicosintapi.dto.ClienteDTO;
import br.com.tcc.wdmservicosintapi.dto.ClientePageDTO;

public interface ClienteService {

    Cliente salvarCliente(Cliente cliente) throws WdmException;

    Cliente buscaClientePorId(Long id) throws WdmException;

    Page<Cliente> searchSaleByFilter(Pageable pageable, Cliente filter)throws WdmException;

    Cliente fromDto(ClienteDTO clienteDTO) throws WdmException;

    Page<ClientePageDTO> findAll(Pageable pageable) throws WdmException;
}