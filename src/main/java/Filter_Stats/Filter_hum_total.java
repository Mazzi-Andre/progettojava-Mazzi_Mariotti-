package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private Filter_hum_min Fmin = new Filter_hum_min();
	private Filter_hum_max Fmax = new Filter_hum_max();
	
	private JSONObject Appoggio = new JSONObject();
	private int min;
	private int max;
	private String Cmin;
	private String Cmax;
	
	public Filter_hum_total () {
		
	}
	
	public void hum(JSONArray A) {
		
		this.meta=A;
		Appoggio = ()
		Fmin.hum_min(meta.get(meta.size()-1));
		
		for (int i=meta.size()-1; i>0 ;i--) {
			
		}
	}

}
