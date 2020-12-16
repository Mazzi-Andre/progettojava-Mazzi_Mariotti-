package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_temp_tot {
	
	private JSONArray a = new JSONArray();
	private JSONArray tot_temp = new JSONArray();
	private Filter_temp_max M;
	private Filter_temp_min m;
	private double max;
	private String citta_max;
	private String citta_min;
	private double min;
	
	public Filter_temp_tot (JSONArray a) { //che sarà meta_file
		this.a=a;
		max=0;
		min=0;
		citta_max=null;
		citta_min=null;
	}
	
	public void tot_temp (int period) {
		JSONArray obj= new JSONArray();
		obj=(JSONArray) this.a.get(this.a.size()-1);
		M = new Filter_temp_max (obj);
		m= new Filter_temp_min (obj);
		max = M.getMax();
		citta_max=M.getCitta();
		min= m.getMin();
		citta_min=m.getCitta();
			
		for (int i=this.a.size()-2; i>this.a.size()-period; i--) {
				
			obj= (JSONArray) this.a.get(i);
			m = new Filter_temp_min (obj);
			M = new Filter_temp_max (obj);
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
