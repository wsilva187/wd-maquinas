package br.com.tcc.wdmservicosint.security;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tcc.commons.exception.SemResultadoException;
import br.com.tcc.wdmdominio.entity.Cliente;
import br.com.tcc.wdmdominio.repository.ClienteRepository;
import br.com.tcc.wdmdominio.service.EmailService;

@Service
public class AutenticacaoService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) throws SemResultadoException {
		
		Cliente cliente = clienteRepository.findById(1L).get();
		if (cliente == null) {
			throw new SemResultadoException("Email não encontrado");
		}
		
		String newPass = newPassword();
		//cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
