package MazziMariotti.WeatherService.Controller;

import java.io.EOFException;

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
	 * Controller richiesta POST "/stats".
	 * @return Oggetto della statistica	
	 */
	
	@PostMapping("/stats")
	public JSONArray body ( @RequestBody Body body ) {
		JSONFile_Mgmt stats = new JSONFile_Mgmt();
		stats.JsonFile_reader();
		if (body.isHum() && body.isTemp()) {
			
			Hum_Stats hum = new Hum_Stats (stats.getArray());
			Temp_Stats temp = new Temp_Stats (stats.getArray());
			JSONArray total = new JSONArray();
			
			total.add( hum.reader(body.getPeriod()) );
			total.add( temp.reader(body.getPeriod()) );
			
			return total;
			
		}
		
		if (body.isHum()) {
			
			Hum_Stats hum = new Hum_Stats (stats.getArray());
			return hum.reader(body.getPeriod());
			
		}
		
		if (body.isTemp()) {
			
			Temp_Stats temp = new Temp_Stats (stats.getArray());
			return temp.reader(body.getPeriod());
			
		}
		
		else return body.getA();
		
		}	
}
