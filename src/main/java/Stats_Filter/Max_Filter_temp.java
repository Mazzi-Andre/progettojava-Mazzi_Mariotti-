package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


	/**
	 * Classe per la restituzione del valore massimo della temperatura percepita giornaliera.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Max_Filter_temp {
	
	private JSONArray position_meta = new JSONArray();
	private double max;
	private String citta;
	
	public Max_Filter_temp ( JSONArray a ) {
		
		position_meta=a;
		JSONObject o = new JSONObject();
		o = (JSONObject) position_meta.get(0);
		max = (double) o.get("Temperatura percepita");
		citta = (String) o.get("Citta");
		
		for (int i=1; i<a.size(); i++) {
			
			o=(JSONObject) position_meta.get(i);
			if (max < (double) o.get("Temperatura percepita")) {
				max = (double) o.get("Temperatura percepita");
				citta= (String) o.get("Citta");
				
			}
		}
	}

	/**
	 * @return Città con la temperatura massima percepita.
	 */
	
	public String getCitta () {
		return citta;
	}
	
	/**
	 * @return Temperatura massima percepita.
	 */
	
	public double getMax () {
		return max;
	}
}
