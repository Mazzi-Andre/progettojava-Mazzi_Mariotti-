package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_total {
	
	private JSONArray meta = new JSONArray();
	private JSONArray tot_hum = new JSONArray();
	
	public Filter_hum_total ( JSONArray a ) {
		meta = a;
	}
	
	public void hum_tot (int period) {
		
		Filter_hum_max M;
		Filter_hum_min m;
		
		int time[] = new int [3];
		
		Date_Filter D = new Date_Filter ();
		
		JSONObject obj= new JSONObject();
		
		obj=(JSONObject) meta.get(meta.size()-1);
		M = new Filter_hum_max ( (JSONArray) obj.get("citta"));
		m = new Filter_hum_min ((JSONArray) obj.get("citta"));
		long max = M.getMax();
		String citta_max = M.getCitta();
		long min = m.getMin();
		String citta_min = m.getCitta();
		
		time[0] = m.getDate()[0];
		time[1] = m.getDate()[1];
		time[2] = m.getDate()[2];
		
		int i = meta.size()-2;
		int comp = 1;
		do {
			obj= (JSONObject) meta.get(i);
			m = new Filter_hum_min ((JSONArray) obj.get("citta"));
			M = new Filter_hum_max ((JSONArray) obj.get("citta"));
			
			if ( D.check(time, m.getDate()) ) {   //se sono diversi 
				if (max < M.getMax()) {
					max = M.getMax();
					citta_max = M.getCitta();
				}
				if (min > m.getMin()) {
					min = m.getMin();
					citta_min = m.getCitta();
				}
				
				comp++;
				
				time[0] = m.getDate()[0];
				time[1] = m.getDate()[1];
				time[2] = m.getDate()[2];
			}
			i--;			
			
		} while ( comp < period-1 );
	
		JSONObject ar = new JSONObject();
		JSONObject ar2 = new JSONObject();
		ar.put("Citta", citta_max);
		ar.put("Umidita massima", max);
		ar2.put("Citta", citta_min);
		ar2.put("Umidita minima", min);
		tot_hum.add(ar);
		tot_hum.add(ar2);
		
	}
	
	public JSONArray getTot_hum () {
		return tot_hum;
	}
	
	
}
