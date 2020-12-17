package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private Filter_hum_min Fmin = new Filter_hum_min();
	private Filter_hum_max Fmax = new Filter_hum_max();
	private JSONArray tot_temp = new JSONArray();
	
	private JSONArray Appoggio = new JSONArray();
	private int min;
	private int max;
	private String Cmin;
	private String Cmax;
	
	//Costruttore
	public Filter_hum_total () {}
	
	//funzione di filtraggio
	public void hum(JSONArray A, int period) {
		
		this.meta=A;
		//Appoggio = (JSONArray) this.meta.get(meta.size()-1);
		Fmin.hum_min((JSONArray) this.meta.get(meta.size()-1));
		Fmax.hum_max((JSONArray) this.meta.get(meta.size()-1));
		
		min = Fmin.getMin();
		Cmin =Fmin.getCitta();
		max= Fmax.getMax();
		Cmax = Fmax.getCitta();
		
		for (int i=meta.size()-2; i > (meta.size()-period) ;i--) {
			Fmin.hum_min((JSONArray) this.meta.get(meta.size()-i));
			Fmax.hum_max((JSONArray) this.meta.get(meta.size()-i));
			
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
		ar.put("temperatura massima", max);
		ar2.put("Citta", Cmin);
		ar2.put("temperatura minima", min);
		tot_temp.add(ar);
		tot_temp.add(ar2);
	}
	
	//funzione get JASONArray
	public JSONArray getTot_temp () {
		return tot_temp;
	}

}
