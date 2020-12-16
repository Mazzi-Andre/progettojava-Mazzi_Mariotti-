package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_temp_max {
	
	private JSONArray a = new JSONArray();
	private double max;
	private String citta;
	
	public Filter_temp_max (JSONArray a) {
		this.a=a;
		max=0;
		citta=null;
	}
	
	public void get_temp_max () {
		
		JSONObject o = new JSONObject();
		o= (JSONObject) this.a.get(0);
		max= (double) o.get("Temperatura percepita");
		citta= (String) o.get("Citta");
		
		for (int i=1; i<a.size(); i++) {
			o=(JSONObject) this.a.get(i);
			if (max < (double) o.get("Temperatura percepita")) {
				max=(double) o.get("Temperatura percepita");
				citta= (String) o.get("Citta");
			}
		}
	}
	
	public String getCitta () {
		return citta;
	}
	
	public double getMax () {
		return max;
	}
}
