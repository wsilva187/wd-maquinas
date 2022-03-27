package br.com.tcc.wdmservicosint.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.commons.exception.SemResultadoException;
import br.com.tcc.wdmservicosint.security.AutenticacaoService;
import br.com.tcc.wdmservicosint.security.JWTUtil;
import br.com.tcc.wdmservicosint.security.UserSS;
import br.com.tcc.wdmservicosint.security.UserService;
import br.com.tcc.wdmservicosintapi.dto.EmailDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class AutencicacaoController {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AutenticacaoService service;

	@ApiOperation("Login.")
	@PostMapping("/login")
	public void fakeLogin(@ApiParam("Usuário") @RequestParam String usuario,
			@ApiParam("Senha") @RequestParam String senha) {
		throw new IllegalStateException(
				"Este método não deve ser chamado. É implementado por filtros Spring Security.");
	}

	@ApiOperation("Logout.")
	@PostMapping("/logout")
	public void fakeLogout() {
		throw new IllegalStateException(
				"Este método não deve ser chamado. É implementado por filtros Spring Security.");
	}

	@RequestMapping(value = "/auth/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/auth/forgot", method = RequestMethod.POST)// todo - corrigir throws
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) throws SemResultadoException {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}
}
