package br.com.tcc.wdmdominio.service;

import java.util.List;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.wdmdominio.entity.Equipamento;

public interface EquipamentoService {

    public List<Equipamento> buscarEquipamentoPorCliente(Long idCliente) throws WdmException;

}