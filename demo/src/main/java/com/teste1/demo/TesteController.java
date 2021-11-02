package com.teste1.demo;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/")
public class TesteController {
	@GetMapping("/teste")
	public void gerarMv(){
		Logger logger = org.slf4j.LoggerFactory.getLogger(DemoApplication.class);

		logger.info("Inicia teste");
		new JdbcConexao().getConexao();
		logger.info("Final teste");
	}
}
