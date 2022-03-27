package br.com.tcc.wdmdominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.wdmdominio.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByCliente(Long idCliente);
}
