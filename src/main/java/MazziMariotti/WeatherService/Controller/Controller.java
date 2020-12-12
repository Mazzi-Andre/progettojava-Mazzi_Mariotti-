package MazziMariotti.WeatherService.Controller;

import org.springframework.web.bind.annotation.*;

import General.*;

@RestController
public class Controller {
	
	@GetMapping("/citta")
	public API_SingleCity città(@RequestParam(name= "city", defaultValue= "nessuna_citta") String city) { 
		API_SingleCity single = new API_SingleCity();
		single.Download_SingleCity(city);
		return single;
	}
	
	@GetMapping("/metadati")
	public API_allCities metadati () { 
		API_allCities meta =new API_allCities();
		meta.Download_allCities();
		return meta;
	}
	
	@GetMapping("/stats")
	public JSONFile_Mgmt statistics () { 
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		return stats;
	}
		
}
