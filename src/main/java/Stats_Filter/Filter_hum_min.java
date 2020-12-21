package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_min {
	
	private JSONArray meta_position = new JSONArray();
	private int date[]= new int [3];
	
	private long Min;
	private String City;
	
	public Filter_hum_min ( JSONArray A ) {
		
		meta_position = A;
		JSONObject o = new JSONObject();
		o = (JSONObject) meta_position.get(0);
		Min = (long) o.get("Umidita");
		City= (String) o.get("Citta");
		
		date[0]= (int) o.get("anno");
		date[1]= (int) o.get("mese");
		date[2]= (int) o.get("giorno");
		
		for (int i=1; i<meta_position.size(); i++) {
			o = (JSONObject) meta_position.get(i);
			if ( Min > (long) o.get("Umidita") ) {
				Min =(long) o.get("Umidita"); 
				City= (String) o.get("Citta");
			}
		}
	}
	
	public String getCitta () {
		return City;
	}
	
	public long getMin () {
		return Min;
	}
	
	public int [] getDate () {
		return date;
	}

}