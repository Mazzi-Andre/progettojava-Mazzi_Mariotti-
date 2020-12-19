package Stats_Filter.hum;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Stats_Filter.Date_Filter;

public class Filter_hum_total {
	
	private JSONArray a = new JSONArray();
	private JSONArray tot_temp = new JSONArray();
	private Filter_hum_max M;
	private Filter_hum_min m;
	private double max;
	private String citta_max;
	private String citta_min;
	private double min;
	
	public Filter_hum_total (JSONArray a) { //= metafile
		this.a=a;
		max=0;
		min=0;
		citta_max=null;
		citta_min=null;
	}
	
	public void hum_tot (int period) {
		
		int time[] = new int [3];
		
		Date_Filter D = new Date_Filter ();
		JSONObject obj= new JSONObject();
		obj=(JSONObject) this.a.get(this.a.size()-1);
		M = new Filter_hum_max ( (JSONArray) obj.get("citta"));
		m= new Filter_hum_min ((JSONArray) obj.get("citta"));
		max = M.getMax();
		citta_max=M.getCitta();
		min= m.getMin();
		citta_min=m.getCitta();
		time[0] = m.getDate()[0];
		time[1] = m.getDate()[1];
		time[2] = m.getDate()[2];
		
		int i=this.a.size()-2;
		int comp=0;
		do {
			System.out.println(i+" "+comp);
			obj= (JSONObject) this.a.get(i);
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
		tot_temp.add(ar);
		tot_temp.add(ar2);
		
	}
	
	public JSONArray getTot_hum () {
		return tot_temp;
	}
	
	
}
