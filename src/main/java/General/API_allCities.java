package General;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import Date_test.Date;

	/**
	 * Classe di gestione lettura tramite API openweather di tutte le città interessate.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */
public class API_allCities {
	
	protected Vector <String> urls = new Vector <String> (); 
	protected Vector <String> cities_names = new Vector <String> (); 
	protected JSONObject Cities_time = new JSONObject ();
	
	//Nel costruttore della classe: 1) si inizializza il Vector <String> contenente gli url API corrispondenti ai dati delle città interessate
	//				   2) si inizializza il Vector <String> contenente i nomi delle città interessate
	
	public API_allCities () {
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=6621230&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=5475433&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=5809844&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=5344994&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=5162774&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=5039192&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=4887398&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=4335045&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=4183849&appid=e253aeaf220a6c4bf5489677fafb6474");
		urls.add("https://api.openweathermap.org/data/2.5/weather?id=4177485&appid=e253aeaf220a6c4bf5489677fafb6474");
		cities_names.add("San Francisco");
		cities_names.add("Las Vegas");
		cities_names.add("Seattle");
		cities_names.add("Los Angeles");
		cities_names.add("Miami");
		cities_names.add("New York");
		cities_names.add("Chicago");
		cities_names.add("New Orleans");
		cities_names.add("Boston");
		cities_names.add("Washington");	
	}
	
	/**
	 * Metodo che consente il collegamento tramite API dei dati meteorologici delle principali
	 * città americane; Salvataggio di quest'ultimi in un JSONObject.
	 */
	
	public void Download_allCities () {
		
		String current_date;
		Date d= new Date();
		JSONArray Cities = new JSONArray ();
		
		try {	
		
			for (int i=0; i<urls.size(); i++) {
				
				HttpURLConnection openConnection =(HttpURLConnection) new URL(urls.get(i)).openConnection();
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
				JSONObject obj_weather=new JSONObject();
				obj_weather.put("Citta", cities_names.get(i));
				obj_weather.put("Temperatura percepita", obj_main.get("feels_like"));
				obj_weather.put("Umidità", obj_main.get("humidity"));
				Cities.add(obj_weather);
								
			}
			current_date= (String)(d.getDay()+"/"+d.getMonth()+"/"+d.getYear());
			Cities_time.put(current_date, Cities);
			
		} catch	(FileNotFoundException e) {
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
	 * @return Il JSONObject Cities_time contenenete informazioni su temperatura percepita
	 * e umidità di ogni città interessata.
	 */
	
	public JSONObject getValori () {
		return Cities_time;
	}
}
