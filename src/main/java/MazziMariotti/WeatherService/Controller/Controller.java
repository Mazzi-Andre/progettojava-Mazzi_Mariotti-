package MazziMariotti.WeatherService.Controller;

import org.springframework.web.bind.annotation.*;

import General.*;

@RestController
public class Controller {
	
	@GetMapping("/citta")
	public API_SingleCity Rest_SingleCity(@RequestParam(name= "city", defaultValue= "nessuna_citta") String city) { 
		API_SingleCity single = new API_SingleCity();
		single.Download_SingleCity(city);
		return single;
	}
	
	@GetMapping("/metadati")
	public API_allCities Rest_allCities () { 
		API_allCities meta =new API_allCities();
		meta.Download_allCities();
		return meta;
	}
	
	@GetMapping("/stats")
	public JSONFile_Mgmt Rest_Statistics () { 
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		return stats;
	}
		
}
