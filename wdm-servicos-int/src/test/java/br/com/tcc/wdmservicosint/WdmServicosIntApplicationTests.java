package br.com.tcc.wdmservicosint;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = { "br.com.tcc" })
@EntityScan(basePackages = "br.com.tcc.wdmdominio")
@EnableJpaRepositories(basePackages = "br.com.tcc.wdmdominio")
@SpringBootTest
class WdmServicosIntApplicationTests {



}
