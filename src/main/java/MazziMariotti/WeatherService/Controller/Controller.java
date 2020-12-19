package MazziMariotti.WeatherService.Controller;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;

import General.*;
import Stats_Filter.*;

	/**
	 * Classe dei controller per la getione delle richieste dal server.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */
@RestController
public class Controller {
	
	/**
	 * Controller richiesta GET "/città".
	 * @param city Nome dell città scelta
	 * @return JSONObject dati della singola città.
	 */
	@GetMapping("/citta")
	public API_SingleCity Rest_SingleCity(@RequestParam(name= "city", defaultValue= "nessuna_citta") String city) { 
		API_SingleCity single = new API_SingleCity();
		single.Download_SingleCity(city);
		return single;
	}
	
	/**
	 * Controller richiesta GET "/metadati".
	 * @return	JSONObject dati di tutte le città.
	 */
	
	@GetMapping("/metadati")
	public API_allCities Rest_allCities () { 
		API_allCities meta =new API_allCities();
		meta.Download_allCities();
		return meta;
	}
	
	/**
	 * Controller richiesta GET "/stats".
	 * @return Oggetto della statistica						//da rivedere!
	 */
	
	@GetMapping("/stats")  //Modificare con richiesta body per scegliere quali valori visualizzare del periodo inserito
	public JSONArray Rest_Statistics (@RequestParam(name= "period", defaultValue= "nessuna_periodo") int period) { 
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		stats.JsonFile_reader();
		/*Temp_Stats temp = new Temp_Stats (stats.getArray());
		return temp.reader(period);*/
		Hum_Stats hum = new Hum_Stats (stats.getArray());
		return hum.reader(period);
	}
	
}
