package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

	
	public String getCitta () {
		return citta;
	}
	
	public double getMax () {
		return max;
	}
}
