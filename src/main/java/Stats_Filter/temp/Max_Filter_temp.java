package Stats_Filter.temp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Max_Filter_temp {
	
	private JSONArray a = new JSONArray();
	private double max;
	private String citta;
	
	public Max_Filter_temp (JSONArray a) {
		this.a=a;
		max=0;
		citta=null;
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
	
	/*public void get_temp_max () {
		
	
	}*/
	
	public String getCitta () {
		return citta;
	}
	
	public double getMax () {
		return max;
	}
}
