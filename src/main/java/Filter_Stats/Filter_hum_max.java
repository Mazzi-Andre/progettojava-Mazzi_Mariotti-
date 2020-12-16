package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_max {
	private JSONArray a = new JSONArray();
	private int max;
	private String citta;
	
	public Filter_hum_max (JSONArray a) {
		this.a=a;
		JSONObject o = new JSONObject();
		o= (JSONObject) this.a.get(0);
		max= (int) o.get("Umidità");
		citta= (String) o.get("Citta");
		
		for (int i=1; i<a.size(); i++) {
			o=(JSONObject) this.a.get(i);
			if (max < (double) o.get("Umidità")) {
				max=(int) o.get("Umidità");
				citta= (String) o.get("Citta");
			}
		}
	}
	
/*public void get_hum_max () {
		
		
	}*/
	
	public String getCitta () {
		return citta;
	}
	
	public int getMax () {
		return max;
	}
}
