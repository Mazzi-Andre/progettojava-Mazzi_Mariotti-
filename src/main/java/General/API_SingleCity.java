package General;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

	/**
	 * Classe di gestione lettura tramite API openweather di una singola città scelta dal client.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class API_SingleCity {
	
	private HashMap <String,String> id_city = new HashMap <String,String> ();
	private JSONObject City = new JSONObject();
	
	public API_SingleCity () {
		City=null;
		id_city.put("New York", "5039192");
		id_city.put("Los Angeles", "5344994");
		id_city.put("Las Vegas", "5475433");
		id_city.put("Miami", "5162744");
		id_city.put("San Francisco", "6621230");
		id_city.put("Washington", "4177485");
		id_city.put("Chicago", "4887398");
		id_city.put("Boston", "4183849");
		id_city.put("Seattle", "5809844");
		id_city.put("New Orleans", "4335045");		
	}
	
	/**
	 * Metodo che consente il collegamento tramite API dei dati meteorologici di una principale
	 * città americana; Salvataggio di quest'ultimi in un JSONObject.
	 * @param name Nome della citta scelta
	 */
	
	public void Download_SingleCity (String name) {
		
		try {
			
			HttpURLConnection openConnection =(HttpURLConnection) new URL("https://api.openweathermap.org/data/2.5/weather?id="+id_city.get(name)+"&appid=e253aeaf220a6c4bf5489677fafb6474").openConnection();
			openConnection.setRequestMethod("GET");
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true);				
			InputStream in = openConnection.getInputStream();
		
			String data = "";
			String line = "";
			
			try {
				BufferedReader buf = new BufferedReader (new InputStreamReader(in));
				
				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
				}
				
			} finally {
				in.close();
			}
			
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			JSONObject obj_main= (JSONObject) obj.get("main");
			
			City.put("Temperatura percepita", obj_main.get("feels_like"));
			City.put("Umidità", obj_main.get("humidity"));
		
		
		}catch	(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Il JSONObject City contenenete informazioni su temperatura percepita
	 * e umidità della città interessata.
	 */
	
	public JSONObject getCitta () {
		return City;
	}

}
