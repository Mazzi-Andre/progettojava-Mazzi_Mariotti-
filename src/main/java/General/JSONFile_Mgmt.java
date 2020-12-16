package General;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import date_test.Date;

	/**
	 * Classe di gestione lettura e scrittura file json.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class JSONFile_Mgmt extends API_allCities{
	private JSONObject Stats_data = new JSONObject (); // da cancellare 
	private JSONArray meta_file = new JSONArray();
	
	public JSONFile_Mgmt () {
		super();
	}
	
	/**
	 * Overriding del metodo Download_allCities, utilizzata per salvare dati all'interno di un file JSON;
	 * Utilizzato per una lettura più facilitata del file 
	 */
	
	public void Download_allCities () {
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
				obj_weather.put("giorno", d.getDay());
				obj_weather.put("mese", d.getMonth());
				obj_weather.put("anno", d.getYear());
				Cities.add(obj_weather);
								
			}
			Cities_time.put("citta", Cities);
			
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
	
	/**
	 * Metodo per la scrittura della temperatura percepita e umidità di tutte le città su un unico file .json
	 */
	public void JsonFile_save () {
		try {
			ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("File.json",true))) {
				protected void writeStreamHeader() throws IOException {
				
					reset();
				}
			};
			file_output.writeObject(Cities_time);
			file_output.close();			
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo per la lettura personalizzata in base alla statistica, del file .json  
	 */
	
	public void JsonFile_reader () {
		
		try { 
		    ObjectInputStream file_input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("File.json")));

		    while(true) {
		    	meta_file.add((JSONObject) file_input.readObject());
		        
		     }
		    
		} catch(EOFException e) {
		       System.out.println("File finito");
		} catch (IOException e) {
		        e.printStackTrace();
		} catch (ClassNotFoundException e) {
		        e.printStackTrace();
		}
		
	}
	
	/**
	 * @return oggetto della statistica.
	 */
	
	/*public JSONObject getStatistica () {
		return Stats_data;
	}*/
	
	public JSONArray getArray () {
		return meta_file;
	}
	
}
