package com.Grupo2.Estanciero;

import com.Grupo2.Estanciero.src.models.Letras;
import com.Grupo2.Estanciero.src.models.Tablero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class EstancieroApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(EstancieroApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Tablero tablero = applicationContext.getBean(Tablero.class);

		Letras l = new Letras();
		boolean jugar = true;

		do {
			l.welcome();

			tablero.inciarPartida();


			tablero.jugarRonda();


			jugar = tablero.jugarDeNuevo();

		}while(jugar);

	}
}