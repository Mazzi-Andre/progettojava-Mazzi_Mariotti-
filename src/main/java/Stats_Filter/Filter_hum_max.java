package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_max {
	
	private JSONArray meta_position = new JSONArray();
	private long max;
	private String citta;
	
	public Filter_hum_max (JSONArray a) {
		meta_position = a;
		JSONObject o = new JSONObject();
		o= (JSONObject) meta_position.get(0);
		max = (long) o.get("Umidita");
		citta= (String) o.get("Citta");
		
		for (int i=1; i<a.size(); i++) {
			o = (JSONObject) meta_position.get(i);
			if (max < (long) o.get("Umidita")) {
				max = (long) o.get("Umidita");
				citta = (String) o.get("Citta");
			}
		}
	}
	
	public String getCitta () {
		return citta;
	}
	
	public long getMax () {
		return max;
	}
}
