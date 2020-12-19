package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Tot_Filter_temp {
	
	private JSONArray a = new JSONArray();
	private JSONArray tot_temp = new JSONArray();
	private Max_Filter_temp M;
	private Min_Filter_temp m;
	private double max;
	private String citta_max;
	private String citta_min;
	private double min;
	
	public Tot_Filter_temp (JSONArray a) { //= metafile
		this.a=a;
		max=0;
		min=0;
		citta_max=null;
		citta_min=null;
	}
	
	public void tot_temp (int period) {
		
		int time[] = new int [3];
		
		Date_Filter D = new Date_Filter ();
		JSONObject obj= new JSONObject();
		obj=(JSONObject) this.a.get(this.a.size()-1);
		M = new Max_Filter_temp ( (JSONArray) obj.get("citta"));
		m= new Min_Filter_temp ((JSONArray) obj.get("citta"));
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
			m = new Min_Filter_temp ((JSONArray) obj.get("citta"));
			M = new Max_Filter_temp ((JSONArray) obj.get("citta"));
			
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
		ar.put("Temperatura massima", max);
		ar2.put("Citta", citta_min);
		ar2.put("Temperatura minima", min);
		tot_temp.add(ar);
		tot_temp.add(ar2);
		
	}
	
	public JSONArray getTot_temp () {
		return tot_temp;
	}
	
	
	
}
