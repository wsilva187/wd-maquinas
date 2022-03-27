package br.com.tcc.wdmservicosint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.tcc" })
@EntityScan(basePackages = "br.com.tcc.wdmdominio")
@EnableJpaRepositories(basePackages = "br.com.tcc.wdmdominio")
public class WdmServicosIntApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdmServicosIntApplication.class, args);
	}

}
