package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private Filter_hum_min Fmin = new Filter_hum_min();
	private Filter_hum_max Fmax = new Filter_hum_max();
	private JSONArray tot_hum = new JSONArray();
	
	private JSONObject Appoggio = new JSONObject();
	private long min;
	private long max;
	private String Cmin;
	private String Cmax;
	
	//Costruttore
	public Filter_hum_total () {}
	
	//funzione di filtraggio
	public void hum( JSONArray A, int period) {
		try {
			
		
		this.meta=(JSONArray) A;
		System.out.println(this.meta.size());
		Date_Filter date = new Date_Filter ();
		Appoggio = (JSONObject) this.meta.get(meta.size()-1);
		JSONArray a= new JSONArray();
		a=(JSONArray) Appoggio.get("citta");
		System.out.println(Appoggio.get("citta"));
		Fmin.hum_min(a);
		Fmax.hum_max(a);
		
		
		min = Fmin.getMin();
		Cmin =Fmin.getCitta();
		max= Fmax.getMax();
		Cmax = Fmax.getCitta();
		int time[]=Fmin.getDate();
		
		for (int i=meta.size()-2; i > (meta.size()-period) ;i--) {
			
			
				Appoggio = (JSONObject) this.meta.get(i);
				Fmin.hum_min((JSONArray) Appoggio.get("Citta"));
				Fmax.hum_max((JSONArray) Appoggio.get("Citta"));
				if (date.check(time, Fmin.getDate())) {
				if (max < Fmax.getMax()) {
					max = Fmax.getMax();
					Cmax = Fmax.getCitta();
				}
				if (min > Fmin.getMin()) {
					min = Fmin.getMin();
					Cmin = Fmin.getCitta();
				}
				
			}
			time=Fmin.getDate();
		}
		JSONObject ar = new JSONObject();
		JSONObject ar2 = new JSONObject();
		ar.put("Citta", Cmax);
		ar.put("Umidità massima", max);
		ar2.put("Citta", Cmin);
		ar2.put("Umidità minima", min);
		tot_hum.add(ar);
		tot_hum.add(ar2);
		
	}catch (NullPointerException e) {
		System.out.println(e);
		System.out.println("errore null pointer Filter_hum_tot");
	}
		catch (Exception e) {
		System.out.println(e);
	}
	
	}
	
	//funzione get JASONArray
	public JSONArray getTot_hum () {
		return tot_hum;
	}

}
