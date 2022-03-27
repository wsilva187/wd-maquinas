package br.com.tcc.wdmservicosint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.tcc.wdmdominio.service.EmailService;
import br.com.tcc.wdmdominio.service.SmtpEmailService;

@Configuration
public class InfraConfig {
    
    @Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
