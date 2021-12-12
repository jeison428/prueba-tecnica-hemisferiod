package co.com.hemisferiod.app.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class PruebaTecnicaHemisferiodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaHemisferiodApplication.class, args);
	}

}
