package MazziMariotti.WeatherService;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import Component.*;

@SpringBootApplication
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
		//request automatico (foto bramucci)
		
	}
	@Scheduled(fixedRate = 2000)
	void someone() {
		System.out.println("oggi è il "+ new Date());
		
	}

}

@Component
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enables", matchIfMissing=true)
class SchedulingCOnfiguration {
	
}
