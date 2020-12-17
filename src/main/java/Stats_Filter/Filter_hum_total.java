package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private Filter_hum_min Fmin = new Filter_hum_min();
	private Filter_hum_max Fmax = new Filter_hum_max();
	private JSONArray tot_hum = new JSONArray();
	
	private JSONObject Appoggio = new JSONObject();
	private int min;
	private int max;
	private String Cmin;
	private String Cmax;
	
	//Costruttore
	public Filter_hum_total () {}
	
	//funzione di filtraggio
	public void hum(JSONArray A, int period) {
		this.meta=A;
		Appoggio = (JSONObject) this.meta.get(meta.size()-1);
		Fmin.hum_min((JSONArray) Appoggio.get("Citta"));
		Fmax.hum_max((JSONArray) Appoggio.get("Citta"));
		
		min = Fmin.getMin();
		Cmin =Fmin.getCitta();
		max= Fmax.getMax();
		Cmax = Fmax.getCitta();
		
		for (int i=meta.size()-2; i > (meta.size()-period) ;i--) {
			Appoggio = (JSONObject) this.meta.get(meta.size()-i);
			Fmin.hum_min((JSONArray) Appoggio.get("Citta"));
			Fmax.hum_max((JSONArray) Appoggio.get("Citta"));
			
			if (max < Fmax.getMax()) {
				max = Fmax.getMax();
				Cmax = Fmax.getCitta();
			}
			if (min > Fmin.getMin()) {
				min = Fmin.getMin();
				Cmin = Fmin.getCitta();
			}	
		}
		JSONObject ar = new JSONObject();
		JSONObject ar2 = new JSONObject();
		ar.put("Citta", Cmax);
		ar.put("Umidità massima", max);
		ar2.put("Citta", Cmin);
		ar2.put("Umidità minima", min);
		tot_hum.add(ar);
		tot_hum.add(ar2);
	}
	
	//funzione get JASONArray
	public JSONArray getTot_hum () {
		return tot_hum;
	}

}
