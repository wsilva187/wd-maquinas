package br.com.tcc.wdmservicosint.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tcc.wdmdominio.entity.Operador;
import br.com.tcc.wdmdominio.repository.OperadorRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String USUARIO_NAO_ENCONTRADO = "warn.usuario.nao.encontrado";

	@Autowired
	private OperadorRepository operadorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		log.info("[UserDetailsServiceImpl]-[loadUserByUsername]");
		Operador operador = operadorRepository.findByUsuario(usuario).orElseThrow(()-> new UsernameNotFoundException(USUARIO_NAO_ENCONTRADO));
		return new UserSS(operador.getId(), operador.getUsuario(), operador.getSenha(), operador.getPerfis());
	}
}
