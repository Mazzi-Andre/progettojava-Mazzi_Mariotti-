package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

	/**
	 * Classe per la restituzione del valore minimo dell'umidità giornaliera.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Min_hum_filter {
	
	private JSONArray meta_position = new JSONArray();
	private int date[]= new int [3];
	
	private long Min;
	private String City;
	
	public Min_hum_filter ( JSONArray A ) {
		
		meta_position = A;
		JSONObject o = new JSONObject();
		o = (JSONObject) meta_position.get(0);
		if(o.get("Umidita") instanceof Double) {
			Double l= new Double( (double) o.get("Umidita") );
			Min= l.longValue();
		}
		else Min=(long) o.get("Umidita");
		City= (String) o.get("Citta");
		
		date[0]= (int) o.get("anno");
		date[1]= (int) o.get("mese");
		date[2]= (int) o.get("giorno");
		
		for (int i=1; i<meta_position.size(); i++) {
			
			o = (JSONObject) meta_position.get(i);
			
			long support;
			if(o.get("Umidita") instanceof Double) {
				Double l= new Double( (Double) o.get("Umidita") );
				support= l.longValue();
			}
			else support = (long) o.get("Umidita");
			
			if ( Min > support ) {
				Min =support; 
				City= (String) o.get("Citta");
				
			}
		}
	}
	
	/**
	 * @return Città con l'umidità minima.
	 */
	
	public String getCitta () {
		return City;
	}
	
	/**
	 * @return Umidità minima.
	 */
	
	public long getMin () {
		return Min;
	}
	
	/**
	 * @return Data giornaliera.
	 */
	
	public int [] getDate () {
		return date;
	}

}
