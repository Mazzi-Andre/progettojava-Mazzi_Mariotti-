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
	
	public Tot_Filter_temp (JSONArray a) { 
		this.a=a;
		max=0;
		min=0;
		citta_max=null;
		citta_min=null;
	}
	
	public void tot_temp (int period) {
		JSONObject obj= new JSONObject();
		obj=(JSONObject) this.a.get(this.a.size()-1);
		M = new Max_Filter_temp ( (JSONArray) obj.get("citta"));
		m= new Min_Filter_temp ((JSONArray) obj.get("citta"));
		max = M.getMax();
		citta_max=M.getCitta();
		min= m.getMin();
		citta_min=m.getCitta();
			
		for (int i=this.a.size()-2; i>this.a.size()-period; i--) {
				
			obj= (JSONObject) this.a.get(i);
			m = new Min_Filter_temp ((JSONArray) obj.get("citta"));
			M = new Max_Filter_temp ((JSONArray) obj.get("citta"));
			if (max < M.getMax()) {
				max = M.getMax();
				citta_max = M.getCitta();
			}
			if (min > m.getMin()) {
				min = m.getMin();
				citta_min = m.getCitta();
			}	
		}
		JSONObject ar = new JSONObject();
		JSONObject ar2 = new JSONObject();
		ar.put("Citta", citta_max);
		ar.put("temperatura massima", max);
		ar2.put("Citta", citta_min);
		ar2.put("temperatura minima", min);
		tot_temp.add(ar);
		tot_temp.add(ar2);
		
	}
	
	public JSONArray getTot_temp () {
		return tot_temp;
	}
	
	
	
}
