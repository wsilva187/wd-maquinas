package br.com.tcc.wdmdominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.wdmdominio.entity.Equipamento;
import br.com.tcc.wdmdominio.repository.EquipamentoRepository;

public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public List<Equipamento> buscarEquipamentoPorCliente(Long idCliente) throws WdmException {
        return equipamentoRepository.findByCliente(idCliente);
    }
    
}
