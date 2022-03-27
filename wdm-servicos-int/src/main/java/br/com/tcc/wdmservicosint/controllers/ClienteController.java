package br.com.tcc.wdmservicosint.controllers;

import java.net.URI;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.wdmdominio.entity.Cliente;
import br.com.tcc.wdmdominio.service.ClienteService;
import br.com.tcc.wdmservicosintapi.dto.ClienteDTO;
import br.com.tcc.wdmservicosintapi.dto.ClientePageDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/insert")
    public ResponseEntity<Void> salvarCliente(@Validated @RequestBody ClienteDTO clienteDTO) throws WdmException {
        Cliente cliente = clienteService.salvarCliente(clienteService.fromDto(clienteDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<ClientePageDTO>> findAll(Pageable pageable) throws WdmException {
        Page<ClientePageDTO> clientes =  clienteService.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> teste() throws WdmException {
        log.info("OKOK");
        return ResponseEntity.ok("OK");
    }
	
}
