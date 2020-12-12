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
import date_test.*;

public class API_allCities {
	
	//protected Vector <JSONObject> Cities = new Vector <JSONObject> ();
	private Vector <String> urls = new Vector <String> (); 
	private Vector <String> cities_names = new Vector <String> (); 
	protected JSONObject Cities_time =new JSONObject();
	private String current_date;
	private date d= new date();
	
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
		cities_names.add("Los Angles");
		cities_names.add("Miami");
		cities_names.add("New York");
		cities_names.add("Chicago");
		cities_names.add("New Orleans");
		cities_names.add("Boston");
		cities_names.add("Washington");	
	}
	
	public void Download_allCities () {
		Vector <JSONObject> Cities = new Vector <JSONObject> ();	
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
			current_date= (String)(d.getgiorno()+"/"+d.getmese()+"/"+d.getanno());
			Cities_time.put(current_date, Cities);
			
		} catch	(FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e ) {
				e.printStackTrace();
				//It's a very simple, but very useful tool for diagnosing an exceptions.
				//It tells you what happened and where in the code this happened.
		} catch (ParseException e) {
				e.printStackTrace();
		}
	}
	

	
	public JSONObject getValori () {
		return obj_con_data;
	}
}
