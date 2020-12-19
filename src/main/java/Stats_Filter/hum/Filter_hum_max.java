package Stats_Filter.hum;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_max {
	
	private JSONArray a = new JSONArray();
	private double max;
	private long m;
	private String citta;
	
	public Filter_hum_max (JSONArray a) {
		this.a=a;
		max=0;
		citta=null;
		JSONObject o = new JSONObject();
		o= (JSONObject) this.a.get(0);
		m = (long) o.get("Umidita");
		citta= (String) o.get("Citta");
		
		for (int i=1; i<a.size(); i++) {
			o=(JSONObject) this.a.get(i);
			if (m < (long) o.get("Umidita")) {
				max=(long) o.get("Umidita");
				max=(double)m;
				citta= (String) o.get("Citta");
			}
		}
	}
	
	/*public void get_temp_max () {
		
	
	}*/
	
	public String getCitta () {
		return citta;
	}
	
	public double getMax () {
		return max;
	}
}
