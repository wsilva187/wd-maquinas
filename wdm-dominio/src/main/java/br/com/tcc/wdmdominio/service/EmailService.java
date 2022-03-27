package br.com.tcc.wdmdominio.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.tcc.wdmdominio.entity.Cliente;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
