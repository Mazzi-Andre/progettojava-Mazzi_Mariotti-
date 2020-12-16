package MazziMariotti.WeatherService;

import General.JSONFile_Mgmt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import Component.*;

	/**
	 * Classe per l'avvio dello SpringApplication e timer programmato.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */
@SpringBootApplication
public class WeatherServiceApplication {
	
	/**
	 * Al run del progetto si avvierà SpringBoot consentendo il collegamento Localhost alla porta 8080.
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
		//request automatico (foto bramucci)
		
	}
	
	/**
	 * Metodo per l'avvio programmato dell'autosave dei dati.
	 */
	@Scheduled(fixedRate = 7200000)
	void someone() {
		JSONFile_Mgmt meta_file= new JSONFile_Mgmt ();
		meta_file.Download_allCities();
		meta_file.JsonFile_save();
	}

}
	/**
	 * Classe di configurazione dei metodi Scheduled.
	 *
	 */

@Component
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enables", matchIfMissing=true)
class SchedulingCOnfiguration {
	
}
