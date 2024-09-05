package com.hoteis.hoteis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hoteis.hoteis.models.Hotel;
import com.hoteis.hoteis.repository.HotelRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hoteis", version = "1", description = "API desenvolvida para cadastros de hoteis"))
public class HoteisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoteisApplication.class, args);
	}

	@Bean
	public CommandLineRunner inicializador(@Autowired HotelRepository hotelRepository){
		return argumento -> {

			Hotel hotel1 = new Hotel();
			hotel1.setNome("Hotelzinho");
			hotel1.setCidade("Sorocaba");
			hotel1.setEstado("São Paulo");
			hotel1.setDiaria(140.20);
			hotel1.setEstrelas(4.3);

			hotelRepository.save(hotel1);

			Hotel hotel2 = new Hotel();
			hotel2.setNome("Hotel médio");
			hotel2.setCidade("Rio de Janeiro");
			hotel2.setEstado("Rio de Janeiro");
			hotel2.setDiaria(200.30);
			hotel2.setEstrelas(5.0);

			hotelRepository.save(hotel2);

			Hotel hotel3 = new Hotel();
			hotel3.setNome("Hotelzão");
			hotel3.setCidade("Osasco");
			hotel3.setEstado("São Paulo");
			hotel3.setDiaria(60.90);
			hotel3.setEstrelas(3.2);

			hotelRepository.save(hotel3);
		};
	}

}
