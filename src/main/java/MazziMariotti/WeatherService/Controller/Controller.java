package MazziMariotti.WeatherService.Controller;

import org.springframework.web.bind.annotation.*;

import General.*;

@RestController
public class Controller {
	
	@GetMapping("/citta")
	public API_SingleCity città(@RequestParam(name= "city", defaultValue= "nessuna_citta") String city) { 
		return new API_SingleCity(city);
	}
	
	@GetMapping("/metadati")
	public API_allCities metadati () { 
		return new API_allCities();
	}

	
	
	
}
