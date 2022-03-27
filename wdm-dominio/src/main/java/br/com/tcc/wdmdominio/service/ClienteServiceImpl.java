package br.com.tcc.wdmdominio.service;

import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.wdmdominio.entity.Cliente;
import br.com.tcc.wdmdominio.repository.ClienteRepository;
import br.com.tcc.wdmservicosintapi.dto.ClienteDTO;
import br.com.tcc.wdmservicosintapi.dto.ClientePageDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente salvarCliente(Cliente cliente) throws WdmException {
        log.info("Preparando para salvar cliente [{}]", cliente);

        return repository.save(cliente);
    }

    @Override
    public Cliente buscaClientePorId(Long id) throws WdmException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Cliente> searchSaleByFilter(Pageable pageable, Cliente filter) throws WdmException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<ClientePageDTO> findAll(Pageable pageable) throws WdmException {
        try {
        return repository.findAll(pageable).map(cliente -> ClientePageDTO.builder()
                                                                        .id(cliente.getId())
                                                                        .fantasia(cliente.getFantasia())
                                                                        .qtdEquipamento(cliente.getEquipamentos().size())
                                                                        .divida(0D)
                                                                        .premio(0D)
                                                                        .cheque(0D)
                                                                        .build());
        }catch(Exception e){
            log.warn("Erro ao buscar cliente, erro:", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Cliente fromDto(ClienteDTO clienteDTO) throws WdmException {
        // TODO adicionar id login em atualizadopor e
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        return cliente;
    }

}