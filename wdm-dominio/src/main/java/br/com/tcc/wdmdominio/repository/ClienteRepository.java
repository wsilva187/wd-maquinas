package br.com.tcc.wdmdominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.wdmdominio.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
