package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private Filter_hum_min Fmin = new Filter_hum_min();
	private Filter_hum_max Fmax = new Filter_hum_max();
	
	private JSONArray Appoggio = new JSONArray();
	private int min;
	private int max;
	private String Cmin;
	private String Cmax;
	
	public Filter_hum_total () {
		
	}
	
	public void hum(JSONArray A, int period) {
		
		this.meta=A;
		//Appoggio = (JSONArray) this.meta.get(meta.size()-1);
		Fmin.hum_min((JSONArray) this.meta.get(meta.size()-1));
		
		for (int i=meta.size()-2; i > (meta.size()-period) ;i--) {
			
		}
	}

}
