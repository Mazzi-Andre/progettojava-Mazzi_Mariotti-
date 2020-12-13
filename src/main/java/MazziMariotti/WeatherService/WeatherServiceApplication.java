package MazziMariotti.WeatherService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Component.*;

@SpringBootApplication
public class WeatherServiceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
		//request automatico (foto bramucci)
		
		Components j = new Components();
		j.avvioConIntervalloFissoTraEsecuzioni();
		
	}

}
