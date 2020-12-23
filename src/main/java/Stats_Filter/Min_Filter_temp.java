package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



	/**
	 * Classe per la restituzione del valore minimo della temperatura percepita giornaliera.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Min_Filter_temp {
	
	private JSONArray position_meta = new JSONArray();
	private int date[]= new int [3];
	
	private double Min;
	private long Min_l;
	private String City;
	
	public Min_Filter_temp( JSONArray A ) {
		
		position_meta=A;
		JSONObject o = new JSONObject();
		o= (JSONObject) position_meta.get(0);
		if(o.get("Temperatura percepita") instanceof Long) {
			Long l= new Long( (long) o.get("Temperatura percepita") );
			Min= l.doubleValue();
		}
		else Min=(double) o.get("Temperatura percepita");
		City= (String) o.get("Citta");
		
		date[0]= (int) o.get("anno");
		date[1]= (int) o.get("mese");
		date[2]= (int) o.get("giorno");
		
		for (int i=1; i<position_meta.size(); i++) {
			o=(JSONObject) position_meta.get(i);
			
			double support;
			if(o.get("Temperatura percepita") instanceof Long) {
				Long l= new Long( (long) o.get("Temperatura percepita") );
				support= l.doubleValue();
			}
			else support = (double) o.get("Temperatura percepita");
			
			if (Min > support) {
				Min = support;
				City= (String) o.get("Citta");
			}
		}
	}
	
	/**
	 * @return Città con la temperatura minima percepita.
	 */
	
	public String getCitta () {
		return City;
	}
	
	/**
	 * @return Temperatura minima percepita.
	 */
	
	public double getMin () {
		return Min;
	}
	
	/**
	 * @return Data giornaliera.
	 */
	
	public int [] getDate () {
		return date;
	}

}
